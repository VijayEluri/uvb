package com.eatnumber1.uvb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Russell Harmon
 * @since Oct 26, 2010
 */
public class RequestDispatcher {
	private static final Log log = LogFactory.getLog(RequestDispatcher.class);

	private Map<Request, RequestHandler> handlers = new HashMap<Request, RequestHandler>();

	public void addHandler( Request request, RequestHandler handler ) {
		handlers.put(request, handler);
	}

	public void dispatch( Request request, Server server ) {
		log.debug("Dispatching request " + request);
		handlers.get(request).run(server);
	}
}
