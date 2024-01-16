#project-code
//Donator class
public class Donator extends User {
    
 //Initial Variables
 private Offers offersList;
    
 //Constructors
 public Donator(String name,String phone)
 {
  super(name, phone); 
  offersList = new Offers();
 }
    
 //Methods
 public void addOffer(Entity entity, double quantity)
 {
  RequestDonation rd = new RequestDonation(entity, quantity);
  offersList.add(rd);
 }
 public void resetOffers()
 {
  offersList.reset();
 }
 public void removeOffer(int id) 
 {
  offersList.remove(offersList.get(id));
 }
 public void commit()
 {
  offersList.commit();
 }
 public void editOffer(int id, double quan)
 {
  offersList.modify(offersList.get(id), quan);
 }
 public void showMenu(Menu menu)
 {
  menu.donatorMenu(this);
 }
    
 @Override
 public String toString()
 {
  return super.toString();
 }
  //Getters
 public Offers getOffers()
 {
  return offersList;
 }
}
