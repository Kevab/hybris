/**
 *
 */
package en.hybris.platform.services;

import java.util.Collection;

import en.hybris.platform.model.CyclistRankingModel;
import en.hybris.platform.model.StageModel;
import en.hybris.platform.model.StageRaceModel;
import en.hybris.platform.model.StageRankingModel;


/**
 * @author soprasteria
 *
 */
public interface CyclientService
{
	Collection<StageModel> getStages();

	CyclistRankingModel getCyclistRankingForStageRaceCode(String stageRaceCode);

	Collection<StageRaceModel> getStageRaces();

	Collection<StageModel> getStagesForStageRaceCode(String stageRaceCode);

	StageRankingModel getStageRankingForStageCode(String stageCode);
}
