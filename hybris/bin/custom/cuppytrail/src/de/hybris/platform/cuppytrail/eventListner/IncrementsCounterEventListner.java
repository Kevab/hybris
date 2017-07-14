/**
 *
 */
package de.hybris.platform.cuppytrail.eventListner;

import de.hybris.platform.cuppytrail.event.IncrementsCounterEvent;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

import org.springframework.beans.factory.annotation.Required;


/**
 * @author soprasteria
 *
 */
public class IncrementsCounterEventListner extends AbstractEventListener<IncrementsCounterEvent>
{


	StadiumModel stadium;
	private ModelService modelService;

	@Override
	protected void onEvent(final IncrementsCounterEvent event)
	{
		stadium = event.getModel();
		Integer cont = stadium.getCont();
		if (cont != null)
		{
			cont = Integer.valueOf(cont.intValue() + 1);
			stadium.setCont(cont);
			modelService.save(stadium);
		}

	}


	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}




}
