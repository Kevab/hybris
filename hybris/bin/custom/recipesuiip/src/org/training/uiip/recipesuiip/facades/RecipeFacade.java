/**
 *
 */
package org.training.uiip.recipesuiip.facades;

import java.util.List;

import org.training.uiip.recipesuiip.data.RecipeData;


/**
 * @author fpalmieri
 *
 */
public interface RecipeFacade
{

	RecipeData getRecipeForCode(String code);

	List<RecipeData> getRecipesForFoodCode(String foodCode);

	List<RecipeData> getRecipesForFoodCodeAndServings(String foodCode, int servings);
}
