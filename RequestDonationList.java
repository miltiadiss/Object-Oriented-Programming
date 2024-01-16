#project-code
//RequestDonationList class
import java.util.ArrayList;

public class RequestDonationList {
    
 //Initial Variables
 private ArrayList<RequestDonation> rdEntities;
 
 //Constructors
 public RequestDonationList()
 {
  rdEntities = new ArrayList<RequestDonation>();
 }
 
 //Methods
 public RequestDonation get(int id)
 {
  for(RequestDonation rd : rdEntities)
  {
   if(rd.getID() == (id)) 
    return rd;
  }
        
  return null;
  // return rdEntities.get(id)
 }
 public void add(RequestDonation rd)
 {
  for(RequestDonation req : rdEntities)
  {
   if(req.equals(rd))
   {
    modify(req, req.getQuantity() + rd.getQuantity());
    return;
   }
  }
  
  rdEntities.add(rd); //enimerosi
 }
 public void remove(RequestDonation rd)
 {
  rdEntities.remove(rd);
 }
 public void modify(RequestDonation rd, double quantity)
 {
  rdEntities.get(rd.getID()).setQuantity(quantity); 
 }
 public void monitor()
 {
  for(RequestDonation rd : rdEntities)
  {
   System.out.println(rd.toString());
  }
 }
 public void reset()
 {
  rdEntities.clear();
 }
  //Getters
 public ArrayList<RequestDonation> getrdEntities()
 {
  return rdEntities;
 }
}
