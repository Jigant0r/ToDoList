module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.Steve.todolist to javafx.fxml;
    exports com.Steve.todolist;
}