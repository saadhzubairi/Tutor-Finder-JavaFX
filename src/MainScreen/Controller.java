package MainScreen;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
        loads();
        
        main_tut.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewExt/NewExT.fxml"));
                    Parent root1 = fxmlLoader.load();
    
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
        
        main_stud.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewExS/NewExS.fxml"));
                    Parent root1 = fxmlLoader.load();
    
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
        
        
        add_new.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ADDStudORTut/StudORTut.fxml"));
                    Parent root1 = fxmlLoader.load();
    
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
        
        closebt.setOnAction(event -> {
            write();
            closeButtonAction();
        });
        
        minbt.setOnAction(event -> {
            System.out.println("\nStudents:\n\n" + Studs + "\n\n");
            System.out.println("Tutors  :\n\n" + Tuts + "\n\n");
        });
        
    }
    
    private void closeButtonAction() {
        Stage stage = (Stage) closebt.getScene().getWindow();
        stage.close();
    }
    
    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream("Students.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Studs);
            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    
    
        try {
            FileOutputStream fos = new FileOutputStream("Tutors.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Tuts);
            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("SAVED");
    }
    
    private void loads() {
        try {
            InputStream in = Files.newInputStream(Paths.get("Students.ser"));
            ObjectInputStream ois = new ObjectInputStream(in);
            this.Studs = (ArrayList<Student>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    
        try {
            InputStream in = Files.newInputStream(Paths.get("Tutors.ser"));
            ObjectInputStream ois = new ObjectInputStream(in);
            this.Tuts = (ArrayList<Tutor>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    
        System.out.println("LOADED from Storage.");
    }
}