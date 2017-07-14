/**
 *
 */
package org.training.uiip.recipesuiip.facades.impl;

import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.training.uiip.recipesuiip.data.RecipeData;
import org.training.uiip.recipesuiip.facades.RecipeFacade;
import org.training.uiip.recipesuiip.model.RecipeModel;
import org.training.uiip.recipesuiip.services.RecipeService;


/**
 * @author fpalmieri
 *
 */
public class DefaultRecipeFacade implements RecipeFacade
{

	private RecipeService recipeService;
	private AbstractPopulatingConverter<RecipeModel, RecipeData> recipeConverter;

	@Override
	public RecipeData getRecipeForCode(final String code)
	{
		final RecipeModel recipeModel = recipeService.getRecipeForCode(code);
		final RecipeData toReturn = recipeConverter.convert(recipeModel);
		return toReturn;
	}

	@Override
	public List<RecipeData> getRecipesForFoodCode(final String foodCode)
	{
		final Collection<RecipeModel> recipeModels = recipeService.getRecipesForFoodCode(foodCode);
		final List<RecipeData> toReturn = Converters.convertAll(recipeModels, recipeConverter);
		return toReturn;
	}

	@Override
	public List<RecipeData> getRecipesForFoodCodeAndServings(final String foodCode, final int servings)
	{
		final Collection<RecipeModel> recipeModels = recipeService.getRecipesForFoodCodeAndServings(foodCode, servings);
		final List<RecipeData> toReturn = Converters.convertAll(recipeModels, recipeConverter);
		return toReturn;
	}

	@Required
	public void setRecipeService(final RecipeService recipeService)
	{
		this.recipeService = recipeService;
	}

	@Required
	public void setRecipeConverter(final AbstractPopulatingConverter<RecipeModel, RecipeData> recipeConverter)
	{
		this.recipeConverter = recipeConverter;
	}
}
