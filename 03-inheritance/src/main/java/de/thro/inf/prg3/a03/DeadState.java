package de.thro.inf.prg3.a03;

import de.thro.inf.prg3.a03.Cat;
import de.thro.inf.prg3.a03.State;

/**
 * @author Peter Kurfer
 * Created on 10/13/17.
 */
public class DeadState extends State {

    DeadState() {
        super(-1);
    }

    @Override
    public State successor(Cat cat) {
        // no lives left...
        return this;
    }
}