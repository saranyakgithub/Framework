package utility;

import com.mongodb.client.MongoDatabase;

import java.sql.Timestamp;

import org.bson.Document;

import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential; 

public class DBConnect {
	      
	public static void connectDB(){
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	   
	      // Creating Credentials 
	     /* MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "myDb", 
	         "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  */
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("Testing"); 
	      System.out.println("Connected to the database successfully" );     
	}
	
	public static void insertRecord(String TCName, Timestamp timestmp, String result) {
		
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		 	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("Testing"); 
		
	      Document document = new Document();
	      document.append("TCName", TCName);
	      document.append("Execution_Timestamp", timestmp);
	      document.append("Result", result);
	      //Inserting the document into the collection
	      database.getCollection("TestReport").insertOne(document);
	      System.out.println("Document inserted successfully");
		
	}
}

