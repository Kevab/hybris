/**
 *
 */
package en.hybris.platform.recipes.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.recipes.daos.RecipesDAO;
import en.hybris.platform.recipes.model.FoodModel;
import en.hybris.platform.recipes.model.RecipeEntryModel;
import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */
public class DefaultRecipeDAO implements RecipesDAO
{

	/*
	 * @see en.hybris.platform.recipes.daos.RecipesDAO#findRecipeByCode(java.lang.String)
	 */
	//@Autowired
	private FlexibleSearchService flexibleSearchService;

	public FlexibleSearchService getFlexibleSearchService()
	{
		return flexibleSearchService;
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	@Override
	public List<RecipeModel> findRecipeByCode(final String code)
	{

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

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<RecipeModel> search(query).getResult();

	}

}
