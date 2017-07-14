/**
 *
 */
package en.hybris.platform.services.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.cyclient.daos.CyclientDAO;
import en.hybris.platform.model.CyclistRankingModel;
import en.hybris.platform.model.StageModel;
import en.hybris.platform.model.StageRaceModel;
import en.hybris.platform.model.StageRankingModel;
import en.hybris.platform.services.CyclientService;


/**
 * @author soprasteria
 *
 */
public class DefaultCyclientService implements CyclientService
{

	private CyclientDAO cyclientDAO;

	@Override
	public Collection<StageModel> getStages()
	{
		final Collection<StageModel> result = cyclientDAO.findStages();
		return result;
	}


	@Override
	public CyclistRankingModel getCyclistRankingForStageRaceCode(final String stageRaceCode)
	{

		final Collection<CyclistRankingModel> result = cyclientDAO.findCyclistRankingByStageRaceCode(stageRaceCode);
		if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException("message");
		}
		else if (result.isEmpty())
		{
			throw new UnknownIdentifierException("message");
		}
		return result.iterator().next();
	}


	@Override
	public Collection<StageRaceModel> getStageRaces()
	{

		final Collection<StageRaceModel> result = cyclientDAO.findStageRaces();
		return result;
	}


	@Override
	public Collection<StageModel> getStagesForStageRaceCode(final String stageRaceCode)
	{

		final Collection<StageModel> result = cyclientDAO.findStagesByStageRaceCode(stageRaceCode);
		return result;
	}


	@Override
	public StageRankingModel getStageRankingForStageCode(final String stageCode)
	{

		final Collection<StageRankingModel> result = cyclientDAO.findStageRankingByStageCode(stageCode);
		if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException("message");
		}
		else if (result.isEmpty())
		{
			throw new UnknownIdentifierException("message");
		}
		return result.iterator().next();
	}


	@Required
	public void setCyclientDAO(final CyclientDAO cyclientDAO)
	{
		this.cyclientDAO = cyclientDAO;
	}



}
