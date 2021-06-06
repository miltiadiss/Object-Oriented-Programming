#project-code
//Entity class
public class Entity {
 
 //Initial Variables
 private static int count = 0;
 private String name, description;
 private int id;
    
 //Constructors
 public Entity(String name, String description)
 {
  this.name = name;
  this.description = description;
  id = count++;
 }
    
 //Methods
 public String getEntityInfo()
 {
  return name+ "("+ id + ") " + description;
 }
 public String getDetails()
 {
  return "";
 }

 @Override
 public String toString() {
  return getEntityInfo() + " - " + getDetails();
 } 
  //Getters
 public int getID()
 {
  return id;
 }   
}
