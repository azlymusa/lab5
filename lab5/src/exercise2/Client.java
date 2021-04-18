package exercise2;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lab5.ItemProduct;


public class Client {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		System.out.println("ClientSideApp: Demo to process a list of objects on TCP \n");

		// Request data
		

		ItemProduct p1 = new ItemProduct();
		p1.setName("Mouse");
		p1.setPrice(10.10f);
		
		// Add into list
		List<ItemProduct> products = new ArrayList<ItemProduct>();
		products.add(p1);
		

		try {

			// Data to establish connection to server
			int portNo = 5003;
			InetAddress serverAddress = InetAddress.getLocalHost();

			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);

			// Open stream to send object
			ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

			// Send request to server
			System.out.println("Send object to server: " + products);
			objectOS.writeObject(products);
			objectOS.flush();
			
			// Open stream to receive object
			ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
			
			// Get object from stream, cast and display details
			products = (ArrayList<ItemProduct>) objectIS.readObject();
			for (ItemProduct product:products)
				System.out.println ("Id for " + product.getName() + " is " + product.getItemProductId());
			
			// Close all closeable objects
			objectOS.close();
			objectIS.close();
			socket.close();

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nClientSideApp: End of application.\n");

	}

}
