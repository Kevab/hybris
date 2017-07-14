/**
 *
 */
package en.hybris.platform.cyclient.daos;

import java.util.Collection;

import en.hybris.platform.model.CyclistRankingModel;
import en.hybris.platform.model.StageModel;
import en.hybris.platform.model.StageRaceModel;
import en.hybris.platform.model.StageRankingModel;




/**
 * @author soprasteria
 *
 */
public interface CyclientDAO
{
	Collection<StageModel> findStages();

	Collection<CyclistRankingModel> findCyclistRankingByStageRaceCode(String stageRaceCode);

	Collection<StageRaceModel> findStageRaces();

	Collection<StageModel> findStagesByStageRaceCode(String stageRaceCode);

	Collection<StageRankingModel> findStageRankingByStageCode(String stageCode);

}
