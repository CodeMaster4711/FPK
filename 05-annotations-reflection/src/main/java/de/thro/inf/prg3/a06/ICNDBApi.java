package de.thro.inf.prg3.a06;

import de.thro.inf.prg3.a06.model.Joke;
import de.thro.inf.prg3.a06.model.Jokes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public interface ICNDBApi {

	@GET("/jokes/random")
	Call<Joke> getRandomJoke();

	@GET("/jokes/search")
	Call<Jokes> getJokeByQuery(@Query("query") String query);
}
