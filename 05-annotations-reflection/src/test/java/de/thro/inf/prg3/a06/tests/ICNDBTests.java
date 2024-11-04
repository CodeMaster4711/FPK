package de.thro.inf.prg3.a06.tests;

import de.thro.inf.prg3.a06.ICNDBApi;
import de.thro.inf.prg3.a06.model.Joke;
import de.thro.inf.prg3.a06.model.Jokes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
class ICNDBTests {

	private static final Logger logger = LogManager.getLogger(ICNDBTests.class);
	private static final int REQUEST_COUNT = 10;

	private ICNDBApi createService() {
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		return retrofit.create(ICNDBApi.class);
	}

	@Test
	void testGetRandomJoke() throws IOException {
		ICNDBApi service = createService();
		Call<Joke> jokeCall = service.getRandomJoke();
		Joke joke = jokeCall.execute().body();

		assertNotNull(joke);
		assertNotNull(joke.getContent());
		logger.info("Random joke: " + joke.getContent());
	}

	@Test
	void testGetJokeByQuery() throws IOException {
	}
}