/**
 *
 */
package en.hybris.platform.recipes;

import java.util.List;

import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */
public interface RecipeService
{

	List<RecipeModel> getRecipeByCode(String code);

	List<RecipeModel> getRecipeByFoodCode(String code);

	List<RecipeModel> getRecipeByFoodCodeAndServings(String code, int servings);

}
