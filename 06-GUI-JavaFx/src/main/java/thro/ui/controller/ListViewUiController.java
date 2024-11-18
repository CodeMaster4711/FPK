package thro.ui.controller;

import thro.ui.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ListViewUiController implements Initializable {

    @FXML
    private ListView<Person> listViewBox;

    @FXML
    private TextField txtAddItem;

    @FXML
    private TextField searchField;

    private final ObservableList<Person> masterData = FXCollections.observableArrayList();

    @FXML
    private void addAction(ActionEvent action) {
        // We want to add an Element only if is not empty
        if (!txtAddItem.getText().equals("")) {
            masterData.add(new Person(txtAddItem.getText()));
            System.out.println("Add Button Pushed: " + masterData);
            txtAddItem.clear();
        }
    }

    @FXML
    private void deleteAction(ActionEvent action) {
        int selectedItem = listViewBox.getSelectionModel().getSelectedIndex();
        // if selectedItem is -1 that means no Element is selected, and we will get an Exception.
        if (selectedItem > -1) {
            masterData.remove(selectedItem);
            System.out.println("delete Button Pushed: " + selectedItem);
        }
    }

    @FXML
    private void updateAction(ActionEvent action) {
        int selectedItem = listViewBox.getSelectionModel().getSelectedIndex();
        if (selectedItem > -1) {
            Person personToUpdate = masterData.get(selectedItem);
            personToUpdate.setName(txtAddItem.getText());
            masterData.set(selectedItem, personToUpdate);
            System.out.println("update Button Pushed: " + masterData);
        }
    }

    @FXML
    private void searchAction(ActionEvent action) {
        String searchText = searchField.getText();
        if (searchText.equals("")) {
            listViewBox.setItems(masterData);
        } else {
            listViewBox.setItems(masterData.filtered(person -> person.getName().startsWith(searchText)));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewBox.setItems(masterData);
    }
}
