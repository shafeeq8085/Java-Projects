package de.testswing;

import java.util.Calendar;
import java.util.TimeZone;

public class MyDateTest {


        public static void main(String[] args)
         {
             TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
             Calendar now = Calendar.getInstance();
             System.out.println(now.getTimeZone());
             System.out.println(now.getTime());
             System.out.println( TimeZone.getDefault().observesDaylightTime() );
             
             TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
             Calendar now2 = Calendar.getInstance();
             System.out.println(now2.getTimeZone());
             System.out.println(now2.getTime());
             
             TimeZone timeZone = TimeZone.getDefault();
             System.out.println( timeZone.getDisplayName() );
             System.out.println( timeZone.observesDaylightTime() );
             System.out.println( timeZone.getOffset( System.currentTimeMillis() ) / 3600000. );
         }          
     
}
