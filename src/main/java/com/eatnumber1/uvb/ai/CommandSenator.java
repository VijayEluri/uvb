package com.eatnumber1.uvb.ai;

import com.eatnumber1.uvb.board.GameMap;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * @author Russell Harmon
 * @since Nov 2, 2010
 */
public interface CommandSenator {
	@NotNull
	Set<CommandProposal> propose( GameMap map );

	void vote( GameMap map, CommandBallot ballot );
}