package com.tiennv.aemtraining.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.dam.api.AssetManager;

@SuppressWarnings("serial")
@SlingServlet(paths = "/bin/damUploadServlet", methods = "GET", metatype = true)
public class DamUploadServlet extends SlingSafeMethodsServlet {
	
	Logger logger = LoggerFactory.getLogger(DamUploadServlet.class);
	
	@Reference
	private ResourceResolverFactory resolverFactory;
	
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		logger.info("Access DamUploadServlet doGet method");
		try {
			ResourceResolver resourceResolver = resolverFactory.getResourceResolver(null);
			AssetManager assetManager = resourceResolver.adaptTo(AssetManager.class);
			if (assetManager != null) {
				response.getOutputStream().println("This is content asset manager");
			}
		} catch (LoginException e) {
			logger.info("DamUploadServlet Exception");
			logger.error(e.getMessage());
		}
		
	}
	
	protected void doPost(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		throw new UnsupportedOperationException("POST method is not supported");
	}
}
