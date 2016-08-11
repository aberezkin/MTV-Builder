package com.aberezkin.tablebuilder.sample;

import com.aberezkin.tablebuilder.builder.ModelTableViewBuilder;
import com.aberezkin.tablebuilder.sample.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML
    VBox container;

    public void initialize() {
        container.setSpacing(5);
        container.setPadding(new Insets(10, 0, 0, 10));

        TableView<Person> personTable = ModelTableViewBuilder.buildUpon(Person.class);

        container.getChildren().add(personTable);

        Person[] people = {
                new Person("Andy", "Russel", "arussel@company.com", 23 ),
                new Person("Terry", "Jonson", "tjonson@company.com", 21 ),
                new Person("Sally", "Swanson", "sswanson@company.com", 19 ),
                new Person("Molly", "Dwanson", "mdwanson@company.com", 24 ),
                new Person("Goofy", "Gooper", "ggopper@company.com", 30 ),
        };

        ObservableList<Person> data = FXCollections.observableArrayList(people);
        personTable.setItems(data);
    }
}
