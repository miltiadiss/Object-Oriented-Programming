#project-code
//RequestDonation class
public class RequestDonation{

 //Initial Variables
 private Entity entity;
 private double quantity;
 private int ID;
    
 public int getID()
 {
  return ID;
 }
 
 //Constructors
 public RequestDonation(Entity entity, double quantity)
 {
  this.entity = entity;
  ID = entity.getID();
  this.quantity = quantity;
 }
 
 //Methods
 public int compare(RequestDonation rd)
 {
  if(rd.getID() == getID())
   return 1;
   return 0;
 }
    
 @Override
 public String toString()
 {
  return ID + ": " + entity.toString() + " x " + quantity;
 }
  //Setters
 public void setQuantity(double quantity)
 {
  this.quantity = quantity;
 }
  //Getters
 public double getQuantity()
 {
  return quantity;
 }
 public Entity getEntity()
 {
  return entity;
 }  
}
