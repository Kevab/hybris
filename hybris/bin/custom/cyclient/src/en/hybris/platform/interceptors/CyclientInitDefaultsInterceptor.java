/**
 *
 */
package en.hybris.platform.interceptors;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Required;

import en.hybris.platform.model.StageModel;


/**
 * @author soprasteria
 *
 */
public class CyclientInitDefaultsInterceptor implements InitDefaultsInterceptor<StageModel>
{

	ModelService modelService;

	@Override
	public void onInitDefaults(final StageModel stageModel, final InterceptorContext ctx) throws InterceptorException
	{
		final Calendar cal = Calendar.getInstance();
		final String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1);
		final String mounth = String.valueOf(cal.get(Calendar.MONTH));
		final String year = String.valueOf(cal.get(Calendar.YEAR));
		final String toWrite = day + "/" + mounth + "/" + year;
		stageModel.setDate(toWrite);
		modelService.save(stageModel);


	}

	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}





}
