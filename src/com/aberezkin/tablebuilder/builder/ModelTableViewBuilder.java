package com.aberezkin.tablebuilder.builder;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ModelTableViewBuilder<M> extends TableView<M> {
    /**
     * Hidden constructor.
     */
    private ModelTableViewBuilder() {}


    public static <T> TableView<T> buildUpon(Class<T> model) {
        TableView<T> table = new TableView<>();
        ArrayList<TableColumn<T, ?>> columns = new ArrayList<>();

        Set<String> methodNames = getMethodNames(model.getDeclaredMethods());

        for (Field field: model.getDeclaredFields()) {
            String fieldName = field.getName();
            String getterName = "get" + capitalizeFirst(fieldName);
            String setterName = "set" + capitalizeFirst(fieldName);
            boolean notAnnotated = field.getAnnotation(IgnoreTable.class) == null;

            if (notAnnotated && methodNames.contains(getterName)
                    && methodNames.contains(setterName)) {
                TableColumn column = new TableColumn(camelCaseToTitleCase(fieldName));
                column.setCellValueFactory(getCellFactory(model,
                        field.getType(),
                        fieldName));
                columns.add(column);
            }
        }

        table.getColumns().addAll(columns);

        return table;
    }

    private static <S, T> PropertyValueFactory<S, T> getCellFactory(Class<S> model,
                                                                    Class<T> fieldType,
                                                                    String fieldName) {
        return new PropertyValueFactory<>(fieldName);
    }


    private static String camelCaseToTitleCase(String camelCaseString) {
        String titleCaseString = "";
        if (camelCaseString != null && camelCaseString.length() > 0) {
            titleCaseString = splitCamelCase(capitalizeFirst(camelCaseString));
        }
        return titleCaseString;
    }

    private static String capitalizeFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    private static Set<String> getMethodNames(Method[] methods) {
        Set<String> membersNames = new TreeSet<String>();
        for (Method member: methods) {
            membersNames.add(member.getName());
        }
        return  membersNames;
    }
}
