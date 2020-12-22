package NewStudent;
import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    public JFXTextField emailf,namef,phonef,las_res_f, sqf;
    public JFXComboBox agec,sexc,locc,boardc,classc;
    public JFXButton Add_Stud_bt;
    String pwd = "1234";
    boolean b;
    
    ObservableList<String> ages = FXCollections.observableArrayList("10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49");
    ObservableList<String> sexes = FXCollections.observableArrayList("Male", "Female", "Non-Binary");
    ObservableList<String> locs = FXCollections.observableArrayList("Gulshan", "Jauhar", "NIPA", "University Rd.", "Shahrah-e-Faisal", "Hill-top", "Safoora", "Korangi", "Defence", "Hijri", "Gizri", "New Town", "Tariq Road", "Gulberg", "FB. Area", "Nazimabad");
    ObservableList<String> boards = FXCollections.observableArrayList("O/A-Level","Sindh Board","Agha Khan Board");
    ObservableList<String> classes = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs,String pwd) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.pwd = pwd;
    }
    
    public Controller() { }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        agec.   setItems(ages);
        sexc.   setItems(sexes);
        locc.   setItems(locs);
        boardc. setItems(boards);
        classc. setItems(classes);
        Add_Stud_bt.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                Student st = new Student(pwd,
                       0,
                       namef.getText(),
                       Integer.parseInt(agec.getValue().toString()),
                       sexc.getValue().toString(),
                       locc.getValue().toString(),
                       emailf.getText(),
                       phonef.getText(),
                       classc.getValue().toString(),
                       boardc.getValue().toString(),
                       false,
                       las_res_f.getText(),
                       sqf.getText());
                Studs.add(st);
                
                if(!b){
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewForStudent/ViewForStudent.fxml"));
                        Parent root1 = fxmlLoader.load();
        
                        ViewForStudent.Controller con = fxmlLoader.getController();
                        con.listinjector(Tuts, Studs,st);
        
                        Stage stage = new Stage();
                        stage.setTitle("Tutors Near You!");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }catch (Exception e) {
                        System.out.println("ERROR LOADING WINDOW" + "\n");
                        e.printStackTrace();
                    }
                }
                System.out.println("Student Added!\n");
                closeButtonAction();
            }
        });
    }
    
    public void listinjector(ArrayList Tuts, ArrayList Studs,boolean b) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.b = b;
    }
        
        private void closeButtonAction() {
        Stage stage = (Stage) Add_Stud_bt.getScene().getWindow();
        stage.close();
    }
}
