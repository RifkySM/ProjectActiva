package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String view = "/view/club/signup/index.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sign Up!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}