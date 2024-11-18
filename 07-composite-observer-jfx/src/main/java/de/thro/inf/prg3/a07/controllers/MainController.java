package de.thro.inf.prg3.a07.controllers;

import de.thro.inf.prg3.a07.api.OpenMensaAPI;
import de.thro.inf.prg3.a07.model.Meal;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;


public class MainController implements Initializable {
	public void MainController() {
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://openmensa.org/api/v2/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		api = retrofit.create(OpenMensaAPI.class);
	}
	// use annotation to tie to component in XML
	@FXML
	private Button btnRefresh;

	@FXML
	private Button btnClose;

	@FXML
	private CheckBox chkVegetarian;

	@FXML
	private DatePicker datePicker;

	private OpenMensaAPI api;

	@FXML
	private ListView<Meal> mealsList;

	// list to carry the data
	private ObservableList<Meal> meals = FXCollections.observableArrayList();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mealsList.setItems(meals);

		btnRefresh.setOnAction(this::doUpdate);

		chkVegetarian.setOnAction(this::doFilter);
	}

	private void doFilter(ActionEvent actionEvent) {
		if (chkVegetarian.isSelected())
			mealsList.setItems(meals.filtered(m -> m.getNotes().stream().noneMatch(s -> s.toLowerCase().contains("fleisch"))));
		else
			mealsList.setItems(meals);
	}

	private void doUpdate(ActionEvent ev) {
		System.out.println("ok");

		LocalDate d = datePicker.getValue();
		String today = DateTimeFormatter.ISO_LOCAL_DATE.format(d);

		System.out.println("Date :" + today);
		api.getMeals(229, today).enqueue(new Callback<List<Meal>>() {
			@Override
			public void onResponse(Call<List<Meal>> call, Response<List<Meal>> response) {
				if (!response.isSuccessful() || response.body() == null)
					return;

				// run async update!
				Platform.runLater(() -> {
					meals.clear();
					meals.addAll(response.body());
				});
			}

			@Override
			public void onFailure(Call<List<Meal>> call, Throwable t) {
				System.out.println("Meh");
			}
		});
	}

	@FXML
	public void onCloseClicked(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
}
