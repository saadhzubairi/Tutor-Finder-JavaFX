package ViewTutor;

import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label loco;
    public Label Age;
    public Label Sex;
    public Label Email;
    public Label Phono;
    public Label poloco;
    public Label Name;
    public Label Status;
    public Label Qualoco;
    public Label Expoco;
    public Label Bio;
    public JFXButton Close;
    
    Tutor t = new Tutor();
    
    public void injectt(Tutor tu){
        this.t = tu;
        loco.       setText("Location:\t\t\t\t"         + t.getLocation());
        Age.        setText("Age:\t\t\t\t\t"            + t.getAge());
        Sex.        setText("Gender:\t\t\t\t"           + t.getSex());
        Email.      setText("Email:\t\t\t\t"            + t.getEmail());
        Phono.      setText("Phone#:\t\t\t\t"           + t.getPhone_no());
        poloco.     setText("Preffered Location:\t\t"   + t.getPref_loc());
        Name.       setText("Name:\t\t\t\t"             + t.getName());
        Status.     setText("Status:\t\t\t\t"           + t.getStatus());
        Qualoco.    setText("Qualification:\t\t\t"      + t.getQual());
        Expoco.     setText("Experience\t\t\t"          + t.getXp());
        Bio.        setText("Bio:\t\t\t\t\t"            + "N/A");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Close.getScene().getWindow();
                stage.close();
            }
        });
    }
}
