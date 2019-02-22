import java.util.Map;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class BookDatabase {

	private static Map<String, Book> bookData;

	//creates it behind the scenes
		public BookDatabase() {  //Constructor
			 bookData = new HashMap<String, Book>();
		       
		    }
		
		
	
   

	//returns a reference to the Book object that contains the given title.
	static Book searchByTitle(String title) {
		
		
		//create a temp_list
		ArrayList<String> auth = new ArrayList<String>();
		auth.add("\n");
		 Book temp_list = new Book("none", "none", 0, auth.toArray(new String[0]), 0);
			
		 
		 
			// go through the list to find the set of Books by the given title.
			for ( Map.Entry<String, Book> list : bookData.entrySet() ) {
				
				//check if it contains that title, then add it to the temp_list 
				if ( ( list.getValue().getTitle().contains(title) ) ) {
					temp_list=list.getValue();
					System.out.println( "THIS IS FOUND BY "+title );
					return temp_list;
				}//close if
				
			}//close for
			
			
			
			
			//returns a reference to the Book object that contains the given title.
			System.out.println( "THIS IS NOT FOUND BY "+title );
			return temp_list;
	}
	
	
	
	
	
	
	//returns a set of Books by the given author.
	static Set<Book> searchByAuthor(String author){
		
		int count=0;
		
		//create a temp_list
		Set<Book> temp_list = new HashSet<Book>();
		
		
		
		// go through the list to find the set of Books by the given author.
		for ( Map.Entry<String, Book> list : bookData.entrySet() ) {
			
			//check if it contains that author, then add it to the temp_list 
			if ( ( list.getValue().getAuthors().contains(author) ) ) {
				temp_list.add(list.getValue());
				count++;
			}
			
		}//close for
		
		
		
		if(count!=0) 
			System.out.println( "THIS IS FOUND BY "+ author);
			
		
		if(count==0) 
		System.out.println( "THIS IS NOT FOUND BY "+ author);
		
		//returns a set of Books 
		return temp_list;
	}
	
	
	
	
	
	//returns a set of Books that were published before a given year.
	static Set<Book> publishedBefore(int year){
		
		
		int count=0;
		
		//create a temp_list
		Set<Book> temp_list = new HashSet<Book>();
		
		
		
		// go through the list to find the set of Books by the year before.
		for (Map.Entry<String, Book> list : bookData.entrySet()) {
			
			//if the year Of Publication is before the requested year, then add the temp_list
			if (list.getValue().getyearOfPublication() < year) {
				temp_list.add(list.getValue());
				count++;
			}
			
		}
		
		
		
		if(count!=0) 
			System.out.println( "THIS IS FOUND BY published before "+ year );
		
		
		
		
		if(count==0)
		System.out.println( "THIS IS NOT FOUND BY published before "+ year );
		
		//returns a set of Books 
		return temp_list;
			}
	
	
	
	
	
	
	
	
	//returns a set of Books that were published by the given publisher.
	static Set<Book> searchByPublisher(String publisher){
		
		int count=0;
		
		//create a temp_list
				Set<Book> temp_list = new HashSet<Book>();
				
				// go through the list to find the set of Books by the publisher name
				for (Map.Entry<String, Book> list : bookData.entrySet()) {
					
					//if publisher is found, then add it to the temp_list
					if (list.getValue().getPublisher().contains( publisher) ) {
					      temp_list.add(list.getValue());
					      count++;
					}
					
				}
				
				if(count!=0) 
					System.out.println( "THIS IS FOUND BY "+ publisher );
					
				
				
				if(count==0) 
				System.out.println( "THIS IS NOT FOUND BY "+ publisher );
				
				//returns a set of Books.
				return temp_list;
			}
	
	
	
	
	
	
	//adds a new book to the database if it is not there already.
	//( implement this by adding a new pair into the map where the key is book.getTitle() 
	//and the value is book). 
	//If it is there already, do nothing.
	void addBook(Book book) {
		
		if (   bookData.containsKey( book.getTitle())  ) 
			System.out.println("The book called "+book.getTitle()+" is already there.\n");
		
		if (  !( bookData.containsKey( book.getTitle() ) )  ) {
			bookData.put(book.getTitle(), book);
			System.out.println("The book called "+book.getTitle()+" is added.\n");
		}
		
		
	}
	
	
	
	
	
	//Remove the book with the given title from the database if it is there.
	void removeBook(String title) {
		
		//if it contains the key, then remove that book with the given title 
		//based upon the key if it is there
		
		if (   !(bookData.containsKey(title))   ) 
			System.out.println("The book called "+title +" doesn't exist.\n");
		
		
		if (bookData.containsKey(title)) {
			bookData.remove(title);
			System.out.println("The book called "+title + " removed.\n");
		}
		
		
	}
	
	
	
	
	
	
	//Creates a representation for a book database.
	public String toString() {
		
	//create a stringbuilder
StringBuilder str = new StringBuilder();

System.out.println("\nCurrent database:");

//keep adding each one until it reaches the end
		for (String t : bookData.keySet()) {
			str.append(bookData.get(t).toString() + "\n");
		}
		
		//return the string that was created by the stringbuilder
		return str.toString();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println( "Alvin Huang Data Structures" );
		System.out.println( "testing addBook======================" );
		//adding things to book database
	    BookDatabase db = new BookDatabase();
	    
	    
		//add 1st one
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("Rick Grimes");
		a1.add("Carl Grimes");
		Book b1 = new Book("GEORGE ORWELL WITH A FOREWORD", "THOMAS PYNCHON", 2000, a1.toArray(new String[a1.size()]), a1.size());
		db.addBook(b1);
		
		
		
		
		//add 2nd one
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("Maggie Grenne");
		Book b2 = new Book("All the Birds in the Sky", "CHARLIE JANE ANDERS", 1900, a2.toArray(new String[a2.size()]), a2.size());
		db.addBook(b2);
		
		
		
		//add 3rd one
		ArrayList<String> a3 = new ArrayList<String>();
		a3.add("Shane Walsh");
		a3.add("Andrea");
		Book b3 = new Book("Altered Carbon ", "RICHARD K. MORGAN", 1970, a3.toArray(new String[a3.size()]), a3.size());
		db.addBook(b3);
		
		
		
		//add 4th one
		ArrayList<String> a4 = new ArrayList<String>();
		a4.add("Dale Horvath");
		Book b4 = new Book("Amatka", "KARIN TIDBECK", 2005, a4.toArray(new String[a4.size()]), a4.size());
		db.addBook(b4);
		
		
		
		//add 5th one
		ArrayList<String> a5 = new ArrayList<String>();
		a5.add("Daryl Dixon");
		a5.add("Carol Peletier");
		a5.add("Merle Dixon");
		Book b5 = new Book("Ammonite", "NICOLA GRIFFITH", 2010, a5.toArray(new String[a5.size()]), a5.size());
		db.addBook(b5);
		
		
		
		//add 6th one
		ArrayList<String> a6 = new ArrayList<String>();
		a6.add("J. R. R. Tolkien");
		Book b6 = new Book("Lord of the Rings", "John Smith", 1954, a6.toArray(new String[a6.size()]), a6.size());
		db.addBook(b6);
				
				
				
		//add 7th one
		ArrayList<String> a7 = new ArrayList<String>();
		a7.add("J. R. R. Tolkien");
		Book b7 = new Book("The Hobbit", "John Stone", 1937, a7.toArray(new String[a7.size()]), a7.size());
		db.addBook(b7);
		
		
		
		
		//add 8th one
		ArrayList<String> a8 = new ArrayList<String>();
		a8.add("Charlie Harper");
		Book b8 = new Book("That 70's show", "Eric Fordman", 2010, a8.toArray(new String[a8.size()]), a8.size());
		db.addBook(b8);
		
		
		
		
		//add 9th one
		ArrayList<String> a9 = new ArrayList<String>();
		a9.add("Alan Harper");
		Book b9 = new Book("That 80's show", "Red Fordman", 2012, a9.toArray(new String[a9.size()]), a9.size());
		db.addBook(b9);
				
				
				
		//add 10th one
		ArrayList<String> a10 = new ArrayList<String>();
		a10.add("Chuck W.");
		Book b10 = new Book("Supernatural", "Red Fordman", 1800, a10.toArray(new String[a10.size()]), a10.size());
		db.addBook(b10);
				
		
		
		
		//add 11th one
		ArrayList<String> a11 = new ArrayList<String>();
		a11.add("Henry Ford");
		Book b11 = new Book("Life is Magical", "Dutch Shone", 1900, a11.toArray(new String[a11.size()]), a11.size());
		db.addBook(b11);
		db.addBook(b11);		
		
				
				
		
		
		System.out.println( "\n\n\n" );
		
		
		
		
				
				
		//print db database toString
		System.out.println( "testing toString======================" );
		System.out.print(db.toString());
		
		
		
		
		
		System.out.println( "\n\n\n" );
		
		
		
		
		
		//remove test
		System.out.println( "testing removeBook======================" );
		db.removeBook("Life is Magical");
		db.removeBook("Once Upon a Time");
				
				
		
		
		System.out.println( "\n\n\n" );
		
		
		
		
		
		//print db database toString
		System.out.println( "testing toString======================" );
		System.out.print(db.toString());
		
		
		
		
		
		System.out.println( "\n\n\n" );
		
		
		//test searchByTitle
		System.out.println( "testing searchByTitle======================" );
		System.out.println( searchByTitle("GEORGE ORWELL WITH A FOREWORD" ) );
		System.out.println( searchByTitle("How to become God" ) );
		
		
		
		
		System.out.println( "\n\n\n" );
		
		
		
		
		//test searchByAuthor
		System.out.println( "testing searchByAuthor================" );
		System.out.println( searchByAuthor("Mr.Coco" ) );
		System.out.println(  );
		System.out.println( searchByAuthor("Daryl Dixon" ) );
		
		
		
		System.out.println( "\n\n\n" );
		
		
		
		
		//test publishedBefore
		System.out.println( "testing publishedBefore================" );
		System.out.println( publishedBefore(2000 ) );
		System.out.println(  );
		System.out.println( publishedBefore(1000 ) );
		
		
		
		System.out.println( "\n\n\n" );
		
		
		
		
		//test searchByPublisher
		System.out.println( "testing searchByPublisher================" );
		System.out.println( searchByPublisher("Red Fordman" ) );
		System.out.println(  );
		System.out.println( searchByPublisher("Sandy Randy" ) );
		
		
		
		
		
		
		
		
	}//close main

}
