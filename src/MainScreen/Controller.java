package MainScreen;
import com.jfoenix.controls.JFXButton;
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
    
    public JFXButton main_tut, main_stud, add_new;
    public JFXButton closebt, minbt;
    
    ArrayList<Tutor> Tuts = new ArrayList<>();
    ArrayList<Student> Studs = new ArrayList<>();
    
    public Controller(){}
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        
        /*/////////////////////////////////////////////////
        Student s1 = new Student(0,"musadanna",13,"male",
               "Lasdandhi","sxube@wqemgail.com", "0123asd213",
               "1322","o",false,"nopetynasdasope","n/a");
        Studs.add(s1);
        Tutor t1 = new Tutor(0,"Bajan",123,"male",
               "lool","gow","asdji","asd","asda",
               false,"asda","asda",new boolean[3][12]);
        Tuts.add(t1);
        /////////////////////////////////////////////////////////*/
        
        
        main_tut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewExt/NewExT.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    
                    /*Injecting Data to the New Or Existing ID Window*/
                    NewExt.Controller newextcon = fxmlLoader.getController();
                    newextcon.listinjector(Tuts, Studs);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Tutor In");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
            }
        });
        
        main_stud.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewExS/NewExS.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
    
                    NewExS.Controller newextcon = fxmlLoader.getController();
                    newextcon.listinjector(Tuts, Studs);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Student In");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n" + e);
                }
            }
        });
        ;
        
        add_new.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ADDStudORTut/StudORTut.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    
                    ADDStudORTut.Controller con = fxmlLoader.getController();
                    con.listinjector(Tuts, Studs);
                    
                    Stage stage = new Stage();
                    stage.setTitle("New Entry");
                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e) {
                    System.out.println("ERROR LOADING WINDOW" + "\n");
                    e.printStackTrace();
                }
            }
        });
        
        closebt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeButtonAction();
            }
        });
        
        minbt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("\nStudents:\n\n" + Studs + "\n\n");
                System.out.println("Tutors  :\n\n" + Tuts + "\n\n");
                
            }
        });
        
    }
    
    private void closeButtonAction() {
        Stage stage = (Stage) closebt.getScene().getWindow();
        stage.close();
    }
    
    private void minButtonAction() {
        Stage stage = (Stage) closebt.getScene().getWindow();
        stage.setIconified(true);
    }
}