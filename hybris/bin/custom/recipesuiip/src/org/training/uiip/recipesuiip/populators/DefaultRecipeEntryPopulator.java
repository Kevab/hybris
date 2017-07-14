/**
 *
 */
package org.training.uiip.recipesuiip.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.product.UnitModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.springframework.beans.factory.annotation.Required;
import org.training.uiip.recipesuiip.data.ProductData;
import org.training.uiip.recipesuiip.data.RecipeEntryData;
import org.training.uiip.recipesuiip.model.RecipeEntryModel;


/**
 * @author fpalmieri
 *
 */
public class DefaultRecipeEntryPopulator implements Populator<RecipeEntryModel, RecipeEntryData>
{

	AbstractPopulatingConverter<ProductModel, ProductData> recipeProductConverter;

	@Override
	public void populate(final RecipeEntryModel source, final RecipeEntryData target) throws ConversionException
	{
		target.setDisplayName(source.getDisplayName());
		target.setEntryNumber(source.getEntryNumber());
		target.setQuantity(source.getQuantity());
		populateUnitCode(source, target);
		populateProduct(source, target);
	}

	private void populateProduct(final RecipeEntryModel source, final RecipeEntryData target)
	{
		final ProductModel productModel = source.getProduct();
		if (productModel != null)
		{
			final ProductData product = recipeProductConverter.convert(productModel);
			target.setProduct(product);
		}
	}

	private void populateUnitCode(final RecipeEntryModel source, final RecipeEntryData target)
	{
		final UnitModel unit = source.getUnit();
		if (unit != null)
		{
			target.setUnitCode(source.getUnit().getCode());
		}
	}

	@Required
	public void setRecipeProductConverter(final AbstractPopulatingConverter<ProductModel, ProductData> recipeProductConverter)
	{
		this.recipeProductConverter = recipeProductConverter;
	}

}
