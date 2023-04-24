import java.util.*;
public class NumberOfDays {
    public static void main(String[] args){
        String[] month_array= {"January","February","March","April","May","June","July","August","September","October","November","December"
        ,"Jan.","Feb.","Mar.","Apr.","Aug.","Sept.","Oct.","Nov.","Dec.","Jan","Feb","Mar","Apr","Jun","Aug","Sep","Oct","Nov","Dec",
        "1","2","3","4","5","6","7","8","9","10","11","12"
        };
        String[] month_31={"January","March","May","July","August","October","December"
        ,"Jan.","Mar.","Aug.","Oct.","Dec.","Jan","Mar","May","Jul","Aug","Oct","Dec",
        "1","3","5","7","8","10","12"};
        String[] month_30={"April","June","September","November",
        "Apr.","Sept.","Nov.","Apr","Jun","Sep","Nov"
        ,"4","6","9","11"};
        Scanner scan=new Scanner(System.in);
        String month="0";
        String year="year";
        boolean check_year=true;
        do {
            System.out.println("Enter the month: ");
            month=scan.next();
            System.out.println("Enter the year: ");
            check_year=scan.hasNextInt();
            year=scan.next();
        }
        while(!Arrays.asList(month_array).contains(month)||check_year==false);
        int year_int=Integer.parseInt(year);
        if (Arrays.asList(month_31).contains(month)) {
            System.out.println("This month has 31 day");
        } else if (Arrays.asList(month_30).contains(month)){
            System.out.println("This month has 30 day");
        } else if (year_int%4==0||(year_int%100==0&&year_int%400!=0)){
            System.out.println("This month has 28 day");
        } else{
            System.out.println("This month has 29 day");
        }
    }
}
