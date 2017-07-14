/**
 *
 */
package org.training.uiip.recipesuiip.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;
import org.training.uiip.recipesuiip.daos.RecipeDao;
import org.training.uiip.recipesuiip.model.MenuModel;
import org.training.uiip.recipesuiip.model.RecipeModel;


/**
 * @author fpalmieri
 *
 */
public class DefaultRecipeDao implements RecipeDao
{

	private FlexibleSearchService flexibleSearchService;

	@Override
	public Collection<RecipeModel> findAllRecipes()
	{
		final String query = "SELECT {r.pk} FROM {Recipe as r}";
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query);
		final SearchResult<RecipeModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}

	@Override
	public Collection<RecipeModel> findRecipeByCode(final String code)
	{
		final String query = "SELECT {r.pk} FROM {Recipe as r} WHERE {r.code} = ?code";
		final Map<String, String> params = new HashMap<>();
		params.put("code", code);
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query, params);
		final SearchResult<RecipeModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}

	@Override
	public Collection<RecipeModel> findRecipesByFoodCode(final String foodCode)
	{
		final String query = "SELECT {r.pk} FROM {Recipe as r JOIN RecipeEntry as re ON {r.pk} = {re.recipe} JOIN Product as p ON {re.product} = {p.pk}} WHERE {p.code} = ?foodCode";
		final Map<String, String> params = new HashMap<>();
		params.put("foodCode", foodCode);
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query, params);
		final SearchResult<RecipeModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}

	@Override
	public Collection<RecipeModel> findRecipesByFoodCodeAndServings(final String foodCode, final int servings)
	{
		final String query = "SELECT {r.pk} FROM {Recipe as r JOIN RecipeEntry as re ON {r.pk} = {re.recipe} JOIN Product as p ON {re.product} = {p.pk}} WHERE {p.code} = ?foodCode AND {r.servings} = ?servings";
		final Map<String, String> params = new HashMap<>();
		params.put("foodCode", foodCode);
		params.put("servings", String.valueOf(servings));
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query, params);
		final SearchResult<RecipeModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}

	@Override
	public Collection<MenuModel> findMenuByCode(final String menuCode)
	{
		final String query = "SELECT {m.pk} FROM {Menu as m} WHERE {m.code} = ?menuCode";
		final Map<String, String> params = new HashMap<>();
		params.put("menuCode", menuCode);
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(query, params);
		final SearchResult<MenuModel> result = flexibleSearchService.search(fsq);
		return result.getResult();
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

}
