package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The App class inherits from the Application class, and is used to open scene windows.
 *
 * @author James Blankenship
 * @version 1.0
 */
public class App extends Application {

    private static Scene scene;

    /**
     * @param stage is the stage that starts the application.
     * @throws IOException if stage cannot be found.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 925, 460);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * @param file is the FXML file to be loaded into the scene.
     * @throws IOException if the FXML file cannot be found.
     */
    public static void update(String file) throws IOException {
        Stage stage = new Stage();
        scene = new Scene(loadFXML(file), 750, 500);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * @param file is the FXML file to be loaded into the scene.
     * @throws IOException if the FXML file cannot be found.
     */
    public static void updateProduct(String file) throws IOException {
        Stage stage = new Stage();
        scene = new Scene(loadFXML(file), 995, 725);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * @param file is the FXML file to be loaded into the scene.
     * @throws IOException if the FXML file cannot be found.
     */
    public static void updateError(String file) throws IOException {
        Stage stage = new Stage();
        scene = new Scene(loadFXML(file), 394, 186);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
    }

    /**
     * @param file is the FXML file to be loaded into the scene.
     * @throws IOException if the FXML file cannot be found.
     */
    public static void addErrorPart(String file) throws IOException {
        Stage stage = new Stage();
        scene = new Scene(loadFXML(file), 394, 330);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());

    }

    /**
     * @param fxml is the FXML file to be loaded into the scene as the root.
     * @throws IOException if the FXML file cannot be found.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * @param fxml is the FXML file to be loaded into the FXML Loader.
     * @return the loaded parent FXML file.
     * @throws IOException if FXML file cannot be found.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * FUTURE ENHANCEMENT: if this application was to be updated again, I would extend the functionality
     * by adding a database to hold the data. The application in its current state loses all data when
     * it closes. I would also like to condense some of my fxml files by updating labels on one scene
     * instead of creating new scenes, therefore conserving memory.<br><br>
     *
     * The Javadoc folder is located in the zip file @ "Software/Javadoc"
     *
     * @param args the arguments needed to start the main method.
     */
    public static void main(String[] args) {

        launch();
    }
}