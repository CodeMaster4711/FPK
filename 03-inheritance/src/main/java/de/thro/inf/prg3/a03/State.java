package de.thro.inf.prg3.a03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class State {
    protected static final Logger logger = LoggerFactory.getLogger(State.class);

    protected int time = 0;
    protected final int duration;

    protected State(int duration){
        this.duration = duration;
    }

    final State tick(Cat cat) {
        if(duration < 0)
        	return this;

        // time goes by...
        time = time + 1;

        if(time < duration) {
	        logger.info("Still in {}", getClass().getSimpleName());
	        return this;
        } else {
            return successor(cat);
        }
    }

    public abstract State successor(Cat cat);

}

