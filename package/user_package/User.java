
package user_package;
import admin_package.cardetails;
import admin_package.category;
import admin_package.pickuplocation;

//import admin_package.Admin;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter; 
public class  User 
{
    //User user_object;
    public int penalty=1000;
    public String droplocation;
    public int no_of_cars=0;
    public static ArrayList<category> category_detail=new ArrayList<category>();
    public static ArrayList<User> ap_user_detail=new ArrayList<User>();
    public  static ArrayList<cardetails> car_details=new ArrayList<cardetails>();
    public static ArrayList<rent_cardetails> rentcardetails=new ArrayList<rent_cardetails>(); 
    // public static  ArrayList<appUser> ap_user_detail=new ArrayList<appUser>();
    //static String f_name;
    public  String approved_by_admin;
    public String f_name;
    //static int passw;
    public int passw;
    public int user_count=0;
    int ch_in_up;
    Scanner scanner_obj=new Scanner(System.in);
     
   
     // String  name;
     // int pass;
     // int count;
    public User(){

    }
    public User(String name,int pass,int count,String approved_by_admin)
    {
      this.f_name=name;
      this.passw=pass;
      this.user_count=count;
      this.approved_by_admin=approved_by_admin;
    }   
    public String getName()
    {
      return f_name;
    } 
    public int getPassword()
    {
      return passw;
    }
    public int getCount(){
      return user_count;
  }
    public String toString()
    {
      return user_count+".The User name  ::  "+f_name+"  The password  ::  "+passw+"approved or not approved:  "+approved_by_admin;
    }
public void in_or_up()
{
  do
  {
    System.out.println("1.signup");
    System.out.println("2.signin");
    System.out.println("3.exit");
    System.out.println("enter your choice :");
    ch_in_up=scanner_obj.nextInt();
    switch(ch_in_up)
    {
     case 1: signup();break;
     case 2: signin(f_name,passw);break;
     case 3: return;
    }
  }while(ch_in_up<=3);
}
public void signup()
{
  user_count++;
  System.out.println(".....SIGN UP.....");
  System.out.println("enter the name:");
  f_name=scanner_obj.next();
  System.out.println("Enter the password:");
  passw=scanner_obj.nextInt();
  ap_user_detail.add(new User(f_name,passw,user_count,approved_by_admin));
  System.out.println(ap_user_detail);
  signin(f_name,passw);
}          
public void signin(String fname,int passw)
{
  System.out.println(".....SIGN IN.....");
  System.out.println("enter the name:");
  String first_name=scanner_obj.next();
  System.out.println("Enter the password:");
  int pass_word=scanner_obj.nextInt();  
   Iterator<User> iterator_object=ap_user_detail.iterator();
   while(iterator_object.hasNext())
   {
      User user_object=iterator_object.next();
      String username=getName();
      int  password=getPassword();
      if((username.compareTo(first_name)==0) && password==pass_word)
      {
           
           step_meth2_1();
           break;
      }
      else
      {
        System.out.println(" Sorry you are not sign up .so first do sign up!!!");
        signup();
      }
   }
}      
public void step_meth2_1()
{
  int choose;
  do{
     System.out.println(".......USER.......");
     System.out.println("1. Browse cars");
     System.out.println("2.Request to admin to allow rent the car");
     System.out.println("3. logout");        
     System.out.println("enter your choice:");
     choose=scanner_obj.nextInt();
     switch(choose)
     {
        case 1: Browsecar(); break;
        case 2: 
                System.out.println("Request to admin to allow rent the car");
                break;
        case 3:  return;  
     }
    }while(choose<=3);
}
public void step_meth2_2()
{
  int ch;
  do
  {
    System.out.println(".......USER.......");
    System.out.println("1. Browse cars");
    System.out.println("2. Rent ");
    System.out.println("3. Pay rent");
    System.out.println("4. logout");        
    System.out.println("enter your choice:");
    ch=scanner_obj.nextInt();
    switch(ch)
    {
      case 1: Browsecar();
              break;
      case 2: rent(); 
              break;
      case 3: payRent();
              break;
      case 4:  return;     
    }
  }while(ch<=4);
}
boolean browsingdetailsfound=false;
public String browse_pickuplocation;
void Browsecar(){
   
    System.out.println("Enter your pickup location:");//browsing the car under by pickuplocation
     browse_pickuplocation=scanner_obj.next();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    System.out.println("Enter your starting date:");//browsing the car under by start date
    String browse_startdate=scanner_obj.next();
    LocalDate startdate=LocalDate.parse(browse_startdate,formatter);
    System.out.println(startdate);
    System.out.println("Enter your ending date:");//browsing the car under by end date
    String browse_enddate=scanner_obj.next();
    LocalDate enddate=LocalDate.parse(browse_enddate,formatter);
    Iterator<cardetails> iterator_obj=car_details.iterator();
    while(iterator_obj.hasNext())
    {
         cardetails browsecar=iterator_obj.next();
         String pickuplocation=browsecar.getPickuplocation();
         LocalDate Available_date=browsecar.getAvailabledate();
         if(pickuplocation.equals(browse_pickuplocation) || ((Available_date.isAfter(startdate)|| Available_date.isEqual(startdate))&&(Available_date.isBefore(enddate)|| Available_date.isEqual(enddate)))){
              System.out.println(browsecar);
              browsingdetailsfound=true;       
         }
        
    }
    if(!browsingdetailsfound)
    {
       System.out.println("not found");
    }
  }
void rent()
{
        Browsecar();
        if(browsingdetailsfound)
        { 
        int find_the_car_position=0;
        int car_position=0;
        System.out.println("do you want to rent the car?");
        System.out.println("If yes enter the car model:");
        String browse_carmodel=scanner_obj.next();
       // int car_indexposition=car_details.indexOf(browse_carmodel);
        Iterator<cardetails> iterator_object=car_details.iterator();
        while(iterator_object.hasNext())
        {
            car_position++;
            cardetails object=iterator_object.next();
            if(browse_carmodel.equals(object.getCarmodel()))
            {
                 find_the_car_position+=car_position;
            }
        }
        find_the_car_position-=1;
        System.out.println(find_the_car_position);
        

        System.out.println("if you rent that  car model yes--->1  no--->2");
        int rent_the_car=scanner_obj.nextInt();
        if(rent_the_car==1)
        {
            
             String rent_status="non-available";
             System.out.println("enter your name: ");
             String name=scanner_obj.next();
             System.out.println("enter your drop location: ");
             droplocation=scanner_obj.next(); 
             LocalDate rentdate=car_details.get(find_the_car_position).getAvailabledate();
             System.out.println(rentdate);
            String formattedDate =rentdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             System.out.println(formattedDate);                                                                                                                                      
             LocalDate rentstartingdate=LocalDate.parse(formattedDate);
            System.out.println("How many days do you want to rent the car? ");
            int no_of_rented_days=scanner_obj.nextInt();
            LocalDate returndate=rentstartingdate.plusDays(no_of_rented_days);
            System.out.println("return date is: "+returndate);
             car_details.set(find_the_car_position,new cardetails(car_details.get(find_the_car_position).getCarnumber(),car_details.get(find_the_car_position).getCategory(),car_details.get(find_the_car_position).getCarmodel(), car_details.get(find_the_car_position).getaveragemileage(),car_details.get(find_the_car_position).getManufacturedate(),car_details.get(find_the_car_position).getAvailabledate(),car_details.get(find_the_car_position).getDate(),car_details.get(find_the_car_position).getMonth(),car_details.get(find_the_car_position).getYear(),car_details.get(find_the_car_position).getPickuplocation(),droplocation,rent_status));       
            System.out.println(car_details);
            rentcardetails.add(new rent_cardetails(name,car_details.get(find_the_car_position).getCategory(),car_details.get(find_the_car_position).getCarmodel(), car_details.get(find_the_car_position).getaveragemileage(),car_details.get(find_the_car_position).getManufacturedate(),car_details.get(find_the_car_position).getAvailabledate(),car_details.get(find_the_car_position).getDate(),car_details.get(find_the_car_position).getMonth(),car_details.get(find_the_car_position).getYear(),car_details.get(find_the_car_position).getPickuplocation(),droplocation,rent_status,no_of_rented_days,returndate));
        }
        else
        {
           String rent_status="available";
           droplocation="null"; 
           car_details.set(find_the_car_position,new cardetails(no_of_cars,car_details.get(find_the_car_position).getCategory(),car_details.get(find_the_car_position).getCarmodel(), car_details.get(find_the_car_position).getaveragemileage(),car_details.get(find_the_car_position).getManufacturedate(),car_details.get(find_the_car_position).getAvailabledate(),car_details.get(find_the_car_position).getDate(),car_details.get(find_the_car_position).getMonth(),car_details.get(find_the_car_position).getYear(),car_details.get(find_the_car_position).getPickuplocation(),droplocation,rent_status));
           System.out.println(car_details);
        }
      }            
}

void payRent()
{
       int user_position=0;
       int found_the_user_position=0;
       System.out.println("enter your name");
       String Renter_name=scanner_obj.next();
       Iterator<rent_cardetails> iterator_object=rentcardetails.iterator();
       while(iterator_object.hasNext()){
           user_position++;
           rent_cardetails rent=iterator_object.next();
           if(Renter_name.equals(rent.getRentername())){
                      found_the_user_position+=user_position;
           }
       }
       found_the_user_position-=1;
       System.out.println(found_the_user_position);
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    System.out.println("Enter the current date:");//browsing the car under by start date
    String currentdate=scanner_obj.next();
    LocalDate currentLocalDate=LocalDate.parse(currentdate,formatter);
    System.out.println(currentLocalDate);       
    int category_rent=0;
    int found_the_category_rent=0;
    String carcategory=rentcardetails.get(found_the_user_position).getCarcategory().toString();
              Iterator<category> iterat_object=category_detail.iterator();
              while(iterat_object.hasNext()){
                  category_rent++;
                  category object=iterat_object.next();
                  if(carcategory.equals(object.getcatName())){
                       found_the_category_rent+=category_rent;
                  }
              }
             found_the_category_rent-=1;
                
           int rentofcategory=category_detail.get(found_the_category_rent).getRent();
           int rented_days=rentcardetails.get(found_the_user_position).getNumberofrentdays(); 
           int how_much_rent;
           int difference;
           LocalDate returnDate=rentcardetails.get(found_the_user_position).getReturndate();
                     int return_date=returnDate.getDayOfMonth();
                     int current_date=currentLocalDate.getDayOfMonth();
           if(currentLocalDate.isEqual(rentcardetails.get(found_the_user_position).getReturndate()))
           {
                      how_much_rent=rented_days*rentofcategory;
                    //penalty=0;
                    System.out.println("your rented payment is :  "+how_much_rent);
                    System.out.println("your are not have a penalty...");
           }
           else if(currentLocalDate.isBefore(rentcardetails.get(found_the_user_position).getReturndate()))
           {
                     difference=return_date-current_date;
                     int rentcalculated=rented_days-difference;
                     how_much_rent=rentcalculated*rentofcategory;
                     //penalty=0;
                     System.out.println("your rented payment is :  "+how_much_rent);
                     System.out.println("your are not have a penalty...");
           }
           else if(currentLocalDate.isAfter(rentcardetails.get(found_the_user_position).getReturndate()))
           {
                difference=current_date-return_date;
                System.out.println(difference);
                how_much_rent=rented_days*rentofcategory;
                 System.out.println(how_much_rent);     
                int penaltycalculate=difference*penalty;
                System.out.println("your rented payment is :  "+how_much_rent);
                System.out.println("your penalty amount is : "+penaltycalculate);
           }
           else{
             System.out.println();
           }
           int car_position=0;
           int find_the_car_position=0;
            System.out.println("If you hava payment now  :: ");
            System.out.println("If yes--->1   no--->2");
            int pay_payment=scanner_obj.nextInt();
            switch(pay_payment)
            {
              case 1:
                       System.out.println("enter the car model: ");
                       String browse_carmodel=scanner_obj.next();
                       // int car_indexposition=car_details.indexOf(browse_carmodel);
                        Iterator<cardetails> findthecar=car_details.iterator();
                        while(findthecar.hasNext())
                        {
                            car_position++;
                            cardetails object=findthecar.next();
                            if(browse_carmodel.equals(object.getCarmodel()))
                            {
                                 find_the_car_position+=car_position;
                            }
                        }
                        find_the_car_position-=1;
                      String rent_status="available";
                        System.out.println("Your payment successfully received..");
                       String car_pickup_location=droplocation;
                       droplocation="null";
              car_details.set(find_the_car_position,new cardetails(car_details.get(find_the_car_position).getCarnumber(),car_details.get(find_the_car_position).getCategory(),car_details.get(find_the_car_position).getCarmodel(), car_details.get(find_the_car_position).getaveragemileage(),car_details.get(find_the_car_position).getManufacturedate(),car_details.get(find_the_car_position).getAvailabledate(),car_details.get(find_the_car_position).getDate(),car_details.get(find_the_car_position).getMonth(),car_details.get(find_the_car_position).getYear(),car_pickup_location,droplocation,rent_status));    
              System.out.println(car_details);
              case 2: return;
            }


}

}

