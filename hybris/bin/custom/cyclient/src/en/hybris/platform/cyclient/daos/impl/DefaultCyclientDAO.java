/**
 *
 */
package en.hybris.platform.cyclient.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.cyclient.daos.CyclientDAO;
import en.hybris.platform.model.CyclistRankingModel;
import en.hybris.platform.model.StageModel;
import en.hybris.platform.model.StageRaceModel;
import en.hybris.platform.model.StageRankingModel;


/**
 * @author soprasteria
 *
 */
public class DefaultCyclientDAO implements CyclientDAO
{

	private FlexibleSearchService flexibleSearchService;

	@Override
	public Collection<StageModel> findStages()
	{
		final String queryString = "SELECT * FROM StageRace";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<StageModel> search(query).getResult();

	}


	@Override
	public Collection<CyclistRankingModel> findCyclistRankingByStageRaceCode(final String stageRaceCode)
	{

		final String queryString = "SELECT {c.PK} FROM {CyclistRanking as c JOIN StageRace as sr ON {sr.PK} = {c.stageRace} WHERE {sr.code=?stageRaceCode}}";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<CyclistRankingModel> search(query).getResult();
	}


	@Override
	public Collection<StageRaceModel> findStageRaces()
	{

		final String queryString = "SELECT * FROM {StageRace}";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<StageRaceModel> search(query).getResult();
	}


	@Override
	public Collection<StageModel> findStagesByStageRaceCode(final String stageRaceCode)
	{

		final String queryString = "SELECT {s.PK} FROM {Stage as s JOIN StageRace as sr ON {s.stageRace}={sr.PK} WHERE {s.code}=?stageRaceCode";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<StageModel> search(query).getResult();
	}


	@Override
	public Collection<StageRankingModel> findStageRankingByStageCode(final String stageCode)
	{

		final String queryString = "SELECT {sr.PK} FROM {StageRanking as sr JOIN Stage as s ON {s.PK}= {sr.stage} WHERE {s.code}=?stageCode";

		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

		return flexibleSearchService.<StageRankingModel> search(query).getResult();
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

}
