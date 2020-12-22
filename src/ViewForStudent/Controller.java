package ViewForStudent;

import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public JFXButton show_pf_bt;
    public JFXButton view_self_bt;
    
    public TableView tab = new TableView();
    public TableColumn<String, Tutor> name_col;
    public TableColumn<String, Tutor> email_col;
    public TableColumn<String, Tutor> phone_col;
    public TableColumn<String, Tutor> qu_col;
    public TableColumn<String, Tutor> exp_col;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    ObservableList<Tutor> tuts = FXCollections.observableArrayList();
    Student stu = new Student();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs, Student stu) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.stu = stu;
        adder(this.Tuts,this.stu,this.tuts);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        
        tab.setItems(tuts);
        name_col  .setCellValueFactory(new PropertyValueFactory<>("name"));
        email_col .setCellValueFactory(new PropertyValueFactory<>("email"));
        phone_col .setCellValueFactory(new PropertyValueFactory<>("phone_no"));
        qu_col    .setCellValueFactory(new PropertyValueFactory<>("qual"));
        exp_col   .setCellValueFactory(new PropertyValueFactory<>("xp"));
    
        view_self_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewStudent/ViewStudent.fxml"));
                    Parent root1 = fxmlLoader.load();
        
                    ViewStudent.Controller newextcon = fxmlLoader.getController();
                    newextcon.injectst(stu);
        
                    Stage stage = new Stage();
                    stage.setTitle("Student In");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
            }
        });
        
    }
    
    public static void adder(ArrayList<Tutor> Tuts,Student stu, ObservableList<Tutor> tuts){
        int[] x = stu.getClass_code();
        for (Tutor t : Tuts) {
            boolean[][] bool = t.getClasses();
            if(bool[x[0]][x[1]]){
                tuts.add(t);
            }
        }
    }
}
