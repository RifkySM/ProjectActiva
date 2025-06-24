package Controllers;

import App.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML protected AnchorPane rootPane;
    @FXML protected StackPane contentPane;
    @FXML private AnchorPane sidebar;
    private SidebarController sidebarController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout/sidebar.fxml"));
                Node sidebarNode = loader.load();

                sidebarController = loader.getController();
                sidebarController.setMainController(this);

                // Anchor to all sides (top, right, bottom, left)
                AnchorPane.setTopAnchor(sidebarNode, 0.0);
                AnchorPane.setRightAnchor(sidebarNode, 0.0);
                AnchorPane.setBottomAnchor(sidebarNode, 0.0);
                AnchorPane.setLeftAnchor(sidebarNode, 0.0);

                sidebar.getChildren().add(sidebarNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        rootPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((obs2, oldWindow, newWindow) -> {
                    if (newWindow != null && newWindow instanceof Stage) {
                        initializeWindowControls((Stage) newWindow);
                    }
                });
            }
        });
    }

    protected void initializeWindowControls(Stage stage) {
        stage.initStyle(StageStyle.UNDECORATED);
        setupDragListeners();
    }

    private void setupDragListeners() {
        rootPane.setOnMousePressed(this::handleMousePressed);
        rootPane.setOnMouseDragged(this::handleMouseDragged);
    }

    @FXML
    private void handleMousePressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    private void handleMouseDragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    @FXML
    protected void handleClose() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void handleMinimize() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    protected void handleMaximize() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }

    public void setContent(Node node) {
        contentPane.getChildren().setAll(node);
    }

    public Parent getView(String view_path) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(view_path));
        return loader.load();
    }

    public void handleBtnDashboard() throws IOException {
        Parent view = getView("/view/dashboard/index.fxml");
        setContent(view);
    }
    public void handlebtnMenuClubList() throws IOException {
        Parent view = getView("/view/club/index.fxml");
        setContent(view);
    }
    public void handlebtnMenuMyClubList() throws IOException {
        Parent view = getView("/view/user/clubs.fxml");
        setContent(view);
    }
    public void handlebtnMenuMyRequest() throws IOException {
        Parent view = getView("/view/user/requests.fxml");
        setContent(view);
    }
    public void handlebtnMenuProfile() throws IOException {
        Parent view = getView("/view/user/profile.fxml");
        setContent(view);
    }
    public void handlebtnMenuLogout() throws IOException {
    }
}
