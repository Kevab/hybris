/**
 *
 */
package en.hybris.platform.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import en.hybris.platform.data.CyclistRankingData;
import en.hybris.platform.model.CyclistRankingModel;


/**
 * @author soprasteria
 *
 */
public class DefaultCyclistRankingPopulator implements Populator<CyclistRankingModel, CyclistRankingData>
{


	@Override
	public void populate(final CyclistRankingModel source, final CyclistRankingData target) throws ConversionException
	{

		target.setCode(source.getCode());
		target.setRank(source.getRank());
		target.setTotalTime(source.getTotalTime());

	}

}
