#project-code
//Admin class
public class Admin extends User {
 //Initial Variables
 boolean isAdmin;
 
 //Constructors
 public Admin(String name,String phone)
 {
  super(name, phone);
  isAdmin = true;
 }
    
 //Methods
 public void showMenu(Menu menu)
 {
  menu.adminMenu(this); 
 }
}
