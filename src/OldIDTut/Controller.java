package OldIDTut;

import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    
    public JFXTextField email_fd, pwd_fd;
    public JFXButton proceed_fd;
    public Label labb;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs) {
        this.Tuts = Tuts;
        this.Studs = Studs;
    }
    
    Controller(){}
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        proceed_fd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Tutor tu = new Tutor();
                boolean check = false;
                for (Tutor t:Tuts) {
                    if(email_fd.getText().toString().equals(t.getEmail())){
                        check = true;
                        tu = t;
                        break;
                    }
                }
                
                
                if(check){
                    try
                    {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewForTutor/ViewForTutor.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
        
                        ViewForTutor.Controller newextcon = fxmlLoader.getController();
                        newextcon.listinjector(Tuts, Studs,tu);
        
                        Stage stage = new Stage();
                        stage.setTitle("S");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch (Exception e) {
                        System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                    }
    
                    closeButtonAction();
                }else{
                    labb.setText("Email Not Registered. Try again");
                }
                
                
            }
        });
        
    }
    
    private void closeButtonAction() {
        Stage stage = (Stage) proceed_fd.getScene().getWindow();
        stage.close();
    }
}
