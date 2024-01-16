#project-code
//Menu class
import java.util.Scanner;

public class Menu {

 //Initial Variables
 private Organization org;
    
 //Constructors
 public Menu(Organization org)
 {
  this.org = org;
  initMenu();
 }
 
 //Methods
 String scanForPhone()
 { 
  System.out.print("Type your phone number: ");
        
  Scanner in = new Scanner ( System.in );
  String phone = in.nextLine();
        
  return phone;
 }
 String scanForName()
 {
  System.out.print("Type your name: ");
        
  Scanner in = new Scanner ( System.in );
  String name= in.nextLine();
        
  return name;
 }
 User completeRegister(Organization org, String name, String phone)
 {
  System.out.print("Choose your role, 1-Donator 2-Beneficiary: ");
        
  Scanner in = new Scanner ( System.in );
  int selection = in.nextInt();
        
  switch (selection)
  {
   case 1: 
    Donator u = new Donator(name, phone);
    org.insertDonator((Donator) u);
    return u;
   case 2:
    Beneficiary b = new Beneficiary(name, phone);
    org.insertBeneficiary((Beneficiary) b);
    return b;
   default: 
    System.out.println("Error choosing role, retrying.");
    return completeRegister(org, name, phone); 
  }
 }
 public void greet(User u, String role)
 {
  System.out.println("Welcome " + u.getName() + ", you are a(n) " + role);
 }
 private int scanNum()
 { 
  int selection;
  Scanner in = new Scanner ( System.in );
  selection = in.nextInt(); 
  return selection;
 }
 private int getMenuOption(int max)
 {
  int selection;
  Scanner in = new Scanner ( System.in );
  selection = in.nextInt(); 
  if(selection > max || selection < 1) 
  {
   System.out.println("You have to give an option from 1 to " + max + "!");
   return getMenuOption(max);
  }
  return selection;
 }
    
  //Admin menu
 public void adminViewMenu(Admin a)
 {
  System.out.println("View\n\t1-Material\n\t2-Services\n\t3-Back\n");
  int selection = getMenuOption(3);
  switch(selection)
  {
   case 1:
    org.printListedMaterials(); 
    System.out.println("View\n\tType -1 to go back, or type the ID of a specific material\n");
    int mid = scanNum();
    if(mid == -1) adminViewMenu(a);
     System.out.println(org.getEntity(mid).toString());
     break;
   case 2:
    org.printListedServices();
    System.out.println("View\n\tType -1 to go back, or type the ID of a specific service\n");
    int sid = scanNum(); 
    if(sid == -1) adminViewMenu(a);
     System.out.println(org.getEntity(sid).toString());
     break;
   case 3: 
    adminMenu(a);
    break; 
  }
        
  adminViewMenu(a);
 }
 public void adminMonitorMenu(Admin a)
 {   
  System.out.println("Monitor Organization:\n\t1-List Beneficiaries\n\t2-List Donators\n\t3-Reset Beneficiaries Lists\n\t4-Back\n");
  int selection = getMenuOption(4);
  switch(selection)
  {
   case 1:
    System.out.println("Listing Beneficiaries");
    org.listBeneficiaries();
    System.out.println("View\n\tType -1 to go back, or type the phone number of a beneficiary to delete him.\n");
    Integer bid = scanNum(); 
    if(bid == -1) adminMonitorMenu(a);
     org.removeBeneficiary(bid.toString());
     break;
   case 2:
    System.out.println("Listing Donators");
    org.listDonators();
    System.out.println("View\n\tType -1 to go back, or type the phone number of a donator to delete him.\n");
    Integer sid = scanNum(); 
    if(sid == -1) adminMonitorMenu(a);
     org.removeDonator(sid.toString());
     break;
   case 3:
    org.resetBeneficiariesLists();
    break;
   case 4: 
    adminMenu(a);
    break;
  }
        
  adminMonitorMenu(a);
 }
 public void adminMenu(Admin a)
 {
  greet(a, "admin"); 
  System.out.println("1-View\n2-Monitor Organization\n3-Back\n4-Logout\n5-Exit\n");
  int selection = getMenuOption(5);
  switch(selection)
  {
   case 1:
    adminViewMenu(a);
    break;
   case 2:
    adminMonitorMenu(a);
    break;
   case 3:
    adminMenu(a);
    break;
   case 4:
   initMenu();
    break;
   case 5:
    System.exit(0);
    break;
  }
        
  adminMenu(a);
 } 
    
 public void beneficiaryRequest(Beneficiary b, String s)
 {
  System.out.println("View\n\tType -1 to go back, or type the "+ s +" ID you want to see.\n");
  Integer bid = scanNum(); 
  Material toOffer = (Material) org.getEntity(bid);
  if(bid == -1) beneficiaryAddRequest(b);
   System.out.println("Do you want to request " + toOffer.getEntityInfo() + "? 1-yes/2-no(Back)");

  int sel = getMenuOption(2);
  if(sel == 1)
  {
   System.out.println("What quantity do you need? (number, type -1 to cancel): ");
   int quan = scanNum();
   if(quan == -1) beneficiaryAddRequest(b);
    b.addRequest(org, toOffer, quan);
  } else beneficiaryAddRequest(b);
 }
 public void beneficiaryAddRequest(Beneficiary b)
 {
  System.out.println("Add Request\n\t1-Material\n\t2-Services\n\t3-Back");
  int selection = getMenuOption(3);
  switch(selection){
   case 1:
    org.printListedMaterials(); 
    beneficiaryRequest(b, "material"); 
    break;
   case 2:
    org.printListedServices(); 
    beneficiaryRequest(b, "service");
    break;
   case 3: 
    beneficiaryMenu(b);
    break; 
  }
        
  beneficiaryAddRequest(b);
 }
 public void beneficiaryShowRequests(Beneficiary b)
 {
  //Xeirismos twn ekseresewn ths modify
  b.getRequests().monitor();
  System.out.println("View\n\tType -1 to go back, Type -2 to remove all offers, Type -3 to commit, or type the offer ID you want to see.\n");
  Integer oid = scanNum(); 
  if(oid == -1) beneficiaryMenu(b);
  if(oid == -2) {
   b.resetRequests();
   beneficiaryMenu(b);
  }
        
  System.out.println("View " + oid + " id\n\t1-Delete Offer, 2-Edit Offer Quantity, 3-Back\n");
  int selc = scanNum();
  if(selc == 3) beneficiaryMenu(b);
  else if(selc == 2) {
   System.out.println("\"View \" + oid + \" id -> Edit Quantity (-1 to go back): ");
   int quan = scanNum();
    if(quan == -1) beneficiaryMenu(b);
    else {
     b.editRequest(org, oid, quan);
    }
  } else if(selc == 1)
   {
     b.removeRequest(oid);
   }
 }
 public void beneficiaryCommit(Beneficiary b)
 {
  //Xeirismos ekserseseon wste na typwthoun katallila diagnwstika minimata kai na enimerothei o
  //xristis poia aithmata tou exoun ikanopoihthei epitixws kai poia den pliroun tis proypotheseis
  b.commit();
 } 
  //Beneficiary menu
 public void beneficiaryMenu(Beneficiary b)
 {
  greet(b, "beneficiary"); 
  System.out.println("1-Add Request\n2-Show Requests\n3-Commit\n4-Back\n5-Logout\n6-Exit\n");
  int selection = getMenuOption(6);
  switch(selection)
  {
   case 1:
    beneficiaryAddRequest(b);
    break;
   case 2:
    beneficiaryShowRequests(b);
    break;
   case 3:
    beneficiaryCommit(b);
    break;
   case 4:
    beneficiaryMenu(b);
    break;
   case 5:
    initMenu();
    break;
   case 6:
    System.exit(0);
    break;
  }
        
  beneficiaryMenu(b);      
 }
 public void donatorAddOffer(Donator d)
 {
  System.out.println("Add Offer\n\t1-Material\n\t2-Services\n\t3-Back");
  int selection = getMenuOption(3);
  switch(selection){
   case 1:
    org.printListedMaterials();
    System.out.println("View\n\tType -1 to go back, or type the material ID you want to see.\n");
    Integer bid = scanNum(); 
    Entity toOffer = org.getEntity(bid);
    if(bid == -1) donatorAddOffer(d);
     System.out.println("Do you want to offer " + toOffer.getEntityInfo() + "? 1-yes/2-no(Back)");
                
    int sel = getMenuOption(2);
    if(sel == 1)
    {
     System.out.println("What quantity do you want to offer? (number, type -1 to cancel): ");
     int quan = scanNum();
     if(quan == -1) donatorAddOffer(d);
      d.addOffer(toOffer, quan);
    } else donatorAddOffer(d);
                
    break;
   case 2:
    org.printListedServices();
    break;
    case 3: 
    donatorMenu(d);
    break; 
  }
       
  donatorAddOffer(d);
 }
 public void donatorShowOffers(Donator d)
 {
  d.getOffers().monitor();
  System.out.println("View\n\tType -1 to go back, Type -2 to remove all offers, Type -3 to commit, or type the offer ID you want to see.\n");
  Integer oid = scanNum(); 
  if(oid == -1) donatorMenu(d);
  if(oid == -2) {
   d.resetOffers();
   donatorMenu(d);
  }
        
  System.out.println("View " + oid + " id\n\t1-Delete Offer, 2-Edit Offer Quantity, 3-Back\n");
  int selc = scanNum();
  if(selc == 3) donatorMenu(d);
  else if(selc == 2) {
   System.out.println("\"View \" + oid + \" id -> Edit Quantity (-1 to go back): ");
   int quan = scanNum();
   if(quan == -1) donatorMenu(d);
   else {
    d.editOffer(oid, quan);
   }
  } else if(selc == 1)
    {
     d.removeOffer(oid);
    }    
 }
 public void donatorCommit(Donator d)
 {
  d.commit();
 }
  //Donator menu
 public void donatorMenu(Donator d)
 {
  greet(d, "donator");
  System.out.println("1-Add Offer\n2-Show Offers\n3-Commit\n4-Back\n5-Logout\n6-Exit\n");
  int selection = getMenuOption(6);
  switch(selection)
  {
   case 1:
    donatorAddOffer(d);
    break;
   case 2:
    donatorShowOffers(d);
    break;
   case 3:
    donatorCommit(d);
    break;
   case 4:
    donatorMenu(d);
    break;
   case 5:
    initMenu();
    break;
   case 6:
    System.exit(0);
    break;
  }
        
  donatorMenu(d);        
 }
 public void initMenu()
 {
  System.out.println("Welcome to the menu\n");
  String phone = scanForPhone(); 
  User user = org.findUser(phone);
        
  //Register in case of not found user.
  if(user == null)
  { 
   System.out.println("Phone not found, please register.");
   String name = scanForName();
   user = completeRegister(org, name, phone);
  }
        
  user.showMenu(this);
 }
}
