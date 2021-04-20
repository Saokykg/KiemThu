package MainSource;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
 
/**
 *
 * @author hi
 */
public class XemDiem_Sv implements Initializable {
     
    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtUser; 
    @FXML
    private PasswordField pwdPass; 
    @FXML
    private Button btnLogin;
     
    private final String _USERNAME = "administrators";
    private final String _PASSWORD = "abc123";
    private final String _CSSERRFIELD = "txtFieldError";
     
     
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = txtUser.getText();
        String password = pwdPass.getText();
         
        if (username != null && username .equals(_USERNAME)){
            if (password != null && password.equals(_PASSWORD)){
                //thanh cong
                validationStyle(true, true);
                 
                Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Login");
                    alert.setHeaderText(null);
                    alert.setContentText("Login success!");
                    alert.showAndWait();
            } else {
                validationStyle(true, false);
            }
        } else {
            validationStyle(false, false);
        }
    }
     
    public void validationStyle(boolean _user, boolean _pass){
        if (_user){
            txtUser.getStyleClass().removeAll("txtFieldError");
            txtUser.getStyleClass().add("txtField");
        }else{
            txtUser.getStyleClass().add("txtFieldError");
        }
         
        if (_pass){
            pwdPass.getStyleClass().removeAll("txtFieldError");
            pwdPass.getStyleClass().add("txtField");
        }else{
            pwdPass.getStyleClass().add("txtFieldError");
        }
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     
}