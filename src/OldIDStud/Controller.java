package OldIDStud;

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
    
    public JFXTextField email_fd, pwd_fd;
    public JFXButton proceed_fd;
    public JFXButton closebt, minbt;
    public Label labb;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs) {
        this.Tuts = Tuts;
        this.Studs = Studs;
    }
    
    public Controller() { }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        proceed_fd.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Student stu = new Student();
                boolean check = false;
                for (Student s : Studs) {
                    if(s.getEmail().equals(email_fd.getText()))
                    {
                        //labb.setText("Email Already Exists, Please Enter a new Email!");
                        check = true;
                        stu = s;
                        break;
                    }
                }
                
                if(check){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewForStudent/ViewForStudent.fxml"));
                        Parent rootx = fxmlLoader.load();
        
                        //Injecting Data to the New Or Existing ID Window
                        ViewForStudent.Controller newextcon = fxmlLoader.getController();
                        newextcon.listinjector(Tuts, Studs,stu);
        
                        Stage stage = new Stage();
                        stage.setTitle("Tutors Near You!");
                        stage.setScene(new Scene(rootx));
                        stage.show();
                    }catch (Exception e) {
                        System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                    }
                    closeButtonAction();
                }
                
                else{
                    labb.setText("Email Not Registered. Try again");
                }
                
            }
        });
    }
    private void closeButtonAction() {
        Stage stage = (Stage) closebt.getScene().getWindow();
        stage.close();
    }
}
