package ViewStudent;

import MainScreen.Student;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label Age;
    public Label Sex;
    public Label Email;
    public Label Phoneno;
    public Label Location;
    public Label Name;
    public Label Board;
    public Label Classs;
    public Label LR;
    public Label SRQ;
    public JFXButton close;
    
    Student in = new Student();
    
    public void injectst(Student s){
        this.in = s;
        Age.setText         ("Age:\t\t\t"+in.getAge());
        Sex.setText         ("Sex:\t\t\t"+in.getSex());
        Email.setText       ("Email\t\t"+in.getEmail());
        Phoneno.setText     ("Phone#:\t\t"+in.getPhone_no());
        Location.setText    ("Location:\t\t"+in.getLocation());
        Name.setText        ("Name:\t\t"+in.getName());
        Board.setText       ("Board:\t\t"+in.getBoard());
        Classs.setText      ("Class:\t\t"+in.getClasss());
        LR.setText          ("Last Result:\t"+in.getLastResult());
        SRQ.setText         ("Special Req:\t"+in.getSpec_req());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) close.getScene().getWindow();
                stage.close();
            }
        });
    }
}
