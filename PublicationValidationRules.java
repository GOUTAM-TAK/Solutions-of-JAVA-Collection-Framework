package utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ExceptionHandling.PublicationExceptionHandling;
import core.Book;
import core.Publication;
import core.Tape;

public class PublicationValidationRules {
           public static void checkDups(String name,List<Publication> publications)throws PublicationExceptionHandling
           {
        	   Publication another = new Publication(name);
        	   
        	   if(publications.contains(another)) {
        		   throw new PublicationExceptionHandling("duplicate publications are not allowed!!!");
        	   }
           }
           public static LocalDate checkDate(String date)throws IllegalArgumentException {
        	   LocalDate validDate = LocalDate.parse(date);
        	   return validDate;
           }
           public static LocalTime checkTime(int min)throws DateTimeException {
        	   LocalTime validTime = LocalTime.of(0, min);
        	   return validTime;
           }
           public static void checkRating(int r)throws PublicationExceptionHandling {
        	   if(r>10||r<1)
        		   throw new PublicationExceptionHandling("rating is not in range(1-10)");
        		   
           }
           public static Publication checkAllInputBook(String name,int p,String date,int r,int cnt,List<Publication>publications) throws PublicationExceptionHandling,IllegalArgumentException
           {
        	   checkDups(name,publications);
        	   checkRating(r);
        	   LocalDate vdate=checkDate(date);
        	   return new Book(name,p,vdate,r,cnt);
           }
           public static Publication checkAllInputTape(String name,int p,String date,int r,int min,List<Publication>publications) throws PublicationExceptionHandling,IllegalArgumentException,DateTimeException
           {
        	   checkDups(name,publications);
        	   checkRating(r);
        	   LocalDate validDate = checkDate(date);
        	   LocalTime validTime = checkTime(min);
        	   return new Tape(name,p,validDate,r,validTime);
           }
}
