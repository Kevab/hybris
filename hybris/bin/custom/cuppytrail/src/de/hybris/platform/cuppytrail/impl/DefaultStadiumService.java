package de.hybris.platform.cuppytrail.impl;

import de.hybris.platform.cuppytrail.StadiumService;
import de.hybris.platform.cuppytrail.daos.StadiumDAO;
import de.hybris.platform.cuppytrail.event.IncrementsCounterEvent;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;


public class DefaultStadiumService implements StadiumService
{
	private StadiumDAO stadiumDAO;
	private EventService eventService;
	private IncrementsCounterEvent event;


	/**
	 * Gets all stadiums by delegating to {@link StadiumDAO#findStadiums()}.
	 */
	@Override
	public List<StadiumModel> getStadiums()
	{
		return stadiumDAO.findStadiums();
	}

	/**
	 * Gets all stadiums for given code by delegating to {@link StadiumDAO#findStadiumsByCode(String)} and then assuring
	 * uniqueness of result.
	 */
	@Override
	public StadiumModel getStadiumForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException
	{

		final List<StadiumModel> result = stadiumDAO.findStadiumsByCode(code);
		StadiumModel toReturn;
		if (result.isEmpty())
		{
			throw new UnknownIdentifierException("Stadium with code '" + code + "' not found!");
		}
		else if (result.size() > 1)
		{
			throw new AmbiguousIdentifierException(
					"Stadium code '" + code + "' is not unique, " + result.size() + " stadiums found!");
		}
		else if (result.size() == 1)
		{
			toReturn = result.get(0);
			event = new IncrementsCounterEvent(toReturn);
			eventService.publishEvent(event);
			return toReturn;
		}
		return null;

	}

	@Required
	public void setEventService(final EventService eventService)
	{
		this.eventService = eventService;
	}

	@Required
	public void setStadiumDAO(final StadiumDAO stadiumDAO)
	{
		this.stadiumDAO = stadiumDAO;
	}


}