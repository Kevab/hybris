/**
 *
 */
package en.hybris.platform.populator;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import en.hybris.platform.data.StageRankingData;
import en.hybris.platform.model.StageRankingModel;


/**
 * @author soprasteria
 *
 */
public class DefaultStageRankingPopulator implements Populator<StageRankingModel, StageRankingData>
{


	@Override
	public void populate(final StageRankingModel source, final StageRankingData target) throws ConversionException
	{
		target.setCode(source.getCode());
		target.setRanking(source.getRanking());
		target.setTotalTime(source.getTotalTime());

	}

}
