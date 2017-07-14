/**
 *
 */
package en.hybris.platform.facades.impl;

import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.data.CyclistRankingData;
import en.hybris.platform.data.StageData;
import en.hybris.platform.data.StageRaceData;
import en.hybris.platform.data.StageRankingData;
import en.hybris.platform.facades.CyclientFacades;
import en.hybris.platform.model.CyclistRankingModel;
import en.hybris.platform.model.StageModel;
import en.hybris.platform.model.StageRaceModel;
import en.hybris.platform.model.StageRankingModel;
import en.hybris.platform.services.CyclientService;


/**
 * @author soprasteria
 *
 */
public class DefaultCyclientFacade implements CyclientFacades
{

	private CyclientService cyclientService;
	private AbstractPopulatingConverter<StageModel, StageData> cyclientStageConverter;
	private AbstractPopulatingConverter<CyclistRankingModel, CyclistRankingData> cyclientCyclistRankingConverter;
	private AbstractPopulatingConverter<StageRaceModel, StageRaceData> cyclientStageRaceConverter;
	private AbstractPopulatingConverter<StageRankingModel, StageRankingData> cyclientStageRankingConverter;

	@Override
	public List<StageData> getStages()
	{

		final Collection<StageModel> stageModels = cyclientService.getStages();
		final List<StageData> toReturn = Converters.convertAll(stageModels, cyclientStageConverter);
		return toReturn;
	}


	@Override
	public CyclistRankingData getCyclistRankingForStageRaceCode(final String stageRaceCode)
	{

		final CyclistRankingModel cyclistRankingModel = cyclientService.getCyclistRankingForStageRaceCode(stageRaceCode);
		final CyclistRankingData toReturn = cyclientCyclistRankingConverter.convert(cyclistRankingModel);
		return toReturn;
	}


	@Override
	public List<StageRaceData> getStageRaces()
	{
		final Collection<StageRaceModel> stageRaceModels = cyclientService.getStageRaces();
		final List<StageRaceData> toReturn = Converters.convertAll(stageRaceModels, cyclientStageRaceConverter);
		return toReturn;
	}


	@Override
	public List<StageData> getStagesForStageRaceCode(final String stageRaceCode)
	{
		final Collection<StageModel> stageModels = cyclientService.getStagesForStageRaceCode(stageRaceCode);
		final List<StageData> toReturn = Converters.convertAll(stageModels, cyclientStageConverter);
		return toReturn;
	}


	@Override
	public StageRankingData getStageRankingForStageCode(final String stageCode)
	{
		final StageRankingModel stageRankingModels = cyclientService.getStageRankingForStageCode(stageCode);
		final StageRankingData toReturn = cyclientStageRankingConverter.convert(stageRankingModels);
		return toReturn;
	}


	@Required
	public void setCyclientService(final CyclientService cyclientService)
	{
		this.cyclientService = cyclientService;
	}


	@Required
	public void setCyclientStageConverter(final AbstractPopulatingConverter<StageModel, StageData> cyclientStageConverter)
	{
		this.cyclientStageConverter = cyclientStageConverter;
	}


	@Required
	public void setCyclientCyclistRankingConverter(
			final AbstractPopulatingConverter<CyclistRankingModel, CyclistRankingData> cyclientCyclistRankingConverter)
	{
		this.cyclientCyclistRankingConverter = cyclientCyclistRankingConverter;
	}


	@Required
	public void setCyclientStageRaceConverter(
			final AbstractPopulatingConverter<StageRaceModel, StageRaceData> cyclientStageRaceConverter)
	{
		this.cyclientStageRaceConverter = cyclientStageRaceConverter;
	}


	@Required
	public void setCyclientStageRankingConverter(
			final AbstractPopulatingConverter<StageRankingModel, StageRankingData> cyclientStageRankingConverter)
	{
		this.cyclientStageRankingConverter = cyclientStageRankingConverter;
	}





}
