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
    
    String[][] map = {
           
           { "Gulshan", "Jauhar", "NIPA", "University Rd." },
           { "Shahrah-e-Faisal", "Hill-top", "Safoora", "Korangi" },
           { "Defence", "Hijri", "Gizri", "New Town" },
           { "Tariq Road", "Gulberg", "FB. Area", "Nazimabad" }
        
    };
    String[] prefloc = new String[0];
    
    public void listinjector(ArrayList Tuts, ArrayList Studs, Student stu) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.stu = stu;
        adder(this.Tuts,this.stu,this.tuts,this.prefloc);
        String[] prefloc = (changer(map, stu.getLocation()));
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
        
        show_pf_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Tutor ttt = (Tutor) tab.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewTutor/ViewTutor.fxml"));
                    Parent root1 = fxmlLoader.load();
        
                    ViewTutor.Controller newextcon = fxmlLoader.getController();
                    newextcon.injectt(ttt);
        
                    Stage stage = new Stage();
                    stage.setTitle("Tutor Profile");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
            }
        });
        
    }
    
    public static void adder(ArrayList<Tutor> Tuts,Student stu, ObservableList<Tutor> tuts, String[] prefloc){
        int[] x = stu.getClass_code();
        for (Tutor t : Tuts) {
            boolean[][] bool = t.getClasses();
            if(bool[x[0]][x[1]]){
                for (int i = 0; i < prefloc.length; i++) {
                    if(prefloc[i].equals(t.getLocation()))
                    tuts.add(t);
                    break;
                }
            }
        }
    }
    public static String[] changer(String[][] x, String in) {
        String[] out = new String[0];
        
        int size = x.length - 1;
        int I = 0;
        int J = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (in.equals(x[i][j])) {
                    I = i;
                    J = j;
                    break;
                }
            }
        }
        
        /*Corner Case*/
        if (I == 0 && J == 0) {
            out = new String[]{ in, x[I + 1][J], x[I][J + 1], x[I + 1][J + 1] };
            return out;
        }
        
        else if (I == size && J == 0) {
            out = new String[]{ x[I][J], x[I - 1][J], x[I][J + 1], x[I - 1][J + 1] };
            return out;
        }
        
        else if (I == 0 && J == size) {
            out = new String[]{ x[I][J], x[I + 1][J], x[I + 1][J - 1], x[I][J - 1] };
            return out;
        }
        
        else if (I == size && J == size) {
            out = new String[]{ x[I][J], x[I - 1][J], x[I][J - 1], x[I - 1][J - 1] };
            return out;
        }
        
        if (I == 0) {
            out = new String[]{ x[I][J], x[I + 1][J + 1], x[I + 1][J - 1], x[I + 1][J], x[I][J + 1], x[I][J - 1] };
            return out;
        }
        if (J == 0) {
            out = new String[]{ x[I][J], x[I + 1][J], x[I - 1][J], x[I][J + 1], x[I - 1][J + 1], x[I + 1][J + 1] };
            return out;
        }
        if (I == size) {
            out = new String[]{ x[I][J], x[I][J - 1], x[I][J + 1], x[I - 1][J], x[I - 1][J - 1], x[I - 1][J + 1], };
            return out;
        }
        if (J == size) {
            out = new String[]{ x[I][J], x[I + 1][J], x[I - 1][J], x[I][J - 1], x[I + 1][J - 1], x[I - 1][J - 1], };
            return out;
        }
        
        else{
            out = out = new String[]{ x[I-1][J-1],    x[I-1][J],    x[I-1][J+1],
                   x[I]  [J-1],    x[I]  [J],    x[I]  [J+1],
                   x[I+1][J-1],    x[I+1][J],    x[I+1][J+1], };
        }
        
        return out;
    }
}
