#project-code
//Offers class
public class Offers extends RequestDonationList { 

 //Constructors
 public Offers()
 {
  super();
 }
 
 //Methods
 void commit()
 {
  for(RequestDonation rd : getrdEntities())
  { 
   System.out.println("Successfully handled " + rd.toString());
   getrdEntities().remove(rd); 
  }
 }   
}
