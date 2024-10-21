package de.thro.inf.prg3.a03;

import de.thro.inf.prg3.a03.states.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Cat {
	private static final Logger logger = LoggerFactory.getLogger(Cat.class);

	private State state;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		// initially, cats are (you guessed it) sleeping
		state = new SleepingState(sleep);
	}

	public void tick(){
		this.state = state.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Not every cat is Garfield...");

		logger.info("You feed the cat...");
		this.state = ((HungryState) state).feed(this);
	}

	@Override
	public String toString() {
		return name;
	}

	public int getSleeping() {
		return sleep;
	}

	public int getAwake(){
		return awake;
	}

	public int getDigest(){
		return digest;
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeadState;
	}
}
