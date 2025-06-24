package App;

import Controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader layoutLoader = new FXMLLoader(getClass().getResource("/layout/base.fxml"));
        Parent layoutRoot = layoutLoader.load();

        FXMLLoader contentLoader = new FXMLLoader(getClass().getResource("/view/club/signup/index.fxml"));
        Parent content = contentLoader.load();

        Controller layoutController = layoutLoader.getController();
        layoutController.setContent(content);

        Scene scene = new Scene(layoutRoot);

        stage.setTitle("Sign Up!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}