/**
 *
 */
package en.hybris.platform.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import en.hybris.platform.data.StageData;
import en.hybris.platform.model.StageModel;


/**
 * @author soprasteria
 *
 */
public class DefaultStagePopulator implements Populator<StageModel, StageData>
{


	@Override
	public void populate(final StageModel source, final StageData target) throws ConversionException
	{


		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDate(source.getDate());
		target.setCityStart(source.getCityStart());
		target.setCityArrival(source.getCityArrival());
		target.setDistance(source.getDistance());

	}

}
