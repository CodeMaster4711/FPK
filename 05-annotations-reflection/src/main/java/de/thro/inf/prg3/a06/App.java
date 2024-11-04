package de.thro.inf.prg3.a06;

import com.google.gson.Gson;
import de.thro.inf.prg3.a06.model.Joke;
import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws Exception {

		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://api.chucknorris.io")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		ICNDBApi service = retrofit.create(ICNDBApi.class);
		Call <Joke> joke = service.getRandomJoke();
		Joke s = joke.execute().body();

		System.out.println(s.getContent());
	}

}
