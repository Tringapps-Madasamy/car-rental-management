
package admin_package;
import user_package.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class  Admin extends User
{    
  public int result;
  static int allow;
  int category_count=0;
  Scanner scanner_object=new Scanner(System.in);
 // public static ArrayList<category> category_detail=new ArrayList<category>();
  ArrayList<pickuplocation> pickuplocation_detail=new ArrayList<pickuplocation>();
   

 
 public void login(){
  String user_name="maddy";
  int pass=123;
       System.out.println(".....LOGIN.....");
                  System.out.println("Enter the username:");
                     String name=scanner_object.next();
                       System.out.println("Enter the password:");
                  int password=scanner_object.nextInt();
                  if((user_name.compareTo(name)==0)  && pass==password)
                  {
                             
                    admin_access_part();
      
                  }
                 else{
                  System.out.println("Invalid input");
                        
                 }

          }
public void admin_access_part()
{
int choice;
do{
System.out.println(".......ADMIN.......");
System.out.println("1. Add category ");
System.out.println("2. Add pickup locations");
System.out.println("3. Add Cars (chose category)");
System.out.println(" 4. Update pickup location");
System.out.println(" 5. Delete Cars Validate the car has been returned");
System.out.println("6. Set penalty ");
System.out.println("7. Approve user");
System.out.println(" 8. Extend rental ");
System.out.println(" 9. upgrade car category");
System.out.println(" 10. Update current date, all business log");
System.out.println(" 11.logout");        
System.out.println("enter your choice:");
             choice=scanner_object.nextInt();
switch(choice)
{
  case 1:
            System.out.println();
            add_category(); 
            break;
  case 2: add_pickuplocation(); 
          break;
  case 3: add_car(); 
          break;
  case 4: updatePickuplocation();
          break;
  case 5: deletethecar();
          break;
  case 6: setPenalty();
          break;
  case 7: approve_user();  
          break;
  case 8: extend_rental_period();
          break;
  case 9: break;
  case 10: break;
   case 11:  return;
 
}           
}while(choice<=11);
}
//String add_value;

  public   void add_category(){
         /*  System.out.println(".....CATEGORY.....");
           System.out.println();
*/        System.out.println("How many category do you want to add here? ");
          int no_of_category=scanner_object.nextInt();
        
         if(no_of_category>0)
         { 
              for(int i=1;i<=no_of_category;i++)
              {     
                    category_count++;        //if you enter the category ,count is increment
                    System.out.println("Enter the category:");
                    String  category_name=scanner_object.next();
                    System.out.println("Enter the rent of the category:");
                    int rent_of_category=scanner_object.nextInt();
                    category_detail.add(new category(category_name,rent_of_category,category_count));
                    //System.out.println(add_cat_detail);
              }
               System.out.println("-------------------------------");
               Iterator<category> iterator_object=category_detail.iterator();
               while(iterator_object.hasNext())
               {
               category category_object=iterator_object.next();
              System.out.println(category_object);
          }
              System.out.println("-------------------------------");
          //System.out.println(add_cat_detail.get(0));
        }
        else{
          System.out.println("you added nothing");
        }
}

    
   public void add_pickuplocation(){

       System.out.println("How many locations do you want to added here? ");
       int no_of_pickuplocation=scanner_object.nextInt();
       if(no_of_pickuplocation>0)
       {
             for(int i=1;i<=no_of_pickuplocation;i++)
             { 
                   System.out.println("Enter the pickup location:");
                   String  pickuplocation_name=scanner_object.next();
                   pickuplocation_detail.add(new pickuplocation(pickuplocation_name));
                  // System.out.println(add_cat_detail);
             }
             System.out.println("-------------------------------");
             Iterator<pickuplocation> iterator_object=pickuplocation_detail.iterator();
              while(iterator_object.hasNext()){
                     pickuplocation pickuplocation_object=iterator_object.next();
                    System.out.println(pickuplocation_object);
              }
              System.out.println("-------------------------------");
        }
        else{
          System.out.println("you added nothing");
        } 
 }
  String rent_the_car;
  public void add_car(){
       System.out.println("*****choose category from following list*****");
       System.out.println();
       System.out.println("-------------------------------");
    Iterator<category> iterator_object=category_detail.iterator();
    while(iterator_object.hasNext()){
         category category_object=iterator_object.next();
         System.out.println(category_object);
    }
    Object category_name=" ";
    int here=1;
    System.out.println("enter the category:");
    String c_name =scanner_object.next();
    Iterator<category> add_car_ite=category_detail.iterator();
    while(add_car_ite.hasNext()){
        category add_car=add_car_ite.next();
          if(add_car.getcatName().equals(c_name)){
              category_name=add_car;
             here=0;
          }
    }
    if(here==1)
    {
       System.out.println("category not found");
    }
    if(here==0){
      no_of_cars++;
      System.out.println("enter the car model:");
      String car_model=scanner_object.next();
      System.out.println("ener the average mileage:");
      String avg_mil=scanner_object.next();
      System.out.println("enter the manufacture date:");
      String manu_date=scanner_object.next();
      user_defined_date(manu_date);
      LocalDate manufacturedate=LocalDate.of(year, month, day);
      System.out.println(manufacturedate);
      System.out.println("date is:  "+day);
      System.out.println(month);
      System.out.println("enter the availability date:");
      String avail_date=scanner_object.next();
      user_defined_date(avail_date);
      LocalDate availabledate=LocalDate.of(year, month, day);
      System.out.println(availabledate);
      System.out.println("date is:  "+day);
      System.out.println("enter the pickup location:");
      String pick_loct=scanner_object.next();
      String rent_the_car="available"; 
      car_details.add(new cardetails(no_of_cars,c_name,car_model,avg_mil,manufacturedate,availabledate,availabledate.getDayOfMonth(),month,availabledate.getYear(),pick_loct,droplocation,rent_the_car));
     // System.out.println(car_details);
      System.out.println();
      System.out.println();
      Iterator<cardetails> car_ite=car_details.iterator();

      
      while(car_ite.hasNext()){
          cardetails car_obj=car_ite.next();
         System.out.println(car_obj);
      }
     
    }

  }
public int day;
public int month;
public int year;
public String user_defined_date(String date)
{
    String date_array[]=date.split("-");
    year=Integer.parseInt(date_array[0]);
    month=Integer.parseInt(date_array[1]);
    day=Integer.parseInt(date_array[2]);
    boolean isLeap=false;
    if((year%4==0 && year%400==0))
    {
       isLeap=true;
    }   
    int no_of_days=0;
    switch(month)
    {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
            no_of_days=31;
           break;
      case 4:
      case 6:
      case 9:
           no_of_days=30;
           break;
      case 2:
           no_of_days=(isLeap)?29:28;
           break;          
    }
    if(day<=no_of_days)
    {
      //System.out.println("date is:  "+day);
      System.out.println("valid date");
    }
    else
    {
      //System.out.println("date is:  "+day);
      System.out.println("Invalid date");
    }
    return date;
}

public void updatePickuplocation(){
     Iterator<cardetails> ite_obj=car_details.iterator();
     while(ite_obj.hasNext())
     {
            cardetails  car_obj=ite_obj.next();
            System.out.println(car_obj);           
     }
     System.out.println("which car location you want to update ? ");
     int car_position=scanner_object.nextInt();
     System.out.println("enter the new pickuplocation: ");
     String pickuplocation_for_car=scanner_object.next();
     Iterator<cardetails> iterating=car_details.iterator();
     while(iterating.hasNext())
     {
            cardetails  car_obj=iterating.next();
            if(car_position==car_obj.getCarnumber()) {
              car_details.set((car_position-1),new cardetails(no_of_cars,car_details.get(car_position-1).getCategory(),car_details.get(car_position-1).getCarmodel(), car_details.get(car_position-1).getaveragemileage(),car_details.get(car_position-1).getManufacturedate(),car_details.get(car_position-1).getAvailabledate(),car_details.get(car_position-1).getDate(),car_details.get(car_position-1).getMonth(),car_details.get(car_position-1).getYear(),pickuplocation_for_car,car_details.get(car_position-1).getDroplocation(),car_details.get(car_position-1).getRentstatus()));    
 
            }        
     }
     System.out.println(car_details);
}



void deletethecar()
{
     System.out.println(" CHOOSE THE CAR FROM FOLLOWING LIST ");
     Iterator<cardetails> delete_car=car_details.iterator();
     while(delete_car.hasNext())
     {
         cardetails Deletethecar=delete_car.next();
         System.out.println(Deletethecar);
     }
     System.out.println("which car you want to delete from the list : ");
     System.out.println("          (enter car serial number)          ");
     int serialnumberofcar=scanner_object.nextInt();
     int car_serial_number=0;
     int found_the_car_position=0;
     Iterator<cardetails> serialnumberIterator=car_details.iterator();
     while(serialnumberIterator.hasNext())
     {
         car_serial_number++;
         cardetails carserialnumber=serialnumberIterator.next();
         if(serialnumberofcar==carserialnumber.getCarnumber())
         {
              found_the_car_position+=car_serial_number;
         }
     }
     found_the_car_position-=1;
     System.out.println("the car in "+found_the_car_position+"th position");
    String checkthecar_returned="available";
    if(checkthecar_returned.equals(car_details.get(found_the_car_position).getRentstatus()))
    {
      car_details.remove(found_the_car_position);
      System.out.println("Successfully deleted this car from this list ");
      Iterator<cardetails> checkthecarlist=car_details.iterator();
      while(checkthecarlist.hasNext())
      {
          cardetails car_is_deleted=checkthecarlist.next();
          System.out.println(car_is_deleted);
      }           
    }
    else
    {
         System.out.println("The car is not returned!!! so you can't delete this car...");    
    }
   
}
public void setPenalty()
{    
    
     System.out.println(penalty+"/Rs penalty for every day");
     System.out.println("Do you want to set the penalty? ");
     System.out.println("If yes-->1 no--->2");
     int if_set_penalty=scanner_object.nextInt();
     switch(if_set_penalty)
     {
          case 1:  System.out.println("enter the new penalty for every day : ");
                   penalty=scanner_object.nextInt();
                   break;
          case 2:  return;         
     }
}
public void approve_user()
{
  int cat_index;
     System.out.println("******************************************");
       Iterator<User> au=ap_user_detail.iterator();
        while(au.hasNext())
        {
            User au1=au.next();
            System.out.println(au1);
        }
        System.out.println("******************************************");  
        System.out.println("which user you want to open?");
       cat_index= scanner_object.nextInt();
        System.out.println(ap_user_detail.get(cat_index-1));
       System.out.println("Do you accept this user? if you approved type-- yes   not approved type --no");
       approved_by_admin=scanner_object.next(); 
       System.out.println(cat_index-1);
       String user_name=ap_user_detail.get(cat_index-1).getName();
       int pass_word=ap_user_detail.get(cat_index-1).getPassword();
       int user_count=ap_user_detail.get(cat_index-1).getCount(); 
       ap_user_detail.set(cat_index-1,new User(user_name,pass_word,user_count,approved_by_admin));
       if(approved_by_admin.equals("yes"))
       {
            System.out.println(cat_index+"th  user  approved to rent the car by admin");
            step_meth2_2();
       }
       else
       {
            System.out.println(cat_index+"th user not approved by admin");
            step_meth2_1();
       }
   }
   void extend_rental_period()
   {
    System.out.println(" CHOOSE THE CAR FROM FOLLOWING LIST ");
    Iterator<rent_cardetails> choose_car=rentcardetails.iterator();
    while(choose_car.hasNext())
    {
        rent_cardetails findthecar=choose_car.next();
        System.out.println(findthecar);
    }
    System.out.println("which car's rental you want to extend from the list : ");
    System.out.println("          (enter car model number)          ");
    String carmodel=scanner_object.next();
    int car_model=0;
    int found_the_car_position=0;
    Iterator<rent_cardetails> carmodelIterator=rentcardetails.iterator();
    while(carmodelIterator.hasNext())
    {
        car_model++;
        rent_cardetails car_model_name=carmodelIterator.next();
        if(carmodel.equals(car_model_name.getcarmodel()))
        {
             found_the_car_position+=car_model;
        }
    }
    found_the_car_position-=1;
    System.out.println("the car in "+found_the_car_position+"th position");
    //System.out.println("How long days you want to extend rental period of that car? ");
    //int new_rental_days=scanner_object.nextInt();
    LocalDate rentdate=car_details.get(found_the_car_position).getAvailabledate();
    System.out.println(rentdate);
   String formattedDate =rentdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    System.out.println(formattedDate);                                                                                                                                      
    LocalDate rentstartingdate=LocalDate.parse(formattedDate);
   System.out.println("How long days you want to extend rental period of that car ? ");
   int newrented_days=scanner_object.nextInt();
   LocalDate returndate=rentstartingdate.plusDays(newrented_days);
    System.out.println(returndate);




    rentcardetails.set(found_the_car_position, new rent_cardetails(rentcardetails.get(found_the_car_position).getRentername(),rentcardetails.get(found_the_car_position).getCarcategory(),rentcardetails.get(found_the_car_position).getcarmodel(), rentcardetails.get(found_the_car_position).getAveragemileage(),rentcardetails.get(found_the_car_position).getmanufactureDate(),rentcardetails.get(found_the_car_position).getAvailableDate(),rentcardetails.get(found_the_car_position).getDate(),rentcardetails.get(found_the_car_position).getMonth(),rentcardetails.get(found_the_car_position).getYear(),rentcardetails.get(found_the_car_position).getcarpickuplocation(),rentcardetails.get(found_the_car_position).getdroplocation(),rentcardetails.get(found_the_car_position).getreturnstatus(),newrented_days,returndate));
     
   }

}

