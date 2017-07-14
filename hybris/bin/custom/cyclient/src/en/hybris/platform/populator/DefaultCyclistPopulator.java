/**
 *
 */
package en.hybris.platform.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import en.hybris.platform.data.CyclistData;
import en.hybris.platform.model.CyclistModel;


/**
 * @author soprasteria
 *
 */
public class DefaultCyclistPopulator implements Populator<CyclistModel, CyclistData>
{


	@Override
	public void populate(final CyclistModel source, final CyclistData target) throws ConversionException
	{
		target.setCode(source.getCode());
		target.setName(source.getName());

	}

}
