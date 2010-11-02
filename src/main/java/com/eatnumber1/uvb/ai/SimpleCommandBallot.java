package com.eatnumber1.uvb.ai;

import org.jetbrains.annotations.NotNull;

/**
 * @author Russell Harmon
 * @since Nov 2, 2010
 */
public class SimpleCommandBallot implements CommandBallot {
	private int votes;
	private CommandProposal proposal;

	public SimpleCommandBallot( CommandProposal proposal ) {
		this.proposal = proposal;
	}

	@Override
	public int tally() {
		return votes;
	}

	@Override
	public void vote( int value ) {
		votes += value;
	}

	@NotNull
	@Override
	public CommandProposal getProposal() {
		return proposal;
	}

	@Override
	public int compareTo( CommandBallot ballot ) {
		return Integer.valueOf(votes).compareTo(ballot.tally());
	}

	@Override
	public boolean equals( Object o ) {
		if( this == o ) return true;
		if( !(o instanceof SimpleCommandBallot) ) return false;
		SimpleCommandBallot that = (SimpleCommandBallot) o;
		return votes == that.votes && !(proposal != null ? !proposal.equals(that.proposal) : that.proposal != null);

	}

	@Override
	public int hashCode() {
		int result = votes;
		result = 31 * result + (proposal != null ? proposal.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("SimpleCommandBallot");
		sb.append("{votes=").append(votes);
		sb.append(", proposal=").append(proposal);
		sb.append('}');
		return sb.toString();
	}
}