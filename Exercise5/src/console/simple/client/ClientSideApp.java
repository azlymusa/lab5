package console.simple.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * This application demonstrate the application of DataInputStream and 
 * DataOutputStream on the client-side.
 * 
 * How to run this program?
 * 1. Open Terminal
 * 2. Change directory to workspace-dad/demoDataStream/bin
 * 3. Type java console.simple.client.ClientSideApp
 * 
 * @author emalianakasmuri
 *
 */

public class ClientSideApp {
	
	public static void main (String args[]) {
		
		System.out.println("ClientSideApp: Demo of DataOutputStream\n");
		
		// Request data
		int request = 1;
		float price = 23.89f;
		double amount = 34.00;
		boolean flag = false;
		String text = "Stream is awesome";
		
		
		try {
			
			// Data to establish connection to server
			int portNo = 4228;
			InetAddress serverAddress = InetAddress.getLocalHost();
			
			// Connect to the server at localhost, port 4228
			Socket socket = new Socket(serverAddress, portNo);
			
			// Open stream to send data
			DataOutputStream dataOS = new DataOutputStream(socket.getOutputStream());
			
			// Send request to server
			System.out.println("Send data to server: " + request);
			dataOS.writeInt(request);
			
			System.out.println("Send data to server: " + price);
			dataOS.writeFloat(price);
			
			System.out.println("Send data to server: " + amount);
			dataOS.writeDouble(amount);

			System.out.println("Send data to server: " + flag);
			dataOS.writeBoolean(flag);

			System.out.println("Send data to server: " + text);
			dataOS.writeUTF(text);
			dataOS.flush();

			System.out.println("Send data to server: " + text + " (in bytes)");
			dataOS.writeInt(text.getBytes().length);
			dataOS.flush();
			dataOS.write(text.getBytes());
			dataOS.flush();
			
			//Open stream to receive data
			DataInputStream dataIS = new DataInputStream(socket.getInputStream());
			
			// Get response from server and display the response
			String response = dataIS.readUTF();
			System.out.println("Response from server: " + response);
			
			// Close all closable objects
			dataOS.close();
			dataIS.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nClientSideApp: End of application.\n");
		
	}

}

			
			
			
			