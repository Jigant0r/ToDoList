package com.Steve.todolist;

import com.Steve.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private ListView<ToDoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    private List<ToDoItem> toDoItems;

    public void initialize(){
        ToDoItem item1 = new ToDoItem("Mail birthday card", "It would be nice to mail John a card for his 95th birthday",
                LocalDate.of(2022, Month.JANUARY, 27));
        ToDoItem item2 = new ToDoItem("Doctors Appointment", "Dr. Smith is going to check out my enlarged prostate",
                LocalDate.of(2022, Month.JANUARY, 29));
        ToDoItem item3 = new ToDoItem("Buy Laundry Detergent", "Your clothes stank",
                LocalDate.of(2022, Month.FEBRUARY, 2));
        ToDoItem item4 = new ToDoItem("Finish design project for Doug", "That buffoon only gave me 2 weeks because he didn't know wtf he was doing",
                LocalDate.of(2022, Month.JANUARY,05));
        ToDoItem item5 = new ToDoItem("Call Mom", "Ya know",
                LocalDate.of(2022, Month.FEBRUARY, 27));

        toDoItems = new ArrayList<ToDoItem>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoItems.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem toDoItem, ToDoItem t1) {
                Object newValue = new Object();
                if(newValue != null){
                    ToDoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(toDoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    public void handleClickListView(){
        ToDoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
        //System.out.println("The selected item is " + item);
//        itemDetailsTextArea.setText(item.getDetails());
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());


    }

    @FXML
    protected void onHelloButtonClick() {

    }
}