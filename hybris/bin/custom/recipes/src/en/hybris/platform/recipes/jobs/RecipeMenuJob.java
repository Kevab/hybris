/**
 *
 */
package en.hybris.platform.recipes.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.JobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.recipes.daos.RecipeDAO;
import en.hybris.platform.recipes.model.MenuModel;
import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */
public class RecipeMenuJob implements JobPerformable<CronJobModel>
{




	private RecipeDAO recipeDAO;
	private ModelService modelService;




	@Override
	public boolean isAbortable()
	{
		// YTODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isPerformable()
	{
		// YTODO Auto-generated method stub
		return false;
	}


	@Override
	public PerformResult perform(final CronJobModel arg0)
	{
		final Collection<RecipeModel> recipes = recipeDAO.findRecipes();
		final Map<Integer, List<RecipeModel>> recipesByServingsMap = populateRecipesByServingsMap(recipes);

		for (final Map.Entry<Integer, List<RecipeModel>> entry : recipesByServingsMap.entrySet())
		{
			final String menuCode = "menu" + entry.getKey() + "servings";
			final Collection<MenuModel> menuResult = recipeDAO.findMenuByCode(menuCode);
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
			menuModel.setRecipe(entry.getValue());
			modelService.save(menuModel);
		}
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
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
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	@Required
	public void setRecipeDAO(final RecipeDAO recipeDAO)
	{
		this.recipeDAO = recipeDAO;
	}
}