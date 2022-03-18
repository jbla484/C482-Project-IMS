package org.example;

import java.io.IOException;
import java.util.Objects;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * The Controller class allows the GUI to be created and modified as needed. It creates
 * different objects and assigns values to those objects based on user input.
 *
 * @author James Blankenship
 * @version 1.0
 */
public class Controller {

    // TableViews
    @FXML
    public TableView<Part> partTable = new TableView<>();
    @FXML
    public TableView<Product> productTable = new TableView<>();
    @FXML
    public TableView<Part> partAndProductTable = new TableView<>();
    @FXML
    public TableView<Part> associatedPartsTable = new TableView<>();

    // TableColumns
    @FXML
    public TableColumn<Part, Number> partIdCol = new TableColumn<>("Part ID");
    @FXML
    public TableColumn<Part, String> partNameCol = new TableColumn<>("Part Name");
    @FXML
    public TableColumn<Part, Number> partInvCol = new TableColumn<>("Inventory Level");
    @FXML
    public TableColumn<Part, Number> partPriceCol = new TableColumn<>("Price / Cost per Unit");

    @FXML
    public TableColumn<Product, Number> productIdCol = new TableColumn<>("Product ID");
    @FXML
    public TableColumn<Product, String> productNameCol = new TableColumn<>("Product Name");
    @FXML
    public TableColumn<Product, Number> productInvCol = new TableColumn<>("Inventory Level");
    @FXML
    public TableColumn<Product, Number> productPriceCol = new TableColumn<>("Price / Cost per Unit");

    @FXML
    public TableColumn<Part, Number> partAndProductIdCol = new TableColumn<>("Product ID");
    @FXML
    public TableColumn<Part, String> partAndProductNameCol = new TableColumn<>("Product Name");
    @FXML
    public TableColumn<Part, Number> partAndProductInvCol = new TableColumn<>("Inventory Level");
    @FXML
    public TableColumn<Part, Number> partAndProductPriceCol = new TableColumn<>("Price / Cost per Unit");

    @FXML
    public TableColumn<Part, Number> associatedPartsIdCol = new TableColumn<>("Product ID");
    @FXML
    public TableColumn<Part, String> associatedPartsNameCol = new TableColumn<>("Product Name");
    @FXML
    public TableColumn<Part, Number> associatedPartsInvCol = new TableColumn<>("Inventory Level");
    @FXML
    public TableColumn<Part, Number> associatedPartsPriceCol = new TableColumn<>("Price / Cost per Unit");

    // Buttons
    @FXML
    public Button closeButton;
    @FXML
    public Button saveButton;
    @FXML
    public Button removeButton;
    @FXML
    public Button addButton;
    @FXML
    public Button confirmButton;

    // TextFields
    @FXML
    public TextField id = new TextField();
    @FXML
    public TextField id2 = new TextField();
    @FXML
    public TextField id3 = new TextField();
    @FXML
    public TextField id4 = new TextField();
    @FXML
    public TextField id5 = new TextField();
    @FXML
    public TextField name = new TextField();
    @FXML
    public TextField name2 = new TextField();
    @FXML
    public TextField name3 = new TextField();
    @FXML
    public TextField name4 = new TextField();
    @FXML
    public TextField name5 = new TextField();
    @FXML
    public TextField inv = new TextField();
    @FXML
    public TextField inv2 = new TextField();
    @FXML
    public TextField inv3 = new TextField();
    @FXML
    public TextField inv4 = new TextField();
    @FXML
    public TextField inv5 = new TextField();
    @FXML
    public TextField price = new TextField();
    @FXML
    public TextField price2 = new TextField();
    @FXML
    public TextField price3 = new TextField();
    @FXML
    public TextField price4 = new TextField();
    @FXML
    public TextField price5 = new TextField();
    @FXML
    public TextField max = new TextField();
    @FXML
    public TextField max2 = new TextField();
    @FXML
    public TextField max3 = new TextField();
    @FXML
    public TextField max4 = new TextField();
    @FXML
    public TextField max5 = new TextField();
    @FXML
    public TextField min = new TextField();
    @FXML
    public TextField min2 = new TextField();
    @FXML
    public TextField min3 = new TextField();
    @FXML
    public TextField min4 = new TextField();
    @FXML
    public TextField min5 = new TextField();
    @FXML
    public TextField machineId = new TextField();
    @FXML
    public TextField machineId2 = new TextField();
    @FXML
    public TextField companyName = new TextField();
    @FXML
    public TextField companyName2 = new TextField();
    @FXML
    public TextField search = new TextField();
    @FXML
    public TextField search2 = new TextField();
    @FXML
    public TextField search3 = new TextField();

    // Labels
    @FXML
    public Label addErrorDesc = new Label();
    @FXML
    public Label addErrorDesc2 = new Label();
    @FXML
    public Label partDelete = new Label();

    // Variables
    @FXML
    static int partIds = 1;
    @FXML
    static String partNames = "";
    @FXML
    static int partInvs;
    @FXML
    static double partPrices;
    @FXML
    static int partMin;
    @FXML
    static int partMax;
    @FXML
    static int partMachineId = 0;
    @FXML
    static int partMachineId2 = 0;
    @FXML
    static String partCompanyName;
    @FXML
    static String partCompanyName2 = "";
    @FXML
    static boolean inhouse;

    @FXML
    static int productIds = 1001;
    @FXML
    static String productNames;
    @FXML
    static int productInvs;
    @FXML
    static double productPrices;
    @FXML
    static int productMin;
    @FXML
    static int productMax;
    @FXML
    static boolean product;

    @FXML
    static Part partToRemove;
    @FXML
    static Product productToRemove;

    @FXML
    static boolean partDeleted = false;
    @FXML
    static boolean partModify = false;
    @FXML
    static boolean productModify = false;
    @FXML
    static boolean minIsBigger;
    @FXML
    static boolean invOutOfBounds;

    // Lists of Part objects
    static ObservableList<Part> listOfInhouse = FXCollections.observableArrayList();
    static ObservableList<Part> listOfOutsourced = FXCollections.observableArrayList();
    static ObservableList<Part> listOfPartsAndProducts = FXCollections.observableArrayList();
    static ObservableList<Part> allAssociatedParts = FXCollections.observableArrayList();
    static ObservableList<Part> associatedPartsToDelete = FXCollections.observableArrayList();

    /**
     * Handles the initiation of the GUIs to set the proper text-fields with text.
     */
    public void initialize(){

        // Sets Cell Value Factory for columns
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        productIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        partAndProductIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partAndProductNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        partAndProductInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partAndProductPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartsIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartsNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartsInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartsPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Sets Cell Value Factory for cells
        partIdCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getId()));
        partNameCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        partInvCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getStock()));
        partPriceCol.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getPrice()));

        productIdCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getId()));
        productNameCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        productInvCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getStock()));
        productPriceCol.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getPrice()));

        partAndProductIdCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getId()));
        partAndProductNameCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        partAndProductInvCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getStock()));
        partAndProductPriceCol.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getPrice()));

        associatedPartsIdCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getId()));
        associatedPartsNameCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        associatedPartsInvCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getStock()));
        associatedPartsPriceCol.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getPrice()));

        // Populates the tables
        partTable.setItems(Inventory.getAllParts());
        productTable.setItems(Inventory.getAllProducts());
        partAndProductTable.setItems(listOfPartsAndProducts);
        associatedPartsTable.setItems(allAssociatedParts);

        // Sets text of TextFields
        if (inhouse) {
            // In-house part Modify
            id2.setText(String.valueOf(partIds));
            name2.setText(partNames);
            inv2.setText(String.valueOf(partInvs));
            price2.setText(String.valueOf(partPrices));
            max2.setText(String.valueOf(partMax));
            min2.setText(String.valueOf(partMin));
            machineId2.setText(String.valueOf(partMachineId));

        } else {
            // Outsourced part
            id3.setText(String.valueOf(partIds));
            name3.setText(partNames);
            inv3.setText(String.valueOf(partInvs));
            price3.setText(String.valueOf(partPrices));
            max3.setText(String.valueOf(partMax));
            min3.setText(String.valueOf(partMin));
            companyName2.setText(String.valueOf(partCompanyName));
        }

        if (product) {
            // In-house part Modify
            id5.setText(String.valueOf(productIds));
            name5.setText(productNames);
            inv5.setText(String.valueOf(productInvs));
            price5.setText(String.valueOf(productPrices));
            max5.setText(String.valueOf(productMax));
            min5.setText(String.valueOf(productMin));

        }

        // Sets text of Labels for exceptions
        String errorOutput = "";
        String errorOutputProduct = "";
        String errorOutputPartAdd = "";

        if (Objects.equals(partNames, "")) {
            errorOutput += "- No data was entered in the name field.\n";
        }
        if (partInvs == 0) {
            errorOutput += "- The inventory field is not an integer.\n";
        }
        if (partPrices == 0) {
            errorOutput += "- The price field is not a double.\n";
        }
        if (partMax == 0) {
            errorOutput += "- The max field is not an integer.\n";
        }
        if (partMin == 0) {
            errorOutput += "- The min field is not an integer.\n";
        }
        if (inhouse) {
            if (partMachineId == 0) {
                errorOutput += "- The machine ID field is not an integer.\n";
            }
        } else {
            errorOutput += "- No data was entered in the company name field.\n";
        }
        if (minIsBigger) {
            errorOutput += "- Min must be less than Max.\n";
        }
        if (invOutOfBounds) {
            errorOutput += "- Inv must be between Min and Max.\n";
        }

        if (Objects.equals(productNames, "")) {
            errorOutputProduct += "- No data was entered in the name field.\n";
        }
        if (productInvs == 0) {
            errorOutputProduct += "- The inventory field is not an integer.\n";
        }
        if (productPrices == 0) {
            errorOutputProduct += "- The price field is not a double.\n";
        }
        if (productMax == 0) {
            errorOutputProduct += "- The max field is not an integer.\n";
        }
        if (productMin == 0) {
            errorOutputProduct += "- The min field is not an integer.\n";
        }
        if (minIsBigger) {
            errorOutputProduct += "- Min must be less than Max.\n";
        }
        if (invOutOfBounds) {
            errorOutputProduct += "- Inv must be between Min and Max.\n";
        }

        if (partDeleted) {
            errorOutputPartAdd += "- To add an associated part, you must first select one.\n";
        }

        if (partModify) {
            errorOutputPartAdd += "To modify a part, you must first select one.\n";
        }

        if (productModify) {
            errorOutputPartAdd += "To modify a product, you must first select one.\n";
        }

        addErrorDesc.setText(errorOutput);
        addErrorDesc2.setText(errorOutputProduct);
        partDelete.setText(errorOutputPartAdd);

        // Sets an action event for the search TextFields
        search.setOnMouseClicked(event -> searchPart());
        search2.setOnMouseClicked(event -> searchProduct());
        search3.setOnMouseClicked(event -> searchPartAndProduct());
    }

    /**
     * Handles the search part action event for the search part text-field.
     */
    @FXML
    public void searchPart() {

        FilteredList<Part> filteredData = new FilteredList<>(Inventory.getAllParts());

        // Set the filter when the filter changes
        search.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(Part -> {

            // If the filter text is empty, display all parts
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare part ID and name field in the part object with filter.
            String caseFilter = newValue.toLowerCase();

            if (String.valueOf(Part.getId()).toLowerCase().contains(caseFilter)) {
                return true;
                // Filter matches part Id.

            } else {
                return String.valueOf(Part.getName()).toLowerCase().contains(caseFilter);
                // Filter matches part name.
            }
        }));

        // Wrap and add data to the TableView
        SortedList<Part> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(partTable.comparatorProperty());
        partTable.setItems(sortedData);
    }

    /**
     * Handles the search product action event for the search product text-field.
     */
    @FXML
    public void searchProduct() {

        FilteredList<Product> filteredData = new FilteredList<>(Inventory.getAllProducts());

        // Set the filter when the filter changes
        search2.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(Product -> {

            // If the filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare product ID and name field in the product object with filter.
            String caseFilter = newValue.toLowerCase();

            if (String.valueOf(Product.getId()).toLowerCase().contains(caseFilter)) {
                return true;
                // Filter matches product ID.

            } else {
                return String.valueOf(Product.getName()).toLowerCase().contains(caseFilter);
                // Filter matches name.
            }
        }));

        // Wrap and add data to the TableView
        SortedList<Product> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(productTable.comparatorProperty());
        productTable.setItems(sortedData);
    }

    /**
     * Handles the search product action event for the search part and product text-field.
     */
    @FXML
    public void searchPartAndProduct() {

        FilteredList<Part> filteredData = new FilteredList<>(listOfPartsAndProducts);

        // Set the filter when the filter changes
        search3.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(Part -> {

            // If the filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            // Compare part ID and part name field in the part object with filter.
            String caseFilter = newValue.toLowerCase();

            if (String.valueOf(Part.getId()).toLowerCase().contains(caseFilter)) {
                return true;
                // Filter matches part ID.

            } else {
                return String.valueOf(Part.getName()).toLowerCase().contains(caseFilter);
                // Filter matches part name.
            }
        }));

        // Wrap and add data to the TableView
        SortedList<Part> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(partAndProductTable.comparatorProperty());
        partAndProductTable.setItems(sortedData);
    }

    /**
     * @param part to add to list of parts and products
     */
    @FXML
    public void addToPartAndProductTable(Part part) {
        listOfPartsAndProducts.add(part);
    }

    /**
     * Handles the close button action event for all GUIs.
     */
    @FXML
    public void handleCloseButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Handles the save button action event for the Inhouse add part GUI.<br><br>
     * RUNTIME ERROR: the application crashes when no values are input, or incorrect input values are saved.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if part inputs are missing when saved, or when incorrect input has been saved.
     */
    @FXML
    public void handleSaveButtonActionPart() throws IOException {

        Stage stage = (Stage) saveButton.getScene().getWindow();

        try {

            for (Part part : Inventory.getAllParts()) {
                if (partIds == part.getId()) {
                    ++partIds;
                }
            }

            inhouse = true;

            partNames = name.getText();
            partInvs = Integer.parseInt(inv.getText());
            partPrices = Double.parseDouble(price.getText());
            partMax = Integer.parseInt(max.getText());
            partMin = Integer.parseInt(min.getText());
            partMachineId = Integer.parseInt(machineId.getText());
            partCompanyName2 = "";

            if (partMin > partMax) {
                minIsBigger = true;
                throw new RuntimeException();
            }
            if (partInvs > partMax || partInvs < partMin) {
                invOutOfBounds = true;
                throw new RuntimeException();
            }

            InHouse housePart = new InHouse(partIds, partNames, partPrices, partInvs, partMin, partMax, partMachineId);

            ++partIds;

            listOfInhouse.add(housePart);
            Inventory.addPart(housePart);
            addToPartAndProductTable(housePart);

            partTable.setItems(Inventory.getAllParts());
            partTable.refresh();

            housePart.setMachineId(partMachineId);
            partMachineId2 = housePart.getMachineId();

            partNames = "";
            partInvs = 0;
            partPrices = 0;
            partMax = 0;
            partMin = 0;
            minIsBigger = false;
            invOutOfBounds = false;

            stage.close();

        } catch (Exception e) {

            switchToAddErrorPart();
        }
    }

    /**
     * Handles the save button action event for the Outsourced add part GUI.<br><br>
     * RUNTIME ERROR: the application crashes when no values are input, or incorrect input values are saved.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if part inputs are missing when saved, or when incorrect input has been saved.
     */
    @FXML
    public void handleSaveButtonActionPart2() throws IOException {
        //Adds Outsourced part

        Stage stage = (Stage) saveButton.getScene().getWindow();

        try {

            inhouse = false;

            partNames = name.getText();
            partInvs = Integer.parseInt(inv.getText());
            partPrices = Double.parseDouble(price.getText());
            partMin = Integer.parseInt(min.getText());
            partMax = Integer.parseInt(max.getText());
            partCompanyName = companyName.getText();

            if (partMin > partMax) {
                minIsBigger = true;
                throw new RuntimeException();
            }
            if (partInvs > partMax || partInvs < partMin) {
                invOutOfBounds = true;
                throw new RuntimeException();
            }

            Outsourced outsourcedPart = new Outsourced(partIds, partNames, partPrices, partInvs, partMin, partMax, partCompanyName);

            listOfOutsourced.add(outsourcedPart);
            Inventory.addPart(outsourcedPart);
            addToPartAndProductTable(outsourcedPart);

            ++partIds;

            outsourcedPart.setCompanyName(partCompanyName);
            partCompanyName2 = outsourcedPart.getCompanyName();
            partMachineId2 = 0;

            partNames = "";
            partInvs = 0;
            partPrices = 0;
            partMax = 0;
            partMin = 0;
            minIsBigger = false;

            stage.close();

        } catch (Exception e) {

            switchToAddErrorPart();
        }
    }

    /**
     * Handles the save button action event for the Inhouse modify part GUI.<br><br>
     * RUNTIME ERROR: the application crashes when no values are input, or incorrect input values are saved.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if part inputs are missing when saved, or when incorrect input has been saved.
     */
    @FXML
    public void handleSaveButtonActionPart3() throws IOException {

        Stage stage = (Stage) saveButton.getScene().getWindow();

        try {

            partNames = name2.getText();
            partInvs = Integer.parseInt(inv2.getText());
            partPrices = Double.parseDouble(price2.getText());
            partMin = Integer.parseInt(min2.getText());
            partMax = Integer.parseInt(max2.getText());
            partMachineId = Integer.parseInt(machineId2.getText());
            partCompanyName2 = "";

            if (partMin > partMax) {
                minIsBigger = true;
                throw new RuntimeException();
            }
            if (partInvs > partMax || partInvs < partMin) {
                invOutOfBounds = true;
                throw new RuntimeException();
            }

            InHouse housePart = new InHouse(partIds, partNames, partPrices, partInvs, partMin, partMax, partMachineId);

            ++partIds;

            listOfInhouse.add(housePart);
            Inventory.updatePart(partIds, housePart);

            partTable.setItems(Inventory.getAllParts());
            partTable.refresh();

            housePart.setMachineId(partMachineId);
            partMachineId2 = housePart.getMachineId();

            partNames = "";
            partInvs = 0;
            partPrices = 0;
            partMax = 0;
            partMin = 0;
            minIsBigger = false;

            stage.close();

        } catch (Exception e) {

            switchToAddErrorPart();
        }
    }

    /**
     * Handles the save button action event for the Outsourced modify part GUI.<br><br>
     * RUNTIME ERROR: the application crashes when no values are input, or incorrect input values are saved.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if part inputs are missing when saved, or when incorrect input has been saved.
     */
    @FXML
    public void handleSaveButtonActionPart4() throws IOException {

        Stage stage = (Stage) saveButton.getScene().getWindow();

        try {

            partNames = name3.getText();
            partInvs = Integer.parseInt(inv3.getText());
            partPrices = Double.parseDouble(price3.getText());
            partMin = Integer.parseInt(min3.getText());
            partMax = Integer.parseInt(max3.getText());
            partCompanyName = companyName2.getText();

            if (partMin > partMax) {
                minIsBigger = true;
                throw new RuntimeException();
            }
            if (partInvs > partMax || partInvs < partMin) {
                invOutOfBounds = true;
                throw new RuntimeException();
            }

            Outsourced housePart = new Outsourced(partIds, partNames, partPrices, partInvs, partMin, partMax, partCompanyName);

            ++partIds;

            listOfOutsourced.add(housePart);
            Inventory.updatePart(partIds, housePart);

            partTable.setItems(Inventory.getAllParts());
            partTable.refresh();

            housePart.setCompanyName(partCompanyName);
            partCompanyName2 = housePart.getCompanyName();
            partMachineId2 = 0;

            partNames = "";
            partInvs = 0;
            partPrices = 0;
            partMax = 0;
            partMin = 0;
            minIsBigger = false;

            stage.close();

        } catch (Exception e) {

            switchToAddErrorPart();
        }
    }

    /**
     * Handles the save button action event for a product.<br><br>
     * RUNTIME ERROR: the application crashes when no values are input, or incorrect input values are saved.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if product inputs are missing when saved, or when incorrect input has been saved.
     */
    @FXML
    public void handleSaveButtonActionProduct() throws IOException {

        Stage stage = (Stage) saveButton.getScene().getWindow();

        try {

            productNames = name4.getText();
            productInvs = Integer.parseInt(inv4.getText());
            productPrices = Double.parseDouble(price4.getText());
            productMin = Integer.parseInt(min4.getText());
            productMax = Integer.parseInt(max4.getText());

            if (productMin > productMax) {
                minIsBigger = true;
                throw new RuntimeException();
            }
            if (productInvs > productMax || productInvs < productMin) {
                invOutOfBounds = true;
                throw new RuntimeException();
            }

            Product product = new Product(productIds, productNames, productPrices, productInvs, productMin, productMax);

            ++productIds;

            for (Part part : allAssociatedParts) {
                product.addAssociatedPart(part);
            }
            for (Part part : associatedPartsToDelete) {
                product.deleteAssociatedPart(part);
            }

            Inventory.addProduct(product);

            productTable.setItems(Inventory.getAllProducts());
            productTable.refresh();

            productNames = "";
            productInvs = 0;
            productPrices = 0;
            productMax = 0;
            productMin = 0;
            minIsBigger = false;
            invOutOfBounds = false;
            allAssociatedParts.clear();
            associatedPartsToDelete.clear();

            stage.close();

        } catch (Exception e) {

            switchToAddErrorProduct();
        }
    }

    /**
     * Handles the save button action event for a modified product.<br><br>
     * RUNTIME ERROR: the application crashes when no values are input, or incorrect input values are saved.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if product inputs are missing when saved, or when incorrect input has been saved.
     */
    @FXML
    public void handleSaveButtonActionProduct2() throws IOException {

        Stage stage = (Stage) saveButton.getScene().getWindow();

        try {
            productNames = name5.getText();
            productInvs = Integer.parseInt(inv5.getText());
            productPrices = Double.parseDouble(price5.getText());
            productMin = Integer.parseInt(min5.getText());
            productMax = Integer.parseInt(max5.getText());

            if (productMin > productMax) {
                minIsBigger = true;
                throw new RuntimeException();
            }
            if (productInvs > productMax || productInvs < productMin) {
                invOutOfBounds = true;
                throw new RuntimeException();
            }

            Product product = new Product(productIds, productNames, productPrices, productInvs, productMin, productMax);

            ++productIds;

            for (Part part : allAssociatedParts) {
                product.addAssociatedPart(part);
            }
            for (Part part : associatedPartsToDelete) {
                boolean deleted = product.deleteAssociatedPart(part);

                if (deleted) {
                    System.out.print("");
                }

                allAssociatedParts.remove(part);
            }

            Inventory.updateProduct(productIds - 1000, product);

            productTable.setItems(Inventory.getAllProducts());
            productTable.refresh();

            associatedPartsTable.setItems(allAssociatedParts);
            associatedPartsTable.refresh();

            productNames = "";
            productInvs = 0;
            productPrices = 0;
            productMax = 0;
            productMin = 0;
            minIsBigger = false;
            invOutOfBounds = false;
            allAssociatedParts.clear();
            associatedPartsToDelete.clear();

            stage.close();

        } catch (Exception e) {

            switchToAddErrorProduct();
        }
    }

    /**
     * Handles the add associated part action event for a product.<br><br>
     * RUNTIME ERROR: the application crashes when no part is selected when the add button is clicked.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if no part is selected to add.
     */
    @FXML
    public void addAssociatedPart() throws IOException {

        try {

            partAndProductTable.getSelectionModel().setCellSelectionEnabled(true);
            partAndProductTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            Part selectedPart = partAndProductTable.getSelectionModel().getSelectedItem();

            if(partAndProductTable.getSelectionModel().getSelectedItem() != null) {

                allAssociatedParts.add(selectedPart);

            }
            if (allAssociatedParts.size() == 0) {
                throw new Exception();
            }

            partAndProductTable.setItems(listOfPartsAndProducts);
            partAndProductTable.refresh();

            associatedPartsTable.setItems(allAssociatedParts);
            associatedPartsTable.refresh();


        } catch (Exception e) {

            partDeleted = true;
            switchToAssociatedPartAdd();
        }
    }

    /**
     * Handles the delete button action event for a part.<br><br>
     * RUNTIME ERROR: the application crashes when no part is selected when the remove button is clicked.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if an associated part is not selected to be deleted.
     */
    @FXML
    public void handleRemoveAssociatedPart() throws IOException {

        try {

            associatedPartsTable.getSelectionModel().setCellSelectionEnabled(true);
            associatedPartsTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            Part associatedPart = associatedPartsTable.getSelectionModel().getSelectedItem();

            if (associatedPartsTable.getSelectionModel().getSelectedItem() != null) {
                switchToAssociatedPartRemove();
                partToRemove = associatedPart;
            } else {
                throw new RuntimeException();
            }


        } catch (RuntimeException e) {

            switchToDeleteErrorPart();
        }
    }

    /**
     * Handles the modify button action event for both Inhouse and Outsourced parts.<br><br>
     * RUNTIME ERROR: the application crashes when no part is selected when the modify button is clicked.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if a part is not selected to be modified.
     */
    @FXML
    public void handleModifyButtonActionPart() throws IOException {

        try {

            boolean found = false;

            partTable.getSelectionModel().setCellSelectionEnabled(true);
            partTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            Part partList = partTable.getSelectionModel().getSelectedItem();

            for (Part part : listOfInhouse) {
                if (partList == part) {
                    inhouse = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (Part part : listOfOutsourced) {
                    if (partList == part) {
                        inhouse = false;
                        break;
                    }
                }
            }

            partIds = partList.getId();

            if(partTable.getSelectionModel().getSelectedItem() != null) {

                if (inhouse) {
                    //In-house page
                    partNames = partList.getName();
                    partInvs = partList.getStock();
                    partPrices = partList.getPrice();
                    partMin = partList.getMin();
                    partMax = partList.getMax();

                    switchToFourth();
                }
                else {
                    //Outsourced page
                    partNames = partList.getName();
                    partInvs = partList.getStock();
                    partPrices = partList.getPrice();
                    partMin = partList.getMin();
                    partMax = partList.getMax();

                    switchToFifth2();
                }
            }

            partTable.setItems(Inventory.getAllParts());
            partTable.refresh();

        } catch (Exception e) {

            partDeleted = false;
            partModify = true;
            productModify = false;

            switchToAssociatedPartAdd();
        }
    }

    /**
     * Handles the modify button action event for products.<br><br>
     * RUNTIME ERROR: the application crashes when no product is selected when the modify button is clicked.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if a product is not selected to be modified.
     */
    @FXML
    public void handleModifyButtonActionProduct() throws IOException {

        try {

            productTable.getSelectionModel().setCellSelectionEnabled(true);
            productTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            Product selectedProduct = productTable.getSelectionModel().getSelectedItem();

            productIds = selectedProduct.getId();


            allAssociatedParts.addAll(selectedProduct.getAllAssociatedParts());

            if(productTable.getSelectionModel().getSelectedItem() != null) {

                product = true;

                productNames = selectedProduct.getName();
                productInvs = selectedProduct.getStock();
                productPrices = selectedProduct.getPrice();
                productMin = selectedProduct.getMin();
                productMax = selectedProduct.getMax();

                switchToSeventh();

            } else {
                product = false;
            }

            associatedPartsTable.setItems(allAssociatedParts);
            associatedPartsTable.refresh();

            productTable.setItems(Inventory.getAllProducts());
            productTable.refresh();

        } catch (Exception e) {

            partDeleted = false;
            partModify = false;
            productModify = true;

            switchToAssociatedPartAdd();
        }
    }

    /**
     * Handles the delete button action event for a part.<br><br>
     * RUNTIME ERROR: the application crashes when no part is selected when the delete button is clicked.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if a part is not selected to be deleted.
     */
    @FXML
    public void handleDeleteButtonActionPart() throws IOException {

        try {

            if (partTable.getSelectionModel().getSelectedItem() != null) {
                --partIds;
            } else {
                throw new RuntimeException();
            }

            partTable.getSelectionModel().setCellSelectionEnabled(true);
            partTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            partToRemove = partTable.getSelectionModel().getSelectedItem();

            switchToPartDelete();


        } catch (RuntimeException e) {

            switchToDeleteErrorPart();

        }
    }

    /**
     * Handles the delete button action event for a product.<br><br>
     * RUNTIME ERROR: the application crashes when no product is selected when the delete button is clicked.<br>
     * I corrected this crash by catching the exception with an error GUI allowing the application to continue.
     * @throws IOException if a product is not selected to be deleted.
     */
    @FXML
    public void handleDeleteButtonActionProduct() throws IOException {

        try {

            if (productTable.getSelectionModel().getSelectedItem() != null) {
                System.out.println();
            } else {
                throw new RuntimeException();
            }

            productTable.getSelectionModel().setCellSelectionEnabled(true);
            productTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

            productToRemove = productTable.getSelectionModel().getSelectedItem();

            if (productToRemove.getAllAssociatedParts().size() > 0) {
                switchToAssociatedPartDelete();
            } else {

                switchToProductDelete();
            }

        } catch (RuntimeException e) {

            switchToDeleteErrorProduct();

        }
    }

    /**
     * Handles the confirm button action for removing an associated part.
     */
    @FXML
    private void isTrue() {

        allAssociatedParts.remove(partToRemove);
        associatedPartsToDelete.add(partToRemove);

        associatedPartsTable.setItems(allAssociatedParts);
        associatedPartsTable.refresh();

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Handles the confirm button action for deleting a part.
     */
    @FXML
    private void isTrue2() {

        boolean deleted = Inventory.deletePart(partToRemove);

        if (deleted) {
            System.out.print("");
        }

        listOfPartsAndProducts.remove(partToRemove);

        partAndProductTable.setItems(listOfPartsAndProducts);
        partAndProductTable.refresh();

        partTable.setItems(Inventory.getAllParts());
        partTable.refresh();

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Handles the confirm button action for deleting a product.
     */
    @FXML
    private void isTrue3() {

        boolean deleted = Inventory.deleteProduct(productToRemove);

        if (deleted) {
            System.out.print("");
        }

        listOfPartsAndProducts.remove(productToRemove);
        partAndProductTable.setItems(listOfPartsAndProducts);
        partAndProductTable.refresh();

        productTable.setItems(Inventory.getAllProducts());
        productTable.refresh();

        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Switches to secondary FXML file to display the Inhouse add part GUI.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToSecondary() throws IOException {
        String fileName = "secondary";
        App.setRoot(fileName);
    }

    /**
     * Switches to secondary FXML file to display the Inhouse add part GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToSecondary2() throws IOException {
        String fileName = "secondary";
        App.update(fileName);
    }

    /**
     * Switches to third FXML file to display the Outsourced add part GUI.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToThird() throws IOException {
        String fileName = "third";
        App.setRoot(fileName);
    }

    /**
     * Switches to fourth FXML file to display the Inhouse modify part GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToFourth() throws IOException {
        String fileName = "fourth";
        App.update(fileName);
    }

    /**
     * Switches to fourth FXML file to display the Inhouse modify part GUI.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToFourthRoot() throws IOException {
        String fileName = "fourth";
        App.setRoot(fileName);
    }

    /**
     * Switches to fifth FXML file to display the Outsourced modify part GUI.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToFifth() throws IOException {
        String fileName = "fifth";
        App.setRoot(fileName);
    }

    /**
     * Switches to fifth FXML file to display the Outsourced modify part GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToFifth2() throws IOException {
        String fileName = "fifth";
        App.update(fileName);
    }

    /**
     * Switches to sixth FXML file to display the add product GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToSixth() throws IOException {
        String fileName = "sixth";
        App.updateProduct(fileName);
    }

    /**
     * Switches to seventh FXML file to display the modify product GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToSeventh() throws IOException {
        String fileName = "seventh";
        App.updateProduct(fileName);
    }

    /**
     * Switches to deleteErrorPart FXML file to display the part deletion error GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToDeleteErrorPart() throws IOException {
        String fileName = "deleteErrorPart";
        App.updateError(fileName);
    }

    /**
     * Switches to associatedPartDelete FXML file to display the associated part deletion error GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToAssociatedPartDelete() throws IOException {
        String fileName = "associatedPartDelete";
        App.updateError(fileName);
    }

    /**
     * Switches to associatedPartRemove FXML file to display the associated part remove error GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToAssociatedPartRemove() throws IOException {
        String fileName = "associatedPartRemove";
        App.updateError(fileName);
    }

    /**
     * Switches to partDelete FXML file to display the delete part GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToPartDelete() throws IOException {
        String fileName = "partDelete";
        App.updateError(fileName);
    }

    /**
     * Switches to productDelete FXML file to display the delete product GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToProductDelete() throws IOException {
        String fileName = "productDelete";
        App.updateError(fileName);
    }

    /**
     * Switches to deleteErrorProduct FXML file to display the product deletion error GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToDeleteErrorProduct() throws IOException {
        String fileName = "deleteErrorProduct";
        App.updateError(fileName);
    }

    /**
     * Switches to associatedPartDelete FXML file to display the associated part add GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    private void switchToAssociatedPartAdd() throws IOException {
        String fileName = "associatedPartDelete";
        App.updateError(fileName);
    }

    /**
     * Switches to addErrorPart FXML file to display the add part input error GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToAddErrorPart() throws IOException {
        String fileName = "addErrorPart";
        App.addErrorPart(fileName);
    }

    /**
     * Switches to addErrorProduct FXML file to display the add product input error GUI in a new window.
     * @throws IOException throws an IOException if file cannot be found.
     */
    @FXML
    private void switchToAddErrorProduct() throws IOException {
        String fileName = "addErrorProduct";
        App.addErrorPart(fileName);
    }
}
