
import javafx.application.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.print.PrinterJob;
import javafx.scene.paint.Color;

public class question_7 extends Application {

    private final TableView<Product> tableList = new TableView<Product>();
    private final ObservableList<Product> data = FXCollections.observableArrayList();// FXCollection is javafx collection

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //To create: Add check box next to each id you add, delete and edit buttons, add a week and month view, and a menu on top so you can save different copies. 
        VBox vBox1 = new VBox();
        Scene scene1 = new Scene(vBox1);
        vBox1.setStyle("-fx-background-color:#777799");

        vBox1.setSpacing(30);

        Label label = new Label("Product Inventory");
        label.setStyle("-fx-font-color:white");
        label.setFont(new Font("italic", 30));
        label.setPadding(new Insets(10, 10, 10, 10));

        // we create a object for every content  to arrage the table 
        TableColumn idCol = new TableColumn("ID");
        TableColumn nameCol = new TableColumn("Product_name");
        TableColumn priceCol = new TableColumn("Price");
        TableColumn stockCol = new TableColumn("Stock");

        // setCellValueFactory is used to associate a column in a TableView with a property of a class that contains the data to be displayed in the TableView's column
        idCol.setCellValueFactory(new PropertyValueFactory<Product, String>("Product"));
        idCol.setCellFactory(TextFieldTableCell.forTableColumn());
        idCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> t) {
                ((Product) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setToDo(t.getNewValue());
            }
        }
        );

        nameCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> t) {
                ((Product) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setName(t.getNewValue());
            }
        }
        );

        priceCol.setCellValueFactory(new PropertyValueFactory<Product, String>("Price"));
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        priceCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> t) {
                ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
            }
        }
        );

        stockCol.setCellValueFactory(new PropertyValueFactory<Product, String>("Stock"));
        stockCol.setCellFactory(TextFieldTableCell.forTableColumn());
        stockCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Product, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Product, String> t) {
                ((Product) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStock(t.getNewValue());
            }
        }
        );

        tableList.setItems(data);
        tableList.getColumns().addAll(idCol, nameCol, priceCol, stockCol); // Place the column headings in tableList.

        idCol.setMinWidth(70);
        nameCol.setMinWidth(200);
        priceCol.setMinWidth(120);
        stockCol.setMinWidth(120);

        HBox rowBox = new HBox();
        rowBox.setSpacing(7);
        rowBox.setPadding(new Insets(10, 10, 10, 10));

        // Create text fields so the user can enter new ids into the table.
        TextField addId = new TextField();

        TextField addName = new TextField();
        TextField addPrice = new TextField();
        TextField addStock = new TextField();

        // Set initial text in fields.
        addId.setText(" id");
        addName.setText(" product_name");
        addPrice.setText("price");
        addStock.setText("stock");

        addId.setPrefWidth(60);
        addName.setPrefWidth(100);
        addPrice.setPrefWidth(70);
        addStock.setPrefWidth(70);

        Button btnAdd = new Button("Add Product");
        btnAdd.setPrefWidth(100);
        btnAdd.setStyle("-fx-background-color:orange");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Product(
                        addId.getText(),
                        addName.getText(),
                        addPrice.getText(),
                        addStock.getText()));

                addId.clear();
                addName.clear();
                addPrice.clear();
                addStock.clear();

            }
        });

        // to take a data from user and add these data into the table 
        rowBox.getChildren().addAll(addId, addName, addPrice, addStock, btnAdd);

        vBox1.getChildren().addAll(label, tableList, rowBox);  //  all items is added  according to row

        primaryStage.setWidth(538);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Inventory Management System ");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static class Product {

        private final SimpleStringProperty id;
        private final SimpleStringProperty day;
        private final SimpleStringProperty time;
        private final SimpleStringProperty deadline;

        private Product(String id1, String day1, String time1, String deadline1) {

            this.id = new SimpleStringProperty(id1);
            this.day = new SimpleStringProperty(day1);
            this.time = new SimpleStringProperty(time1);
            this.deadline = new SimpleStringProperty(deadline1);

        }

        public String getProduct() {
            return id.get();
        }

        public void setProduct(String id1) {
            id.set(id1);
        }

        public String getName() {
            return day.get();
        }

        public void setName(String day1) {
            day.set(day1);
        }

        public String getPrice() {
            return time.get();
        }

        public void setPrice(String time1) {
            time.set(time1);
        }

        public String getStock() {
            return deadline.get();
        }

        public void setStock(String deadline1) {
            deadline.set(deadline1);
        }

        private void setToDo(String newValue) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
