package core;

import java.time.LocalDate;

public class Book extends Publication{
   private int pageCount;
   
   public Book(String name,int p,LocalDate date,int r,int cnt) {
	   super(name,p,date,r);
	   pageCount=cnt;
   }
   public Book(String name) {
	   super(name); 
	   
   }
   @Override
   public String toString() {
	   return "book "+super.toString()+" page count = "+pageCount;
   }
   
   
  /* @Override
   public boolean equals(Object o) {
	   if(o instanceof Publication) {
		   Publication anotherPub = (Publication)o;
		   return this.getTitle().equals(anotherPub.getTitle());
	   }
	   return false;	   
   }*/
}
