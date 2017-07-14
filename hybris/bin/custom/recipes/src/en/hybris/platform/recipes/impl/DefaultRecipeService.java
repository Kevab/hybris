/**
 *
 */
package en.hybris.platform.recipes.impl;

import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.recipes.RecipeService;
import en.hybris.platform.recipes.daos.RecipeDAO;
import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */


public class DefaultRecipeService implements RecipeService
{

	private RecipeDAO recipeDAO;

	/*
	 * @see en.hybris.platform.recipes.RecipeService#getRecipeByCode(java.lang.String)
	 */
	@Override
	public RecipeModel getRecipeByCode(final String code)
	{
		final List<RecipeModel> toReturn;
		toReturn = recipeDAO.findRecipeByCode(code);

		return toReturn.get(0);
	}

	/*
	 * @see en.hybris.platform.recipes.RecipeService#getRecipeByFoodCode(java.lang.String)
	 */
	@Override
	public List<RecipeModel> getRecipeByFoodCode(final String code)
	{

		final List<RecipeModel> result = recipeDAO.findRecipeByFoodCode(code);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Recipe with code '" + code + "' not found!");
		}

		return result;
	}

	/*
	 * @see en.hybris.platform.recipes.RecipeService#getRecipeByFoodCodeAndServings(java.lang.String, java.lang.String)
	 */
	@Override
	public List<RecipeModel> getRecipeByFoodCodeAndServings(final String code, final int servings)
	{
		final List<RecipeModel> result = recipeDAO.findRecipeByFoodCodeAndServings(code, servings);
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Recipe with code '" + code + "' not found!");
		}

		return result;
	}

	@Required
	public void setRecipeDAO(final RecipeDAO recipeDAO)
	{
		this.recipeDAO = recipeDAO;
	}

}
