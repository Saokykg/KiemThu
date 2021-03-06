/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainSource;

import Service.Utils;
import Service.jdbcUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** OK?
 * hoi bat teamview m thuyet trinh luon di
 * @author jacky
 */

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Utils.resetDB();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
       
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void stop() throws Exception {
        jdbcUtils.getConn().close();
        super.stop(); //To change body of generated methods, choose Tools | Templates.\
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
