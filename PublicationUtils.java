package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import ExceptionHandling.PublicationExceptionHandling;
import core.Book;
import core.Publication;
import core.Tape;

public class PublicationUtils implements Comparator<Publication> {
       @Override          
	public int compare(Publication p1,Publication p2) {
    	   if(p1.getPublishDate().isBefore(p2.getPublishDate())){
    		   return -1;
    	   }
    	   if(p1.getPublishDate().isAfter(p2.getPublishDate())){
    		   return 1;
    	   }
    	   return 0;
       }
       public static List<Publication> populatedList() {
    	   List<Publication> publications = new ArrayList<>();
    	   publications.add(new Book("ganesh",300,LocalDate.parse("2019-12-01"),6,67));
    	   publications.add(new Book("mahadeva",1200,LocalDate.parse("2012-08-21"),9,102));
    	   publications.add(new Tape("Oxworld",1300,LocalDate.parse("2019-12-01"),8,LocalTime.of(0,40)));
    	   publications.add(new Book("SanjivPass",800,LocalDate.parse("2022-11-11"),10,105));
    	   publications.add(new Tape("colorstv",1000,LocalDate.parse("2023-10-09"),8,LocalTime.of(0,50)));
    	   publications.add(new Tape("startv",5000,LocalDate.parse("2023-03-19"),10,LocalTime.of(0,55)));
    	   publications.add(new Tape("manoranjantv",7000,LocalDate.parse("2023-02-10"),7,LocalTime.of(0,30)));
    	   publications.add(new Book("Excelent",4500,LocalDate.parse("2023-04-16"),7,140));
    	   publications.add(new Book("classmate",1800,LocalDate.parse("2023-11-11"),3,66));
    	   publications.add(new Book("cdac",400,LocalDate.parse("2023-10-23"),1,20));
    	   publications.add(new Book("acts",1300,LocalDate.parse("2011-10-13"),7,120));
    	   publications.add(new Book("cdacact",400,LocalDate.parse("2013-10-23"),1,20));
    	   publications.add(new Book("punebook",400,LocalDate.parse("2015-10-23"),1,20));
    	   publications.add(new Tape("entertainment",7000,LocalDate.parse("2007-02-10"),7,LocalTime.of(0,30)));
    	   publications.add(new Tape("pogotv",7000,LocalDate.parse("2017-02-10"),7,LocalTime.of(0,30)));
    	   return publications;
       }
       public static List<Publication> curntRatingOrder(List<Publication>publications)throws PublicationExceptionHandling{
    	   List<Publication> temp = new ArrayList<Publication>();
    	   int flag=0;
    	   LocalDate spDate = LocalDate.of(2023,07,11);
    	   for(Publication p : publications) {
    	   if(spDate.getYear()==p.getPublishDate().getYear()) {
    		   temp.add(p);
    	   flag=1;
       }
       }
    	   if(flag==0)
    		   throw new PublicationExceptionHandling("NO current year Publication present!!!");
       Collections.sort(temp);
       return temp;
       }
       public static List<Publication> oldRecordRemove(List<Publication>publications) {
    	   
    	    Iterator<Publication> itr = publications.iterator();
    	    while(itr.hasNext()){
    	    	Publication p = (Publication)itr.next();
    		   if(2023-p.getPublishDate().getYear()>4)
    			   itr.remove();   
    	   }
    	    return publications;
       }
}
