#project-code
//Organization class
import java.util.ArrayList;

public class Organization {
    
 //Initial Variables
 String name;
 Admin admin;
 ArrayList<Entity> entityList;
 ArrayList<Donator> donatorList;
 ArrayList<Beneficiary> beneficiaryList;
 RequestDonationList currentDonations;
 
 //Constructors
 public Organization()
 {
  entityList = new ArrayList<Entity>(); 
  donatorList = new ArrayList<Donator>();
  beneficiaryList = new ArrayList<Beneficiary>();
  currentDonations = new RequestDonationList();
 }
 
 //Methods
 boolean hasEnough(RequestDonation rd)
 {
  double quan = rd.getQuantity();
  if(currentDonations.get(rd.getID()).getQuantity() >= quan)
   return true;
  else return false;
 }
 void resetBeneficiariesLists()
 {
  for(Beneficiary b : beneficiaryList)
  {
   b.reset();
  }
 }
 void listBeneficiaries()
 {
  for(Beneficiary b : beneficiaryList)
  {
   System.out.print("\t");
   System.out.println(b.toString());
  }
 }
 void listDonators()
 {
  for(Donator d : donatorList)
  {
   System.out.print("\t");
   System.out.println(d.toString());
  }
 }
 void listEntities()
 {
  printListedServices();
  printListedMaterials();
 }
 void printListedServices()
 {
  int i = 0;
  System.out.println("Services:");
  for(Entity s : entityList)
  {
   if(s.getDetails().matches("Service"))
   {
    i += 1;
    System.out.println(i + "- " + s.toString() + " / " + currentDonations.get(s.getID()).getQuantity() + " left") ; 
   }
  }
 } 
 void printListedMaterials()
 {
  int i = 0;
  System.out.println("Materials:");
  for(Entity s : entityList)
  {
   if(!s.getDetails().matches("Service"))
   {
    i += 1;
    System.out.println(i + "- " + s.toString() + " / " + currentDonations.get(s.getID()).getQuantity() + " left") ; 
   }
  }
 }
 User findUser(String phone)
 {
  if(admin.getPhone().matches(phone))
   return admin;
  for(Donator d : donatorList)
   if(d.getPhone().matches(phone)) 
    return d;
  for(Beneficiary b : beneficiaryList)
   if(b.getPhone().matches(phone))
    return b;
        
  return null;
 } 
 void addEntity(Entity e, double q)
 {
  for(Entity en : entityList)
  { 
   if(en.getEntityInfo().matches(e.getEntityInfo()))
   {
    new ExceptionError("addEntity error: This entity already exists.");
    return;
   }
  }
  entityList.add(e);
  RequestDonation rd = new RequestDonation(e,q);
  currentDonations.add(rd);
 }
 void removeEntity(int id)
 {
  for(Entity e : entityList)
  {
   if(e.getID() == id) {
    currentDonations.remove(currentDonations.get(id));
    entityList.remove(e);
   }
  }
 }
 void insertDonator(Donator d)
 {
  donatorList.add(d);
 }
 void removeDonator(String phoneNumber)
 {
  for(Donator d : donatorList)
  {
   if(d.getPhone().matches(phoneNumber))
   {
    donatorList.remove(d);
    break;
   }
  }
 } 
 void insertBeneficiary(Beneficiary b)
 {
  beneficiaryList.add(b);
 }
 void removeBeneficiary(String phoneNumber)
 {
  for(Beneficiary b : beneficiaryList)
  {
   if(b.getPhone().matches(phoneNumber))
   {
    donatorList.remove(b);
    break;
   }
  }
 }
  //Setters
 void setAdmin(Admin a)
 {
  admin = a;
 }
  //Getters
 Admin getAdmin()
 {
  return admin;
 }
 Entity getEntity(int id)
 {
  for(Entity e : entityList)
  {
   if(e.getID() == id) 
   {
    return e;
   }
  }
        
  return null;
 }
}
