#project-code
//Beneficiary class
public class Beneficiary extends User {
    
 //Initial Variables
 private int noPersons;
 private RequestDonationList receivedList;
 private Requests requestList;
 
 //Constructors
 public Beneficiary(String name,String phone)
 {
  super(name, phone);
  this.noPersons = 1;
 } 
 public Beneficiary(String name,String phone,int noPersons)
 {
  super(name, phone);
  this.noPersons = noPersons; 
 }
 
 //Methods    
 public void removeRequest(int id) 
 {
  requestList.remove(requestList.get(id));
 }
 public void editRequest(Organization o, int id, double quan)
 {
  requestList.modify(o, requestList.get(id), quan, this);
 }
 public void resetRequests()
 {
  requestList.reset();
 } 
 public void reset()
 {
  receivedList.reset();
 }
 public void addRequest(Organization o, Entity entity, double quantity)
 {
  RequestDonation rd = new RequestDonation(entity, quantity);
  requestList.add(o, rd, this);
 } 
 public void commit()
 {
  requestList.commit(this);
 }
 public void showMenu(Menu menu)
 { 
  menu.beneficiaryMenu(this);
 }
  //Getters
 public Requests getRequests()
 {
  return requestList;
 }
 public int getNoPersons()
 {
  return noPersons;
 }
}
