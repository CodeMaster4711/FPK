package de.thro.inf.prg3.a03;

import de.thro.inf.prg3.a03.Cat;
import de.thro.inf.prg3.a03.State;

/**
 * @author Peter Kurfer
 * Created on 10/13/17.
 */
public class PlayfulState extends State {

    PlayfulState(int duration) {
        super(duration);
    }

    @Override
    public State successor(Cat cat) {
        logger.info("Yoan... getting tired!");
        return new SleepingState(cat.getSleeping());
    }
}
