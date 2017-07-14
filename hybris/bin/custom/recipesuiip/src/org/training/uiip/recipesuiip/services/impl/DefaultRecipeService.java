/**
 *
 */
package org.training.uiip.recipesuiip.services.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;
import org.training.uiip.recipesuiip.daos.RecipeDao;
import org.training.uiip.recipesuiip.model.RecipeModel;
import org.training.uiip.recipesuiip.services.RecipeService;


/**
 * @author fpalmieri
 *
 */
public class DefaultRecipeService implements RecipeService
{

	private RecipeDao recipeDao;

	@Override
	public RecipeModel getRecipeForCode(final String code)
	{
		final Collection<RecipeModel> result = recipeDao.findRecipeByCode(code);
		if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException("message");
		}
		else if (result.isEmpty())
		{
			throw new UnknownIdentifierException("message");
		}
		return result.iterator().next();
	}

	@Override
	public Collection<RecipeModel> getRecipesForFoodCode(final String foodCode)
	{
		final Collection<RecipeModel> result = recipeDao.findRecipesByFoodCode(foodCode);
		return result;
	}

	@Override
	public Collection<RecipeModel> getRecipesForFoodCodeAndServings(final String foodCode, final int servings)
	{
		final Collection<RecipeModel> result = recipeDao.findRecipesByFoodCodeAndServings(foodCode, servings);
		return result;
	}

	@Required
	public void setRecipeDao(final RecipeDao recipeDao)
	{
		this.recipeDao = recipeDao;
	}
}
