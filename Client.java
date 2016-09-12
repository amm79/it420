/* Ahmed Mansour 
IT420 12/3/14 
Programming asssignment */


import java.io.*;
import java.net.*;


public class Client{
	public static void main(String[] arg){
		try{
			DataObject myObject = new DataObject();

			myObject.setMessage("Marry had a little lamb?");

			System.out.println("Client: " + myObject.getMessage()); /* 1 */

			Socket socketToServer = new Socket("128.235.44.75", 3000);

			ObjectOutputStream myOutputStream =
				new ObjectOutputStream(socketToServer.getOutputStream());

			ObjectInputStream myInputStream =
				new ObjectInputStream(socketToServer.getInputStream());

			myOutputStream.writeObject(myObject);
			
			myObject = (DataObject)myInputStream.readObject();
						System.out.println("Server : " + myObject.getMessage());
			
			
		myObject.setMessage("And everywhere that Mary went,");	
			myOutputStream.writeObject(myObject);
					
					System.out.println ("Client : " + myObject.getMessage()); /* 2 */
			myObject = (DataObject)myInputStream.readObject();	
					System.out.println("Server: " + myObject.getMessage());
			
		myObject.setMessage("He followed her to school one day,");
			myOutputStream.writeObject(myObject);
					
					System.out.println ("Client : " + myObject.getMessage()); /* 3 */
			myOutputStream.close();
			
			myInputStream.close();

            		socketToServer.close();
	
		}
		catch(Exception e){
			System.out.println(e);
        	}
	}
}