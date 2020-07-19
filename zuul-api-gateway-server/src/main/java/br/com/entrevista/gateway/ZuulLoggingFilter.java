/**
 * 
 */
package br.com.entrevista.gateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author rholtz
 *
 */
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
