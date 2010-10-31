package com.eatnumber1.uvb;

import com.google.gson.GsonBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Russell Harmon
 * @since Oct 26, 2010
 */
public class MoveRequestHandler implements RequestHandler {
	private static final Log log = LogFactory.getLog(MoveRequestHandler.class);

	private DecisionEngine engine;

	public MoveRequestHandler( DecisionEngine engine ) {
		this.engine = engine;
	}

	@Override
	public void run( PrintWriter out, Scanner in ) {
		String json = in.nextLine();
		log.trace(json);
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Point.class, new PointDeserializer());
		GameMap map = builder.create().fromJson(json, GameMap.class);
		if( log.isInfoEnabled() ) {
			Scanner sc = new Scanner(map.toString());
			while( sc.hasNextLine() ) {
				log.info(sc.nextLine());
			}
		}
		out.println(engine.decide(map).serialize());
	}
}