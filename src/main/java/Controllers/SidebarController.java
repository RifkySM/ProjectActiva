package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.List;

public class SidebarController {

    @FXML private Button btnMenuDashboard;
    @FXML private Button btnMenuClubList;
    @FXML private Button btnMenuLogout;
    @FXML private Button btnMenuMyClubList;
    @FXML private Button btnMenuMyRequest;
    @FXML private Button btnMenuProfile;

    private List<Button> menuButtons;
    private Controller mainController;

    @FXML
    public void initialize(){
        menuButtons = List.of(
                btnMenuDashboard,
                btnMenuClubList,
                btnMenuLogout,
                btnMenuMyClubList,
                btnMenuMyRequest,
                btnMenuProfile
        );
    }

    public void setMainController(Controller mainController) {
        this.mainController = mainController;
    }
    public void setButtonActive(Button activeButton) {
        for (Button button : menuButtons) {
            if (button.equals(activeButton)) {
                button.setStyle("-fx-background-color: #1e40af; -fx-font-weight: bold;"); // bg-blue-800 and bold
            } else {
                button.setStyle("-fx-background-color: transparent; -fx-font-weight: normal;"); // transparent and base font
            }
        }
    }

    @FXML protected void handleBtnDashboard() throws IOException {
        setButtonActive(btnMenuDashboard);
        mainController.handleBtnDashboard();
    }

    @FXML protected void handlebtnMenuClubList() throws IOException {
        setButtonActive(btnMenuClubList);
        mainController.handlebtnMenuClubList();
    }

    @FXML protected void handlebtnMenuMyClubList() throws IOException {
        setButtonActive(btnMenuMyClubList);
        mainController.handlebtnMenuMyClubList();
    }

    @FXML protected void handlebtnMenuMyRequest() throws IOException {
        setButtonActive(btnMenuMyRequest);
        mainController.handlebtnMenuMyRequest();
    }

    @FXML protected void handlebtnMenuProfile() throws IOException {
        setButtonActive(btnMenuProfile);
        mainController.handlebtnMenuProfile();
    }

    @FXML protected void handlebtnMenuLogout() throws IOException {
        mainController.handlebtnMenuLogout();
    }
}
