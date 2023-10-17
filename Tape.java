package core;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tape extends Publication{
         LocalTime mins;
         public Tape(String name,int p,LocalDate date,int r,LocalTime m) {
        	 super(name,p,date,r);
        	 mins = m;
         }
         public Tape(String name) {
        	 super(name);
         }
         @Override
         public String toString() {
        	 return "Tape "+super.toString()+" duration(in mins) = "+mins;
         }
         
}
