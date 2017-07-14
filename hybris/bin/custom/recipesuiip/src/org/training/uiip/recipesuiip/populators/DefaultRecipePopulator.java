/**
 *
 */
package org.training.uiip.recipesuiip.populators;

import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.training.uiip.recipesuiip.data.RecipeData;
import org.training.uiip.recipesuiip.data.RecipeEntryData;
import org.training.uiip.recipesuiip.model.RecipeEntryModel;
import org.training.uiip.recipesuiip.model.RecipeModel;


/**
 * @author fpalmieri
 *
 */
public class DefaultRecipePopulator implements Populator<RecipeModel, RecipeData>
{

	AbstractPopulatingConverter<RecipeEntryModel, RecipeEntryData> recipeEntryConverter;

	@Override
	public void populate(final RecipeModel source, final RecipeData target) throws ConversionException
	{
		target.setCode(source.getCode());
		populateRecipeType(source, target);
		populateKitchenStyle(source, target);
		populateDishType(source, target);
		populateDifficulty(source, target);
		target.setServings(source.getServings());
		target.setPreparationTime(source.getPreparationTime());
		target.setContent(source.getContent());
		target.setChef(source.getChef());
		populateRecipeEntries(source, target);
	}

	private void populateRecipeEntries(final RecipeModel source, final RecipeData target)
	{
		final Collection<RecipeEntryModel> entryModels = source.getEntries();
		final List<RecipeEntryData> entries = Converters.convertAll(entryModels, recipeEntryConverter);
		target.setEntries(entries);
	}

	private void populateDifficulty(final RecipeModel source, final RecipeData target)
	{
		if (source.getDifficulty() != null)
		{
			target.setDifficulty(source.getDifficulty().getCode());
		}
	}

	private void populateDishType(final RecipeModel source, final RecipeData target)
	{
		if (source.getDishType() != null)
		{
			target.setDishType(source.getDishType().getCode());
		}
	}

	private void populateKitchenStyle(final RecipeModel source, final RecipeData target)
	{
		if (source.getKitchenStyle() != null)
		{
			target.setKitchenStyle(source.getKitchenStyle().getCode());
		}
	}

	private void populateRecipeType(final RecipeModel source, final RecipeData target)
	{
		if (source.getRecipeType() != null)
		{
			target.setRecipeType(source.getRecipeType().getCode());
		}
	}

	@Required
	public void setRecipeEntryConverter(final AbstractPopulatingConverter<RecipeEntryModel, RecipeEntryData> recipeEntryConverter)
	{
		this.recipeEntryConverter = recipeEntryConverter;
	}
}
