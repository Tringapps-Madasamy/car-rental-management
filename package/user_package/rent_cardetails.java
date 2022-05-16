

package user_package;
import java.time.LocalDate;
public class rent_cardetails {
    String name;
    Object carcategory;
    String carmodel;
    String averagemileage;
    LocalDate manufacturedate;
    LocalDate available_date;
    int availabledate;
    int availablemonth;
    int availableyear;
    String pickuplocation;
    String cardroplocation;
    String rent_status;
    int numberofrentedDays;
    LocalDate returndate;
    public rent_cardetails(String username,Object car_category,
    String car_model,
    String average_mileage,
    LocalDate manufacture_date,
    LocalDate availableDate,
    int available_date,
    int available_month,
    int available_year,
    String pickuplocation,
    String droplocation,
    String rent,
    int noOfrentedDays,
    LocalDate returndate)
    {
        this.name=username;
        this.carcategory=car_category;
        this.carmodel=car_model;
        this.averagemileage=average_mileage;
        this.manufacturedate=manufacture_date;
        this.available_date=availableDate;
        this.availabledate=available_date;
        this.availablemonth=available_month;
        this.availableyear=available_year;
        this.pickuplocation=pickuplocation;
        this.cardroplocation=droplocation;
        this.rent_status=rent;
        this.numberofrentedDays=noOfrentedDays;     
        this.returndate=returndate;    
    }
    public String getRentername(){
        return name;
    }
    public String getcarmodel(){
        return carmodel;
    }
    public String getAveragemileage(){
        return averagemileage;
  }
  public LocalDate getmanufactureDate(){
        return manufacturedate;
  }
  public LocalDate getAvailableDate(){
        return available_date;
  }
  public int getDate(){
        return availabledate;          
  }
  public int getMonth(){
        return availablemonth;
  }
  public int getYear(){
        return availableyear;
  }
  public String getcarpickuplocation(){
      return pickuplocation;
  }
  public String getdroplocation(){
      return cardroplocation;
  }
  public String getreturnstatus(){
      return rent_status;
  }
    public LocalDate getReturndate(){
        return returndate;
    }
    public Object getCarcategory(){
        return carcategory;
    }
    public int getNumberofrentdays(){
        return numberofrentedDays;
    }
    public String toString(){
        return "\n"+"Renter name: "+name+"\n\n"+"car category: "+carcategory+"\n"+" car model: "+carmodel+"\n"+"average mileage: "+averagemileage+"\n"+"manufacture date: "+manufacturedate+
    "available date: "+available_date+"\n"+"available date: "+availabledate+"\n"+"available month:  "+availablemonth+"\n"+"available year:  "+availableyear+"\n"+"pickup location: "+pickuplocation+"\n"+"Droplocation :"+cardroplocation+"\n"+"Rent : "+rent_status+"\n"+"return date: "+returndate;
    }
}

