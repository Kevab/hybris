/**
 *
 */
package de.hybris.platform.cuppytrail.event;

import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;


/**
 * @author soprasteria
 *
 */
public class IncrementsCounterEvent extends AbstractEvent
{


	StadiumModel model;

	public IncrementsCounterEvent(final StadiumModel model)
	{
		this.model = model;
	}

	public StadiumModel getModel()
	{
		return model;
	}


	public void setModel(final StadiumModel model)
	{
		this.model = model;
	}

}
