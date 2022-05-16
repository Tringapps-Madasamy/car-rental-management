

package admin_package;
public class category{
      String add_c;
      int cat_rent;
      int cat_count;
      public category(String add_c,int cat_rent,int cat_count){
            this.add_c=add_c;
            this.cat_rent=cat_rent;
            this.cat_count=cat_count;
     }
     public String getcatName(){
             return add_c;       
     }
     public int getRent(){
           return cat_rent;
     }
     public String toString(){            
               return cat_count+" .category  :: "+add_c+" "+"rent  :: "+cat_rent+" ";
      }
}



