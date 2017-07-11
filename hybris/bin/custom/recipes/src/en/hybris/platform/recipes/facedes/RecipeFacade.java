/**
 *
 */
package en.hybris.platform.recipes.facedes;

import java.util.List;

import en.hybris.platform.recipes.data.RecipeData;


/**
 * @author soprasteria
 *
 */
public interface RecipeFacade
{
	List<RecipeData> getRecipeForCode(String code);

	List<RecipeData> getRecipeForFoodCode(String code);

	List<RecipeData> getRecipeForFoodCodeAndNumberOfServings(String code, int servings);
}
