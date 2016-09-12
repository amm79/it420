/* Ahmed Mansour 
IT420 12/3/14 
Programming asssignment */
import java.io.*;
import java.net.*;

public class Server{
	public static void main(String[] arg){

		DataObject myObject = null;

		try{
			
			ServerSocket myServerSocket = new ServerSocket(3000);

			Socket incoming = myServerSocket.accept();

			ObjectOutputStream myOutputStream =
				new ObjectOutputStream(incoming.getOutputStream());

			ObjectInputStream myInputStream =
				new ObjectInputStream(incoming.getInputStream());

			myObject = (DataObject)myInputStream.readObject();
			System.out.println("Message received : " + myObject.getMessage());
		
			myObject.setMessage("His fleece was white as snow,") ;
			System.out.println("Message sent : " + myObject.getMessage());
			myOutputStream.writeObject(myObject);

			
			
			myObject = (DataObject)myInputStream.readObject();
			System.out.println("Message received : " + myObject.getMessage());
			
			myObject.setMessage("The lamb was sure to go.");
			System.out.println("Message sent : " + myObject.getMessage());
			myOutputStream.writeObject(myObject);
		
			myObject = (DataObject)myInputStream.readObject();
			System.out.println("Message received : " + myObject.getMessage());

		

		myOutputStream.close();
			
			myInputStream.close();

			myServerSocket.close();
	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
