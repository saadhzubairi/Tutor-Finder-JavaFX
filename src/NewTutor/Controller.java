package NewTutor;
import MainScreen.Student;
import MainScreen.Tutor;
import com.jfoenix.controls.*;
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
    
    public JFXTextField emailf,namef,phonef,expf,biof;
    public JFXComboBox<String> agec, sexc,locc,plocc,statusc,qualc;
    
    public JFXButton Add_Tut_bt;
    public JFXToggleButton isHome;
    public JFXCheckBox O12,O11,O10,O9,O8,O7,O6,O5,O4,O3,O2,O1;
    public JFXCheckBox S12,S11,S10,S9,S8,S7,S6,S5,S4,S3,S2,S1;
    public JFXCheckBox A12,A11,A10,A9,A8,A7,A6,A5,A4,A3,A2,A1;
    
    ObservableList<String> ages = FXCollections.observableArrayList("10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49");
    ObservableList<String> sexs = FXCollections.observableArrayList("Male", "Female", "Non-Binary");
    ObservableList<String> locs = FXCollections.observableArrayList("Gulshan", "Jauhar", "NIPA", "University Rd.", "Shahrah-e-Faisal", "Hill-top", "Safoora", "Korangi", "Defence", "Hijri", "Gizri", "New Town", "Tariq Road", "Gulberg", "FB. Area", "Nazimabad");
    ObservableList<String> statuses = FXCollections.observableArrayList("Student", "Unemployed", "Working", "Self-Employed");
    ObservableList<String> qualcs = FXCollections.observableArrayList("HighSchool", "College", "Undergraduate", "Graduate");
    
    boolean b = false;
    public String pwd = "1234";
    public String email;
    //boolean[][] classes = new boolean[3][12];
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public void listinjector(ArrayList Tuts, ArrayList Studs, String email, String pwd) {
        this.Tuts = Tuts;
        this.Studs = Studs;
        this.email = email;
        this.pwd = pwd;
        emailf.setText(email);
    }
    
    public void listinjector1(ArrayList<Tutor> Tuts, boolean b) {
        this.Tuts = Tuts;
        this.b = b;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        agec.setItems(ages);
        sexc.setItems(sexs);
        locc.setItems(locs);
        plocc.setItems(locs);
        statusc.setItems(statuses);
        qualc.setItems(qualcs);
        
        Add_Tut_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean[][] classes = new boolean[3][12];
                if(O1.isSelected()){ classes[0][0]= true; }
                if(O2.isSelected()){ classes[0][1]= true; }
                if(O3.isSelected()){ classes[0][2]= true; }
                if(O4.isSelected()){ classes[0][3]= true; }
                if(O5.isSelected()){ classes[0][4]= true; }
                if(O6.isSelected()){ classes[0][5]= true; }
                if(O7.isSelected()){ classes[0][6]= true; }
                if(O8.isSelected()){ classes[0][7]= true; }
                if(O9.isSelected()){ classes[0][8]= true; }
                if(O10.isSelected()){ classes[0][9]= true; }
                if(O11.isSelected()){ classes[0][10]= true; }
                if(O12.isSelected()){ classes[0][11]= true; }
    
                if(A1.isSelected()){ classes[1][0]= true; }
                if(A2.isSelected()){ classes[1][1]= true; }
                if(A3.isSelected()){ classes[1][2]= true; }
                if(A4.isSelected()){ classes[1][3]= true; }
                if(A5.isSelected()){ classes[1][4]= true; }
                if(A6.isSelected()){ classes[1][5]= true; }
                if(A7.isSelected()){ classes[1][6]= true; }
                if(A8.isSelected()){ classes[1][7]= true; }
                if(A9.isSelected()){ classes[1][8]= true; }
                if(A10.isSelected()){ classes[1][9]= true; }
                if(A11.isSelected()){ classes[1][10]= true; }
                if(A12.isSelected()){ classes[1][11]= true; }
    
                if(S1.isSelected()){ classes [2][0]= true; }
                if(S2.isSelected()){ classes [2][1]= true; }
                if(S3.isSelected()){ classes [2][2]= true; }
                if(S4.isSelected()){ classes [2][3]= true; }
                if(S5.isSelected()){ classes [2][4]= true; }
                if(S6.isSelected()){ classes [2][5]= true; }
                if(S7.isSelected()){ classes [2][6]= true; }
                if(S8.isSelected()){ classes [2][7]= true; }
                if(S9.isSelected()){ classes [2][8]= true; }
                if(S10.isSelected()){ classes[2][9]= true; }
                if(S11.isSelected()){ classes[2][10]= true; }
                if(S12.isSelected()){ classes[2][11]= true; }
                
                Tutor t = new Tutor(pwd,0,
                       namef.getText(),
                       Integer.parseInt(agec.getValue().toString()),
                       sexc.    getValue().toString(),
                       locc.    getValue().toString(),
                       emailf.  getText(),
                       phonef.  getText(),
                       qualc.   getValue().toString(),
                       statusc. getValue().toString(),
                       isHome.  isFocused(),
                       plocc.   getValue().toString(),
                       expf.    getText(),classes);
    
                Tuts.add(t);
    
                if(!b){
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewForTutor/ViewForTutor.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
        
                        /*Injecting Data to the New Or Existing ID Window*/
                        ViewForTutor.Controller con = fxmlLoader.getController();
                        con.listinjector(Tuts, Studs,t);
        
                        Stage stage = new Stage();
                        stage.setTitle("Add Tutor");
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                    catch (Exception e){
                        System.out.println("ERROR LOADING WINDOW");
                        e.printStackTrace();
        
                    }
                }
                
                closeButtonAction();
                System.out.println("Tutor Added\n" + t);
                
            }
        });
    }
    
    private void closeButtonAction() {
        Stage stage = (Stage) Add_Tut_bt.getScene().getWindow();
        stage.close();
    }
}
