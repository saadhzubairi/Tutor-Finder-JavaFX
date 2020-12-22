package ViewForTutor;
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
    
    public TableView tab = new TableView();
    public TableColumn<String, Student> name_col;
    public TableColumn<String, Student> age_col;
    public TableColumn<String, Student> gen_col;
    public TableColumn<String, Student> class_col;
    public TableColumn<String, Student> board_col;
    public TableColumn<String, Student> loc_col;
    public TableColumn<String, Student> email_col;
    public TableColumn<String, Student> phone_col;
    public TableColumn<String, Student> lr_col;
    public TableColumn<String, Student> sq_col;
    
    public JFXButton show_pf_bt;
    public JFXButton view_self_bt;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    ObservableList<Student> studs = FXCollections.observableArrayList();
    String[] app_locs = new String[9];
    Tutor tu = new Tutor();
    
    String[][] map = {
           
           { "Gulshan", "Jauhar", "NIPA", "University Rd." },
           { "Shahrah-e-Faisal", "Hill-top", "Safoora", "Korangi" },
           { "Defence", "Hijri", "Gizri", "New Town" },
           { "Tariq Road", "Gulberg", "FB. Area", "Nazimabad" }
        
    };
    
    String[] prefloc = new String[0];
    
    
    public void listinjector(ArrayList Tuts, ArrayList Studs, Tutor tu) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.tu = tu;
        String[] prefloc = (changer(map, tu.getLocation()));
        adder(this.tu,Studs,studs,prefloc);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        tab.setItems(studs);
        name_col.   setCellValueFactory(new PropertyValueFactory<>("name"));
        age_col.    setCellValueFactory(new PropertyValueFactory<>("age"));
        gen_col.    setCellValueFactory(new PropertyValueFactory<>("sex"));
        class_col.  setCellValueFactory(new PropertyValueFactory<>("classs"));
        board_col.  setCellValueFactory(new PropertyValueFactory<>("board"));
        loc_col.    setCellValueFactory(new PropertyValueFactory<>("location"));
        email_col.  setCellValueFactory(new PropertyValueFactory<>("email"));
        phone_col.  setCellValueFactory(new PropertyValueFactory<>("phone_no"));
        lr_col.     setCellValueFactory(new PropertyValueFactory<>("lastResult"));
        sq_col.     setCellValueFactory(new PropertyValueFactory<>("spec_req"));
        
        view_self_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewTutor/ViewTutor.fxml"));
                    Parent root1 = fxmlLoader.load();
        
                    ViewTutor.Controller newextcon = fxmlLoader.getController();
                    newextcon.injectt(tu);
        
                    Stage stage = new Stage();
                    stage.setTitle("Tutor Profile");
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
                Student stu = (Student) tab.getSelectionModel().getSelectedItem();
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
    
    public static void adder(Tutor tu, ArrayList<Student> Studs, ObservableList<Student> studs, String[] prefloc){
        boolean[][] bool = tu.getClasses();
        for (Student stu: Studs) {
            int[] code = stu.getClass_code();
            int i = code[0];
            int j = code[1];
            if(bool[i][j]){
                for (int k = 0; k < prefloc.length; k++) {
                    if(prefloc[k].equals(stu.getLocation()))
                    studs.add(stu);
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