import java.util.*;
/**
*
* Created by jashgopani 11-July-2020
* 
* Program to Convert UNIX Timestamp string to readable date and time
*/

public class UNIXTimestamp {
   
    public static void main(String args[]) {
        //Input taken through command line = args[0]
        //convert String input to integer
        int timestamp = Integer.parseInt(args[0]);
        
        System.out.println(getDate(timestamp,true));
    }
    
    /**
    * Detect if the given year is Leap year or not
    * @param y The year to be detected
    * return A boolean representing leap or not
    */
    public static boolean isLeap(int y){
        //leap year should be divisible by 4,100,400 all or 4 only
        if(y%4==0){
            if(y%100==0){
                if(y%400==0){
                    return true;
                }
            }
            return true;
        }
        return false;
    }
    
    /**
    * Calculate Date and Time from given UNIX Timestamp
    * @param timestamp The unix timestamp to be converted
    * @param withTime Set this to true if you want date and time both
    * return A Formatted Date / Date-Time String
    */
    public static String getDate(int timestamp,boolean withTime){
        int yyyy=1970,mm=01,dd=01;//initial value
        
        int dsecs = 24*3600;//time(in secs) of a day
        int ysecs = dsecs*365;//time(in secs) of a year
        
        int ts = timestamp;
        //calculate year by subtracting the time(in secnds) of each year from the timestamp
        //loop stops when the time remaining is less than a year's time
        while(ts>ysecs){
            ts-=isLeap(yyyy)?(ysecs+dsecs):ysecs;
            yyyy+=1;
        }
        
        //no. of days in each month of current year
        int days[] = new int[]{31,(isLeap(yyyy)?29:28),31,30,31,30,31,31,30,31,30,31};
        
        //subtract time of each month from timestamp
        //loop stops when the time remaining is less than a month's time
        while(ts>(28*dsecs) && mm<=12){
            ts-=(days[mm-1]*dsecs);
            mm+=1;
        }
        
        //remaining time in seconds divided by time of a single day gives us the remaining number of days
        dd+=(ts/dsecs);
        
        if(!withTime)
        return String.format("%02d/%02d/%04d UTC",dd,mm,yyyy);
        
        int HH=0,MM=0,SS=0;
        //time remaining after calculating no. of days 
        //i.e hours passed in current day (in seconds)
        ts%=dsecs;
        
        //converting seconds to hours
        HH = ts/3600;
        
        //time remaining after calculating no. of hrs passed today 
        //i.e minutes passed in current day after HH hours (in seconds)
        ts%=3600;
        
        //converting seconds to minutes
        MM = ts/60;
        
        //seconds elapsed after HH hours and MM minutes
        SS = ts%60;
        
        return String.format("%02d/%02d/%04d %02d:%02d:%02d UTC",dd,mm,yyyy,HH,MM,SS);
        
    }
}
