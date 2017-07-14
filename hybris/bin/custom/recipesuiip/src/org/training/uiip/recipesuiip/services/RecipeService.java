/**
 *
 */
package org.training.uiip.recipesuiip.services;

import java.util.Collection;

import org.training.uiip.recipesuiip.model.RecipeModel;


/**
 * @author fpalmieri
 *
 */
public interface RecipeService
{

	RecipeModel getRecipeForCode(String code);

	Collection<RecipeModel> getRecipesForFoodCode(String foodCode);

	Collection<RecipeModel> getRecipesForFoodCodeAndServings(String foodCode, int servings);

}
