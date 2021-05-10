package finalAssignment;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class question_6 extends Application {

    String user_type[] = {"Admin", "User"};
    ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(user_type));

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Name");
        TextField nameText = new TextField();

        Text passLabel = new Text("Password");
        TextField passText = new TextField();

        Text typeLabel = new Text("User type");
        Button inBtn = new Button("Sign In");
        Button upBtn = new Button("Sign Up");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.add(nameLabel, 0, 0);
        grid.add(nameText, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passText, 1, 1);
        grid.add(typeLabel, 0, 2);
        grid.add(combo_box, 1, 2);
        grid.add(inBtn, 1, 3);
        grid.add(upBtn, 2, 3);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setTitle("Login panel");
        primaryStage.setScene(scene);

        primaryStage.show();
        inBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showAnotherWindow3();

            }

        });
        upBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showAnotherWindow();

            }

        });

    }

    public void showAnotherWindow() {
        Stage stage = new Stage();
        Label fLabel = new Label("First Name:");
        TextField fText = new TextField();
        Label lLabel = new Label("Last Name:");
        TextField lText = new TextField();

        Text eLabel = new Text("E-mail:");
        TextField eText = new TextField();

        Text pLabel = new Text("Password:");
        TextField pText = new TextField();
        Button submit = new Button("Submit");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.add(fLabel, 0, 0);
        grid.add(fText, 1, 0);
        grid.add(lLabel, 0, 1);
        grid.add(lText, 1, 1);
        grid.add(eLabel, 0, 2);
        grid.add(eText, 1, 2);
        grid.add(pLabel, 0, 3);
        grid.add(pText, 1, 3);
        grid.add(submit, 1, 4);

        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("Registration panel");
        stage.setScene(scene);
        stage.show();
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showAnotherWindow1();
            }
        });

    }

    public void showAnotherWindow1() {
        Stage stage = new Stage();
         Label label = new Label("Registration Successful");
        label.setStyle("-fx-font-color:white");
        label.setFont(new Font("italic", 30));
        label.setPadding(new Insets(10, 10, 10, 10));
       Scene scene = new Scene(label, 400, 400);


        stage.setTitle("Registration successful panel");
                stage.setScene(scene);


        stage.show();

    }
     public void showAnotherWindow3() {
        Stage stage = new Stage();
         Label label = new Label("Login  Successful");
        label.setStyle("-fx-font-color:white");
        label.setFont(new Font("italic", 30));
        label.setPadding(new Insets(10, 10, 10, 10));
       Scene scene = new Scene(label, 400, 400);


        stage.setTitle("Login successful panel");
                stage.setScene(scene);


        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
