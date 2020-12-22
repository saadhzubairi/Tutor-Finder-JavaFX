package MainScreen;

import java.io.Serializable;
import java.util.Arrays;

public class Tutor extends Person implements Serializable {
    String qual; /*Degree and shizzle*/
    String status; /*Currently employed or studying?*/
    boolean isHome; /*Is this a home tutor*/
    String pref_loc; /**/
    String xp; /*years of teaching*/
    boolean[][] classes = new boolean[3][12];
    
    public Tutor(){}
    
    
    public Tutor(String pwd, int ID, String name, int age, String sex, String location,
                 String email, String phone_no, String qual, String status,
                 boolean isHome, String pref_loc, String xp, boolean[][] classes)
    {
        super(ID, name, age, sex, location, email, phone_no, pwd);
        this.qual = qual;
        this.status = status;
        this.isHome = isHome;
        this.pref_loc = pref_loc;
        this.xp = xp;
        this.classes = classes;
    }
    
    public String getQual() {
        return qual;
    }
    
    public void setQual(String qual) {
        this.qual = qual;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean isHome() {
        return isHome;
    }
    
    public void setHome(boolean home) {
        isHome = home;
    }
    
    public String getPref_loc() {
        return pref_loc;
    }
    
    public void setPref_loc(String pref_loc) {
        this.pref_loc = pref_loc;
    }
    
    public String getXp() {
        return xp;
    }
    
    public void setXp(String xp) {
        this.xp = xp;
    }
    
    public boolean[][] getClasses() {
        return classes;
    }
    
    public void setClasses(boolean[][] classes) {
        this.classes = classes;
    }
    
    @Override
    public String toString() {
        String a = Arrays.toString(classes[0]);
        String b = Arrays.toString(classes[1]);
        String c = Arrays.toString(classes[2]);
        return "Tutor{" + "ID=" + ID + ", name='" + name + '\n' + a + "\n" + b + "\n" + c;
    }
}

