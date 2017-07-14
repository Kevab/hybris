/**
 *
 */
package en.hybris.platform.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import en.hybris.platform.data.StageRaceData;
import en.hybris.platform.model.StageRaceModel;


/**
 * @author soprasteria
 *
 */
public class DefaultStageRacePopulator implements Populator<StageRaceModel, StageRaceData>
{

	@Override
	public void populate(final StageRaceModel source, final StageRaceData target) throws ConversionException
	{


		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setNation(source.getNation());
		target.setNumberOfStage(source.getNumberOfStage());


	}

}
