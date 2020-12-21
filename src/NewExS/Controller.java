package NewExS;

import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public JFXButton minbt;
    public JFXButton closebt;
    public JFXButton cr_new_bt;
    public JFXButton log_in_bt;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs) {
        this.Tuts = Tuts;
        this.Studs = Studs;
    }
    
    public Controller() { }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cr_new_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewIDStud/NewIDStud.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
    
                    /*Injecting Data to the New Or Existing ID Window*/
                    NewIDStud.Controller newextcon = fxmlLoader.getController();
                    newextcon.listinjector(Tuts, Studs);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Create New Student ID");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
                closeButtonAction();
            }
        });
        
        log_in_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/OldIDStud/OldIDStud.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
    
                    /*Injecting Data to the New Or Existing ID Window*/
                    OldIDStud.Controller newextcon = fxmlLoader.getController();
                    newextcon.listinjector(Tuts, Studs);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Log in");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
                closeButtonAction();
            }
        });
    }
    private void closeButtonAction() {
        Stage stage = (Stage) closebt.getScene().getWindow();
        stage.close();
    }
}
