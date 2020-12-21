package NewIDTut;

import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public JFXTextField email_fd, pwd_fd, pwd_fd2;
    public JFXButton proceed_bt;
    public Label labb;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    public void listinjector(ArrayList Tuts, ArrayList Studs) {
        this.Tuts = Tuts;
        this.Studs = Studs;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        proceed_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                boolean check = true;
                for(Tutor t : Tuts)
                {
                    if(t.getEmail().equals(email_fd.getText().toString())){
                        labb.setText("Email Already exists, enter a different email.");
                        check = false;
                        break;
                    }
                }
                
                if(check) {
                    try
                    {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewTutor/NewTutor.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
        
                        NewTutor.Controller con = fxmlLoader.getController();
                        con.listinjector(Tuts, Studs,email_fd.getText(),pwd_fd2.getText());
        
                        Stage stage = new Stage();
                        stage.setTitle("Add Your Information");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch (Exception e) {
                        System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                    }
                    closeButtonAction();
                }
                
            }
        });
    }
    
    private void closeButtonAction() {
        Stage stage = (Stage) proceed_bt.getScene().getWindow();
        stage.close();
    }
}