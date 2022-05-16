

package admin_package;

public class pickuplocation {
    String add_p;
    public pickuplocation(String add_p){
              this.add_p=add_p;
         
   }

   public  String getcat(){
         return add_p;
   }
   
   public String toString(){
             return "location  :: "+add_p+" ";
   }
}


