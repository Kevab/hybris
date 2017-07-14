/**
 *
 */
package org.training.uiip.recipesuiip.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import org.training.uiip.recipesuiip.data.ProductData;


/**
 * @author fpalmieri
 *
 */
public class DefaultRecipeProductPopulator implements Populator<ProductModel, ProductData>
{

	@Override
	public void populate(final ProductModel source, final ProductData target) throws ConversionException
	{
		target.setCode(source.getCode());
		target.setName(source.getName());
	}
}
