package MainSource;

import Service.jdbcUtils;
import MainSource.ConnectionUtil;
import MainSource.ConnectionUtil;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author hi
 */
public class Login implements Initializable {
     Stage window;
    Scene scene1, scene2;
    @FXML
    private TextField txtUser; 
    @FXML
    private PasswordField pwdPass; 

    Stage dialogStage = new Stage();
    Scene scene;
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public static int loginid;
    
    public Login() {
        connection = jdbcUtils.getConn();
    }
    
    @FXML
    private Button btn2;
    @FXML
    private void handleButtonAction1(ActionEvent event)  {
        String email = txtUser.getText();
        String password = pwdPass.getText();
    
        String sql = "SELECT * FROM account WHERE tai_khoan = ? and mat_khau = ?";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                infoBox("Sai tài khoản hoặc mật khẩu ", null, "Failed");
            }else{
                this.loginid = resultSet.getInt("id_account");
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                dialogStage.close();
                String tmp = (resultSet.getString("loai_tai_khoan"));
//                scene = new Scene(FXMLLoader.load(getClass().getResource("XemDiem_Sv.fxml")));
                String page = "Menu"+tmp+".fxml";
                System.out.println(page);
                scene = new Scene(FXMLLoader.load(getClass().getResource(page)));
                //dialogStage.setTitle(resultSet.getString("tai_khoan"));
                dialogStage.setScene(scene);
                dialogStage.show();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        Stage stage;
//        Parent root;
//      
//        stage = (Stage) btn2.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("XemDiem_Sv.fxml"));
//        
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
    
    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
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
        this.loginid = -1;
    }   
     
}