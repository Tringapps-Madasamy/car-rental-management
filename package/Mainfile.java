
import admin_package.*;
import user_package.User;
import java.util.*;

class Mainfile 
{
public static void main(String args[])
{  
  Scanner o=new Scanner(System.in);
  Admin adm_obj=new Admin();
  User usr_obj=new User();                                        
  while(true)
  {
     System.out.println("Are you an Admin-->1 or User-->2 or Exit-->3");
     int Adm_Use=o.nextInt();
     switch(Adm_Use)
     {
          case 1: adm_obj.login(); break;
          case 2: usr_obj.in_or_up(); break;
                  //usr_obj.signup();
          case 3: System.exit(0);
     }
  } 
}
}