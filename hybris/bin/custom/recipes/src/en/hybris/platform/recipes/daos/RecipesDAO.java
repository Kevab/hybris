/**
 *
 */
package en.hybris.platform.recipes.daos;

import java.util.List;

import en.hybris.platform.recipes.model.RecipeModel;


public interface RecipesDAO
{
	List<RecipeModel> findRecipeByCode(String code);

	List<RecipeModel> findRecipeByFoodCode(String code);

	List<RecipeModel> findRecipeByFoodCodeAndServings(String code, int servings);

}
