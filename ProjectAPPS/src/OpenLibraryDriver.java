import java.net.HttpURLConnection;
import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sqlite.SQLiteDataSource;

import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;



public class OpenLibraryDriver {
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:C:\\Users\\Admin\\git\\repository\\ProjectAPPS\\openlib.db");
			Connection conn = ds.getConnection();
			System.out.println("Connection created");
			return conn;
			
			
		} catch(Exception e) {
			System.out.println("error catching");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	public static ArrayList<String> readAuthorList() {
		
		ArrayList<String> authorList = new ArrayList<String>();
		try {
		      File myObj = new File("C:\\Users\\Admin\\git\\repository\\ProjectAPPS\\AuthorKeys.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        authorList.add(data.trim());
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		return authorList;
		
	}
	
	public static void displayChart(ChartTracker ct) {
		if(ct.getErrorFlag()==false) {
			System.out.println("Most popular books are:- ");
			System.out.println("1. "+ct.getBookOne().getTitle()+"\n2. "+ct.getBookTwo().getTitle()+"\n3. "+ct.getBookThree().getTitle());
			System.out.println();
			System.out.println("Most popular authors are:- ");
			System.out.println("1. "+ct.getAuthorOne().getName()+"\n2. "+ct.getAuthorTwo().getName()+"\n3. "+ct.getAuthorThree().getName());
		}
		else {
			System.out.println("ChartTracker state in error.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// script to read data for authors api
		
		
		
//		ArrayList<String> authorList = OpenLibraryDriver.readAuthorList();
//		if (authorList.size()==0) {
//			System.out.println("No author read");
//		}
//		else {
//			System.out.println(authorList.toString());
//		}
//		
		
		Connection conn = OpenLibraryDriver.getConnection();
		
		APIReader areader = new APIReader();
		
//		if(authorList != null) {
//			AuthorsController ac = new AuthorsController();
//			for(int i=0;i<authorList.size();i++) {
//				Authors author = areader.readAuthorAPI(authorList.get(i).trim());
//				ac.insert(author, conn);
//			}
//		}
//		
//		System.out.println("---------------------------");
//		
		BooksController bkc = new BooksController();
		AuthorsController ac = new AuthorsController();
//		ArrayList<String> authorNames = ac.getAuthorNames(conn);
//		System.out.println(authorNames.toString());
//		
//		System.out.println("---------------------------------");
//		
//		ArrayList<String> booklist = new ArrayList<String>();
//		for(int i=0; i< authorNames.size(); i++) {
//			ArrayList<String> currentAuthorBooks = areader.getAuthorBookKeys(authorNames.get(i).split(";")[0], authorNames.get(i).split(";")[1]);
//			List<String> arrlist2 = currentAuthorBooks.subList(0, 3);
//			booklist.addAll(arrlist2);
//			
//		}
//		System.out.println(booklist.toString());
//		System.out.println("---------------------------------------");
//		
//		for(int i=0; i< booklist.size(); i++) {
//			System.out.println(booklist.get(i).split(";")[0].trim());
//			Books book = areader.readBookAPI(booklist.get(i).split(";")[0].trim());
//			book.setAuthor(booklist.get(i).split(";")[1]);
//			bkc.insert(book, conn);
//		}
//		
		
		
		Scanner scnr = new Scanner(System.in);
		boolean rflag = true;
		
		System.out.println("Welcome to the Open Library Management System.");
		ChartTracker ct = new ChartTracker(conn);
		OpenLibraryDriver.displayChart(ct);
		
		boolean logflag = false;
		boolean bflag = false;
		User usr = null;
		UsersController uc = new UsersController();
		BooksController bkc1 = new BooksController();
		AuthorsController ac1 = new AuthorsController();
		BuyMapperController bmpc = new BuyMapperController();
		
		while(rflag==true) {
			System.out.println("What do you want to do? Chose option by typing the corresponding number");
			if (logflag ==false) {
				System.out.println("1. LogIn\n2. Quit");
//				int choice = Integer.parseInt(scnr.nextLine());
				int choice = 1;
				if(choice==2) {
					rflag = false;
				}
				else if(choice == 1) {
					System.out.println("Please enter your id:");
//					String id = scnr.nextLine();
					String id = "324535";
					System.out.println("Please enter your password:");
//					String pwd = scnr.nextLine().trim();
					String pwd = "RG@12";
					
					usr = (User) uc.read(id, conn);
					
					if(usr == null ){
						
						System.out.println("Your entered id was wrong as no user could be found for id");
						
						
					}
					else if(usr.getPassword().trim().equals(pwd)){
						
						logflag = true;
						System.out.println("Welcome "+ usr.getName());
						
					}
					else {
						
						System.out.println("Either your entered id or password was wrong");
						
					}
				}
			}
			
			else {
				System.out.println("1. Start a Book Buying Session\n2. LogOut\n3. Quit");
//				int choice = Integer.parseInt(scnr.nextLine());
				int choice =1;
				if(choice==3) {
					rflag = false;
				}
				else if(choice == 2) {
					usr = null;
					logflag = false;
				}
				else if(choice == 1) {
					bflag = true;
					System.out.println("Code for buying session comes here");
					System.out.println("Enter the book title to buy:");
					String title = scnr.nextLine();
					
					Books book = (Books)bkc.readBookByName(title, conn);
					if(book==null) {
						System.out.println("Book not found");
					}
					else {
						System.out.println(book.getTitle()+" written by "+ book.getAuthor());
						System.out.println("how many copies do you want to buy?");
						int quantity = Integer.parseInt(scnr.nextLine());
						
						usr.setChartTracker(ct);
						usr.buyBook(book, quantity, bmpc, bkc, ac, conn);
						
						OpenLibraryDriver.displayChart(ct);
						
					}
					
					while(bflag==true) {
						System.out.println("Do you want to continue the buying session:Enter yes or no.");
						String chc = scnr.nextLine();
						if (!(chc.toLowerCase().equals("yes"))) {
							bflag = false;
						}
						else {
							System.out.println("Enter the book title to buy:");
							title = scnr.nextLine();
							
							book = (Books)bkc.readBookByName(title, conn);
							if(book==null) {
								System.out.println("Book not found");
							}
							else {
								System.out.println("Following Book was found");
								System.out.println(book.getTitle()+" written by "+ book.getAuthor());
								
								System.out.println("how many copies do you want to buy?");
								int quantity = Integer.parseInt(scnr.nextLine());
								
								usr.setChartTracker(ct);
								usr.buyBook(book, quantity, bmpc, bkc1, ac1, conn);
								
								OpenLibraryDriver.displayChart(ct);
								
							}
						}
						
					}
					
				}
				
			}
			
		}
		
		
		
	}

}
