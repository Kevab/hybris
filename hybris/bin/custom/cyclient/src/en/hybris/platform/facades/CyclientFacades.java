/**
 *
 */
package en.hybris.platform.facades;

import java.util.List;

import en.hybris.platform.data.CyclistRankingData;
import en.hybris.platform.data.StageData;
import en.hybris.platform.data.StageRaceData;
import en.hybris.platform.data.StageRankingData;



/**
 * @author soprasteria
 *
 */
public interface CyclientFacades
{
	List<StageData> getStages();

	CyclistRankingData getCyclistRankingForStageRaceCode(String stageRaceCode);

	List<StageRaceData> getStageRaces();

	List<StageData> getStagesForStageRaceCode(String stageRaceCode);

	StageRankingData getStageRankingForStageCode(String stageCode);

}
