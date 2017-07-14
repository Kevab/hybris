/**
 *
 */
package org.training.uiip.recipesuiip.daos;

import java.util.Collection;

import org.training.uiip.recipesuiip.model.MenuModel;
import org.training.uiip.recipesuiip.model.RecipeModel;



/**
 * @author fpalmieri
 *
 */
public interface RecipeDao
{

	Collection<RecipeModel> findAllRecipes();

	Collection<RecipeModel> findRecipeByCode(String code);

	Collection<RecipeModel> findRecipesByFoodCode(String foodCode);

	Collection<RecipeModel> findRecipesByFoodCodeAndServings(String foodCode, int servings);

	Collection<MenuModel> findMenuByCode(String menuCode);

}
