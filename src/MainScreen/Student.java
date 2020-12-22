package MainScreen;

import java.io.Serializable;
import java.util.Arrays;

public class Student extends Person implements Serializable {
    String classs;
    String board;
    boolean isHome;/*does he require tutor to come to his home*/
    String lastResult;
    String spec_req;
    int[] class_code = new int[2];

    public Student(String pwd,int ID, String name, int age, String sex, String location, String email,
                   String phone_no, String classs, String board, boolean isHome,
                   String lastResult, String spec_req)
    {
        super(ID, name, age, sex, location, email, phone_no, pwd);
        this.classs = classs;
        this.board = board;
        this.isHome = isHome;
        this.lastResult = lastResult;
        this.spec_req = spec_req;
        meth(classs,board);
    }
    
    public Student() {
    
    }
    
    public void meth(String classs, String board){
        int i = 0;
        int j = 0;
        
        if(board.equals("O/A-Level")){
            i = 0;
        }
        else if(board.equals("Sindh Board")){
            i = 1;
        }
        else if (board.equals("Agha Khan Board")){
            i = 2;
        }
    
        j = Integer.parseInt(classs)-1;
        
        this.class_code[0] = i;
        this.class_code[1] = j;
    }
    
    public int[] getClass_code() {
        return class_code;
    }
    
    public void setClass_code(int[] class_code) {
        this.class_code = class_code;
    }
    
    public String getClasss() {
        return classs;
    }
    public void setClasss(String classs) {
        this.classs = classs;
    }
    public String getBoard() {
        return board;
    }
    public void setBoard(String board) {
        this.board = board;
    }
    public boolean isHome() {
        return isHome;
    }
    public void setHome(boolean home) {
        isHome = home;
    }
    public String getLastResult() {
        return lastResult;
    }
    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }
    public String getSpec_req() {
        return spec_req;
    }
    public void setSpec_req(String spec_req) {
        this.spec_req = spec_req;
    }
    
    @Override
    public String toString() {
        return "Student{" + "classs='" + classs + '\'' + ", board='" + board + '\''  + '\'' + '\'' + ", class_code=" + Arrays.toString(class_code) + '}';
    }
}
