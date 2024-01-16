#project-code
//Material class
public class Material extends Entity {

 //Initial Variabes
 private double level1, level2, level3;
    
 //Constructors
 public Material(String name, String description, double level1, double level2, double level3)
 {
  super(name, description);
  this.level1 = level1;
  this.level2 = level2;
  this.level3 = level3; 
 }
 
 //Methods
 public String getDetails()
 {
  return "Material (1: " + level1 + ", 2: " + level2 + ", 3: " + level3 + ")";
 }
  //Getters
 public double getLevel1()
 {
  return level1;
 } 
 public double getLevel2()
 {
  return level2;
 }
 public double getLevel3()
 {
  return level3;
 }
}
