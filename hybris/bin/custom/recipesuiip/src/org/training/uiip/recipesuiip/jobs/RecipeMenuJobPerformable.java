/**
 *
 */
package org.training.uiip.recipesuiip.jobs;

import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;
import org.training.uiip.recipesuiip.daos.RecipeDao;

import en.hybris.platform.recipes.model.MenuModel;
import en.hybris.platform.recipes.model.RecipeModel;



/**
 * @author fpalmieri
 *
 */
public class RecipeMenuJobPerformable extends AbstractJobPerformable<CronJobModel>
{
	private RecipeDao recipeDao;

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		final Collection<RecipeModel> recipes = recipeDao.findAllRecipes();
		final Map<Integer, List<RecipeModel>> recipesByServingsMap = populateRecipesByServingsMap(recipes);
		for (final Map.Entry<Integer, List<RecipeModel>> entry : recipesByServingsMap.entrySet())
		{
			final String menuCode = "menu" + entry.getKey() + "servings";
			final Collection<MenuModel> menuResult = recipeDao.findMenuByCode(menuCode);
			final MenuModel menuModel;
			if (CollectionUtils.isEmpty(menuResult))
			{
				menuModel = modelService.create(MenuModel.class);
				menuModel.setCode(menuCode);
				menuModel.setName("Menu for " + entry.getKey() + " servings");
			}
			else
			{
				menuModel = menuResult.iterator().next();
			}
			menuModel.setRecipes(entry.getValue());
			modelService.save(menuModel);
		}
		return null;
	}

	private Map<Integer, List<RecipeModel>> populateRecipesByServingsMap(final Collection<RecipeModel> recipes)
	{
		final Map<Integer, List<RecipeModel>> recipesByServingsMap = new HashMap<>();
		for (final RecipeModel recipe : recipes)
		{
			List<RecipeModel> recipesForServings = new ArrayList<>();
			final Integer servings = recipe.getServings();
			if (recipesByServingsMap.containsKey(servings))
			{
				recipesForServings = recipesByServingsMap.get(servings);
				recipesForServings.add(recipe);
			}
			recipesByServingsMap.put(servings, recipesForServings);
		}
		return recipesByServingsMap;
	}

	@Required
	public void setRecipeDao(final RecipeDao recipeDao)
	{
		this.recipeDao = recipeDao;
	}
}
