/**
 *
 */
package en.hybris.platform.recipes.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.recipes.daos.RecipeDAO;
import en.hybris.platform.recipes.model.FoodModel;
import en.hybris.platform.recipes.model.MenuModel;
import en.hybris.platform.recipes.model.RecipeEntryModel;
import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */
public class DefaultRecipeDAO implements RecipeDAO
{



	private FlexibleSearchService flexibleSearchService;



	@Override
	public List<RecipeModel> findRecipeByCode(final String code)
	{

		//final String queryString = "SELECT {r.pk} FROM {Recipe as r} WHERE {r.code} = ?code";
		final String queryString = "SELECT {r:" + RecipeModel.PK + "} " + "FROM {" + RecipeModel._TYPECODE //
				+ " AS r} WHERE " + RecipeModel.CODE + " = " + code;

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();
	}

	/*
	 * @see en.hybris.platform.recipes.daos.RecipesDAO#findRecipeByFoodCode(java.lang.String)
	 */
	@Override
	public List<RecipeModel> findRecipeByFoodCode(final String code)
	{

		final String queryString = "SELECT {r:" + RecipeModel.PK + "} " + "FROM {" //
				+ RecipeModel._TYPECODE + " AS r JOIN " + RecipeEntryModel._TYPECODE + //
				" AS re ON r:" + RecipeModel.PK + " = re:" + RecipeEntryModel.RECIPE //
				+ "JOIN " + FoodModel._TYPECODE + " AS f ON re:" + RecipeEntryModel.FOOD + "= f:" + FoodModel.PK //
				+ "} WHERE f:" + FoodModel.CODE + " = " + code;


		//final String queryString = "SELECT {r.pk} FROM {Recipe as r JOIN RecipeEntry as re ON {r.pk} = {re.recipe}}//"
		//	+ "JOIN Food as f ON {re.food} = {f.pk} WHERE {f.code} = ?code";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();

	}

	/*
	 * @see en.hybris.platform.recipes.daos.RecipesDAO#findRecipeByFoodCodeAndServings(java.lang.String, int)
	 */
	@Override
	public List<RecipeModel> findRecipeByFoodCodeAndServings(final String code, final int servings)
	{


		final String queryString = "SELECT {r:" + RecipeModel.PK + "} " + "FROM {" //
				+ RecipeModel._TYPECODE + " AS r JOIN " + RecipeEntryModel._TYPECODE + //
				" AS re ON r:" + RecipeModel.PK + " = re:" + RecipeEntryModel.RECIPE //
				+ "JOIN " + FoodModel._TYPECODE + " AS f ON re:" + RecipeEntryModel.FOOD + "= f:" + FoodModel.PK //
				+ "} WHERE f:" + FoodModel.CODE + " = " + code + " AND r:" + RecipeModel.SERVINGS + "=" + servings;


		//final String queryString = "SELECT {r.pk} FROM {Recipe as r JOIN RecipeEntry as re ON {r.pk} = {re.recipe}}//"
		//		+ "JOIN Food as f ON {re.food} = {f.pk} WHERE {f.code} = ?code AND {r.servings} =?servings ";


		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();

	}


	@Override
	public List<RecipeModel> findRecipes()
	{

		final String queryString = "SELECT * FROM {Recipe}";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();
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
