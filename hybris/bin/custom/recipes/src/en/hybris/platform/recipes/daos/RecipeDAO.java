/**
 *
 */
package en.hybris.platform.recipes.daos;

import java.util.Collection;
import java.util.List;

import en.hybris.platform.recipes.model.MenuModel;
import en.hybris.platform.recipes.model.RecipeModel;


public interface RecipeDAO
{
	List<RecipeModel> findRecipeByCode(String code);

	List<RecipeModel> findRecipeByFoodCode(String code);

	List<RecipeModel> findRecipeByFoodCodeAndServings(String code, int servings);

	Collection<RecipeModel> findRecipes();

	Collection<MenuModel> findMenuByCode(String menuCode);

}
