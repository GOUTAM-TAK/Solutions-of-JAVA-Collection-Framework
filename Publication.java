package core;

import java.time.LocalDate;

public class Publication implements Comparable<Publication>{
      private static int cnt=0;
      private int id;
      private String title;    //primary key
      private int price;
      private LocalDate publishDate;
      private int rating;
      
      public Publication(String name,int p,LocalDate date,int r) {
    	  id=++cnt;
    	  title=name;
    	  price = p;
    	  publishDate=date;
    	  rating=r;
      }
      public Publication(String name) {
    	  
    	 title=name;
      }
      @Override
      public String toString() {
    	  return "Publication Details are : id = "+id+" title = "+title+" price = "+price+"INR publish date = "+publishDate+" rating(out of 10) = "+rating;
      }
      @Override
      public boolean equals(Object o) {
    	  if(o instanceof Publication) {
   		   Publication anotherPub = (Publication)o;
   		   return this.getTitle().equals(anotherPub.getTitle());
   	   }
   	   return false;
      }
      @Override
      public int compareTo(Publication p) {
    	  Integer i =this.getRating();
    	  Integer t = p.getRating();
    	  if(i.compareTo(t)>0)
    		  return -1;
    	  if(i.compareTo(t)<0)
    		  return 1;
    	  return 0;
      }
      
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
     
}
