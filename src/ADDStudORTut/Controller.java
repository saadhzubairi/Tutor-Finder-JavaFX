package ADDStudORTut;

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
    
    public JFXButton plus_stu;
    public JFXButton plus_tu;
    
    ArrayList Tuts = new ArrayList<>();
    ArrayList Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs) {
        this.Tuts = Tuts;
        this.Studs = Studs;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        plus_stu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewStudent/NewStudent.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
        
                    NewStudent.Controller mycon = fxmlLoader.getController();
                    mycon.listinjector(Tuts, Studs,true);
        
                    Stage stage = new Stage();
                    stage.setTitle("Add Your Information");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }
                catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                    System.out.println();
                    e.printStackTrace();
                }
            }
        });
        
        plus_tu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewTutor/NewTutor.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
        
                    NewTutor.Controller con = fxmlLoader.getController();
                    con.listinjector1(Tuts,true);
        
                    Stage stage = new Stage();
                    stage.setTitle("Add Your Information");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }
                catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
            }
        });
    }
}
