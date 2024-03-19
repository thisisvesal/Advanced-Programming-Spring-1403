package UserPackage;
import TaskPackage.*;
import java.util.Scanner;
public class User {
    private String username;
    private String password;
    public String  first_name;
    public String last_name;
    public String email;
    public int streak;
    public Task newTask;

    public void setUsername(String username){
            this.username=username;
        }
    public void setPassword(String Password){this.password=Password; }
    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}

    public User(String username,  String password,String  first_name,String last_name, String email){
        setUsername(username);
        setPassword(password);
        this.first_name= first_name;
        this.last_name=last_name;
        this.email=email;
    }

   public String getFullName(){
        return  first_name + ' ' + last_name;
   }
   public Task createTask(){
        Scanner scaner=new Scanner(System.in);
        newTask =new Task(scaner.next());
        return newTask;
   }
}
