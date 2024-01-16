#project-code
//Requests class
public class Requests extends RequestDonationList {

 //Constructors
 public Requests()
 {
  super();
 }
 
 //Methods
 void add(Organization o, RequestDonation rd, Beneficiary b)
 { 
  if(!o.hasEnough(rd))
  {
   new ExceptionError("Organization doesn't have enough of this!");
   return;
  }
  if(validRequestDonation(rd, b))
   super.add(rd); //enimerosi
  else 
   new ExceptionError("You don't have a valid request!");
 }    
 public void modify(Organization o, RequestDonation rd, double quantity, Beneficiary b)
 {
  if(!o.hasEnough(rd))
  {
   new ExceptionError("Organization doesn't have enough of this!");
   return;
  }
  if(validRequestDonation(rd, b))
   super.get(rd.getID()).setQuantity(quantity); 
  else 
   new ExceptionError("You don't have a valid request!");
 }
 boolean validRequestDonation(RequestDonation rd, Beneficiary b)
 {
  Entity e = rd.getEntity();
  if(e.getDetails().matches("Service")) 
   return true; 
        
  int noPersons = b.getNoPersons();
  if(noPersons == 1)
   if(rd.getQuantity() <= ((Material) e).getLevel1())
    return true;
  else if(noPersons > 1 && noPersons < 5)
   if(rd.getQuantity() <= ((Material) e).getLevel2())
    return true;
  else if(noPersons > 5)
   if(rd.getQuantity() <= ((Material) e).getLevel3())
    return true;
  return false;
 }
 void commit(Beneficiary b)
 {
  for(RequestDonation rd : getrdEntities())
  {
   if(validRequestDonation(rd, b))
   {
    System.out.println("Successful handling of " + rd.toString());
    getrdEntities().remove(rd);
   }
  }
 }
}
