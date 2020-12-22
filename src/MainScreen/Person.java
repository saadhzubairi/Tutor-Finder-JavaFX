package MainScreen;

import java.io.Serializable;

public class Person implements Serializable {
    int ID;
    String name;
    int age;
    String sex;
    String location;
    String email;
    String phone_no;
    String pwd;
    
    public Person() { }
    
    public Person(int ID, String name, int age, String sex, String location, String email, String phone_no, String pwd) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.location = location;
        this.email = email;
        this.phone_no = phone_no;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone_no() {
        return phone_no;
    }
    
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
    
    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + ", sex='" + sex + '\'' + '}';
    }
}
