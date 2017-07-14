/**
 *
 */
package en.hybris.platform.recipes.facedes.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.recipes.RecipeService;
import en.hybris.platform.recipes.data.RecipeData;
import en.hybris.platform.recipes.facedes.RecipeFacade;
import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */
public class DefaultRecipeFacade implements RecipeFacade
{

	private RecipeService recipeService;

	/*
	 * @see en.hybris.platform.recipes.facedes.RecipeFacade#getRecipeForCode(java.lang.String)
	 */
	@Override
	public RecipeData getRecipeForCode(final String code)
	{

		final RecipeModel recipeModels = recipeService.getRecipeByCode(code);


		final RecipeData rfd = new RecipeData();
		rfd.setCode(recipeModels.getCode());
		rfd.setName(recipeModels.getName());
		rfd.setPreparationTime(recipeModels.getPreparationTime());
		rfd.setServings(recipeModels.getServings());



		return rfd;
	}

	/*
	 * @see en.hybris.platform.recipes.facedes.RecipeFacade#getRecipeForFoodCode(java.lang.String)
	 */
	@Override
	public List<RecipeData> getRecipeForFoodCode(final String code)
	{

		final List<RecipeModel> recipeModels = recipeService.getRecipeByFoodCode(code);
		final List<RecipeData> recipeFacadeData = new ArrayList<RecipeData>();

		for (final RecipeModel rm : recipeModels)
		{
			final RecipeData rfd = new RecipeData();
			rfd.setCode(rm.getCode());
			rfd.setName(rm.getName());
			//rfd.setPreparationTime(rm.getPreparationTime());
			//rfd.setServings(rm.getServings());
			recipeFacadeData.add(rfd);
		}

		return recipeFacadeData;
	}

	/*
	 * @see en.hybris.platform.recipes.facedes.RecipeFacade#getRecipeForFoodCodeAndNumberOfServings(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<RecipeData> getRecipeForFoodCodeAndNumberOfServings(final String code, final int servings)
	{
		final List<RecipeModel> recipeModels = recipeService.getRecipeByFoodCodeAndServings(code, servings);
		final List<RecipeData> recipeFacadeData = new ArrayList<RecipeData>();

		for (final RecipeModel rm : recipeModels)
		{
			final RecipeData rfd = new RecipeData();
			rfd.setCode(rm.getCode());
			rfd.setName(rm.getName());
			rfd.setPreparationTime(rm.getPreparationTime());
			rfd.setServings(rm.getServings());
			recipeFacadeData.add(rfd);
		}

		return recipeFacadeData;
	}

	@Required
	public void setRecipeService(final RecipeService recipeService)
	{
		this.recipeService = recipeService;
	}



}
