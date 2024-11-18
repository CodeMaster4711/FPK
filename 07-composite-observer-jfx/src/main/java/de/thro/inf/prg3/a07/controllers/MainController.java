package de.thro.inf.prg3.a07.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.application.Platform;
import de.thro.inf.prg3.a07.model.Meal;
import de.thro.inf.prg3.a07.api.OpenMensaAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnClose;

    @FXML
    private CheckBox chkVegetarian;

    @FXML
    private ListView<String> mealsList;

    private ObservableList<Meal> meals = FXCollections.observableArrayList();
    private OpenMensaAPI api;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeAPI();
        btnClose.setOnAction(event -> System.exit(0));
        btnRefresh.setOnAction(event -> refreshMeals());
        chkVegetarian.setOnAction(event -> filterMeals());
    }

    private void initializeAPI() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://openmensa.org/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        api = retrofit.create(OpenMensaAPI.class);
    }

	private void refreshMeals() {
		String testDate = "2021-11-10";

		api.getMeals(229, testDate).enqueue(new Callback<List<Meal>>() {
			@Override
			public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
				if (!response.isSuccessful() || response.body() == null)
					return;

				Platform.runLater(() -> {
					meals.clear();
					meals.addAll(response.body());
					filterMeals();
				});
			}

			@Override
			public void onFailure(Call<List<Meal>> call, Throwable t) {
				System.out.println("Failed to fetch meals");
			}
		});
	}

    private void filterMeals() {
        ObservableList<String> filteredMeals = FXCollections.observableArrayList();
        for (Meal meal : meals) {
            if (!chkVegetarian.isSelected() || meal.isVegetarian()) {
                filteredMeals.add(meal.getName());
            }
        }
        mealsList.setItems(filteredMeals);
    }
}
