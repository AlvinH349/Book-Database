import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Book {
	String title; 
	String publisher;
	int yearOfPublication; 
	private Set<String> authors;
	private String[] author_array;
	
	
	
	
	//This is the book constructor. It will initialize all the member variables
	//store all of the authors names in the container that will hold these names
	Book(String title, String publisher, int yearOfPublication, String[ ] authors, int numAuthors){

		this.title = title;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		
		//set authors with a HashSet
		this.authors = new HashSet<>();
		
		//store all of the authors names in the container that will hold these names
		//add the authors based upon the number of authors there are
		for (int i = 0; i < numAuthors; i++) {
			this.authors.add(authors[i]);
		}
		
		//set author_array with authors
		this.author_array = authors;
	}
	
	
	
	//get the title method accessor method by returning the String of a title
	public String getTitle() {
		return this.title;
	}
	
	
	
	//get the publisher method accessor method by returning a String of the publisher
		String getPublisher() {
			return this.publisher;
		}

		
		
		//get the year of Publication accessor method by returning the year (number)
		int getyearOfPublication() {
			return this.yearOfPublication;
		}
		
		
		
		//get the author accessor method by returning the name of the author 
		public Set<String> getAuthors() {
			return this.authors;
		}
				
				
				
		//equals method- compare the object with the other		
	    public boolean equals (Object obj) {
			
	    	//check if obj is part of Book
			if(obj instanceof Book) {
				Book other= (Book)obj;
				
				//check if titles are the same
			if(  title.equals( other.getTitle() )  )
				return true;
			
			  else
			    	return false;
				
		}// outer if closing
	        
	        else
	            return false;
		}// close equals method
		
	    
	    
	    
	    
	    
	   //this will return true if the title of book1 is lexicographically before the title of graph two
	    int compareTo(Book another) {
	    	return title.compareTo( another.getTitle() );
	    }
	    
	    
	    
	    
	    //this will create a representation for a Book
	   public String toString() {
		   
		   //use a Stringbuilder
		   StringBuilder str = new StringBuilder();
		   
			str.append("Title: " + this.title + "\n");
			str.append("Authors: ");
			
			//find the author within the string array, else say say author can't be found
			for (int i = 0; i < author_array.length; i++) {
				if(i < author_array.length )
				str.append(author_array[i]+"\n");
				
				else
					str.append("unknown author\n");
			}
			
			str.append("Publisher: " + this.publisher + "\n");
			str.append("Year: " + this.yearOfPublication + "\n");
			
			//return the whole string
			return str.toString();
	    }
	    
	    
	    
}
