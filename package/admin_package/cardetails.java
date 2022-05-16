
package admin_package;
import java.time.*;

//import javafx.fxml.LoadException;

public class cardetails {
      int no_of_cars;
    public  Object car_category;
    String c_model;
    String avg_mil;
    LocalDate manufacture_date;
    LocalDate Availabledate;
    int available_date;
    int available_month;
    int available_year;
    String pickuplocation;
    String droplocation;
    String rent_status;
    public cardetails(int numberofcars,Object car_category,String c_model,String avg_mil,LocalDate manufacture_date,LocalDate availabledate,int available_date,int available_month,int available_year,String pickuplocation,String droplocation,String rent){
           this.no_of_cars=numberofcars;
           this.car_category=car_category;
           this.c_model=c_model;
           this.avg_mil=avg_mil;
           this.manufacture_date=manufacture_date;
           this.Availabledate=availabledate;
           this.available_date=available_date;
           this.available_month=available_month;
           this.available_year=available_year;
           this.pickuplocation=pickuplocation;
           this.droplocation=droplocation;
           this.rent_status=rent;
    }   
    public int getCarnumber(){
          return no_of_cars;
    }
    public Object  getCategory(){

          return car_category;
    }
    public String getCarmodel(){
          return c_model;
    }
    public String getaveragemileage(){
          return avg_mil;
    }
    public LocalDate getManufacturedate(){
          return manufacture_date;
    }
    public LocalDate getAvailabledate(){
          return Availabledate;
    }
    public int getDate(){
          return available_date;          
    }
    public int getMonth(){
          return available_month;
    }
    public int getYear(){
          return available_year;
    }
    public String getPickuplocation(){
          return pickuplocation;
    }
    public String getDroplocation(){
          return droplocation;
    }
    public String getRentstatus(){
          return rent_status;
    }
    public String toString(){
            return "\n"+no_of_cars+".car category: "+car_category+"\n"+" car model: "+c_model+"\n"+"average mileage: "+avg_mil+"\n"+"manufacture date: "+manufacture_date+
                    "\n"+"available date: "+available_date+"\n"+"available month:  "+available_month+"\n"+"available year:  "+available_year+"\n"+"pickup location: "+pickuplocation+"Drop location : "+droplocation+"Rent : "+rent_status+"\n";
    }
}




