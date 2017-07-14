/**
 *
 */
package org.training.uiip.recipesuiip.interceptors;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.training.uiip.recipesuiip.model.RecipeModel;


/**
 * @author fpalmieri
 *
 */
public class RecipeInitDefaultsInterceptor implements InitDefaultsInterceptor<RecipeModel>
{

	@Override
	public void onInitDefaults(final RecipeModel recipeModel, final InterceptorContext ctx) throws InterceptorException
	{
		final Calendar gc = GregorianCalendar.getInstance();
		recipeModel.setCode("code" + gc.getTimeInMillis());
	}

}
