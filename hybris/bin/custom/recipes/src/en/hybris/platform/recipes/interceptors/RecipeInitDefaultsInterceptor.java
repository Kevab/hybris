/**
 *
 */
package en.hybris.platform.recipes.interceptors;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import en.hybris.platform.recipes.model.RecipeModel;


/**
 * @author soprasteria
 *
 */
public class RecipeInitDefaultsInterceptor implements InitDefaultsInterceptor<RecipeModel>
{


	@Override
	public void onInitDefaults(final RecipeModel model, final InterceptorContext arg1) throws InterceptorException
	{
		final Calendar gc = GregorianCalendar.getInstance();
		model.setCode("rec");
		final String newCode = model.getCode() + gc.getTimeInMillis();
		model.setCode(newCode);
	}

}
