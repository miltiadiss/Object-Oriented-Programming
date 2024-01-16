#project-code
//Main class
public class Main {
 
 //Methods
 public static void main(String[] args) {
  Organization org = new Organization(); 
  //Add the entities requested
  org.addEntity(new Material("milk", "Your favourite dairy product!", 1, 2.5, 4), 100);  
  org.addEntity(new Material("sugar", "Don't overeat it!", 0.5, 1, 2.5), 100);
  org.addEntity(new Material("rice", "Chinese food?", 2, 5, 10), 100);
  org.addEntity(new Service("MedicalSupport", "Dentist and More Doctors"), 100);
  org.addEntity(new Service("NurserySupport", "Nursing and Care"), 100);
  org.addEntity(new Service("BabySitting", "Caring for Children"), 100);
        
  //Set an admin
  org.setAdmin(new Admin("Admin", "911"));
        
  //Add two beneficiaries, the one with more than 1 type of request
  Beneficiary guy = new Beneficiary("Guy", "100", 1);
  org.insertBeneficiary(guy);
        
  Beneficiary fella = new Beneficiary("Fella", "166", 2);
  org.insertBeneficiary(fella);
        
  //Add a donator and give him supply
  org.insertDonator(new Donator("Elon Musk", "200"));
        
  new Menu(org);
 }
}
