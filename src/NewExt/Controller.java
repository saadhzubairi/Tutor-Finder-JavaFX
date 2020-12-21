package NewExt;

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
    
    public JFXButton closebt, minbt;
    public JFXButton cr_new_bt, log_in_bt;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs) {
        this.Tuts = Tuts;
        this.Studs = Studs;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        cr_new_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewIDTut/NewIDTut.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
    
                    /*Injecting Data into New Tutor Window*/
                    NewIDTut.Controller con = fxmlLoader.getController();
                    con.listinjector(Tuts, Studs);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Create New Tutor Profile");
                    stage.setScene(new Scene(root1));
                    stage.show();
                    
                    closeButtonAction();
                }
                catch (Exception e){
                    System.out.println("ERROR LOADING WINDOW" +"\n"+ e);
                }
                closeButtonAction();
            }
        });
        
        log_in_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/OldIDTut/OldIDTut.fxml"));
    
                    /*Injecting Data To Log in window*/
                    OldIDTut.Controller con = fxmlLoader.getController();
                    con.listinjector(Tuts,Studs);
                    
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Log in as a Tutor");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }
                catch (Exception e){
                    System.out.println("ERROR LOADING WINDOW" +"\n");
                    e.printStackTrace();
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
