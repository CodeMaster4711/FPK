package de.thro.inf.prg3.a03.tests;

import de.thro.inf.prg3.a03.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class CatTest {

	private static final int Sleep = 10;
	private static final int Awake = 15;
	private static final int Digest = 10;

	private Cat animal;

	@BeforeEach
	void setUp() {
		animal = new Cat("Horst", Sleep, Awake, Digest);
	}

	@Test
	void testFeedHungryAnimal() {
		for (int i = 0; i < Sleep; i++) {
			animal.tick();
		}

		assertTrue(animal.isHungry());
		animal.feed();
		assertTrue(animal.isDigesting());
	}

	@Test
	void testFeedNotHungryAnimal(){
		assertFalse(animal.isHungry());
		assertThrows(IllegalStateException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				animal.feed();
			}
		});
	}

	@Test
	void testAnimalGettingPlayful() {
		//Waiting while animal is sleeping
		for (int i = 0; i < Sleep; i++) {
			animal.tick();
		}
		animal.feed();
		//Waiting while animal is digesting
		for (int i = 0; i < Digest; i++) {
			animal.tick();
		}
		assertTrue(animal.isPlayful());
	}

	@Test
	void testAnimalDying(){
		//Waiting while animal is sleeping and awake before it's going to die
		for (int i = 0; i < Sleep + Awake; i++) {
			animal.tick();
		}
		assertTrue(animal.isDead());
	}

	@Test
	void testAnimalIsGoingToSleepAgain(){
		//Waiting while animal is sleeping
		for (int i = 0; i < Sleep; i++) {
			animal.tick();
		}

		animal.feed();
		for (int i = 0; i < Awake; i++) {
			animal.tick();
		}
		assertTrue(animal.isAsleep());
	}
}
