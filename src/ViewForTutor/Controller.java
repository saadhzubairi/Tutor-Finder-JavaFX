package ViewForTutor;
import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    ObservableList<Student> studs = FXCollections.observableArrayList();
    String[] app_locs = new String[9];
    Tutor tu = new Tutor();
    
    
    public void listinjector(ArrayList Tuts, ArrayList Studs, Tutor tu) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.tu = tu;
        studs.addAll(Studs);
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
    }
    
    public static void adder(Tutor tu, ArrayList<Student> Studs, ObservableList<Student> studs){
        boolean[][] bool = tu.getClasses();
        for (Student stu: Studs) {
            int[] code = stu.getClass_code();
            int i = code[0];
            int j = code[1];
            if(bool[i][j]){
                studs.add(stu);
            }
        }
    }
}