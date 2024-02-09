
class CustomDate
{
    int month;
    int day;
    int year;
    public CustomDate ( int year, int month, int day)
    {
       this.year =year;
       this.month =month;
        this.day =day;
    }
    public CustomDate ( )
    {
       
    }
    public void setYear(int year)
    {
        this.year =year;

    }
    public Integer getYear()
    {
        return year;
    }
    public void setMonth(int month)
    {
       this.month =month; 
    }
    public Integer getMonth()
    {
        return month;
    }
    public void setDay(int day)
    {   
        this.day =day;
    }
    public Integer getDay()
    {
        return day;
    }
    void DisplayDate(int year, int month, int day)
    {
        System.out.println(year + " " + month + " " + day);
    }
    

}

public class unity {

    public static void main(String[] args) {
        CustomDate da = new CustomDate(8, 38, 89);
        da.DisplayDate(5, 30, 24);
        System.out.println(da.year + " " + da.month + " " + da.day);

    }
}
