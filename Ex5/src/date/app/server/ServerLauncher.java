package date.app.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {

	
	/**
	 * Main entry point to server-side application
	 * 
	 */
	public static void main(String[] args) {
		
		
		ServerWordCounterFrame serverFrame = new ServerWordCounterFrame();
		serverFrame.setVisible(true);
		
		try {

			// Bind server socket to port 5217 or any port no
			ServerSocket serverSocket =new ServerSocket(5217);

			// Variable to keep tract number of request made to the server
			int totalRequest = 0;

			// Server needs to be alive
			while(true) {

				// Message indicating server is alive
				serverFrame.updateServerStatus(false);

				// Accept connection request
				Socket socket =serverSocket.accept();
				serverFrame.updateServerStatus(socket.isConnected());

				// Create input stream to read data to be processed from client
				DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
				String text = inFromClient.readUTF();
		
				// Process text and get the total word count from the text
				ServerWordCounter wordCounter = new ServerWordCounter();
				int totalWords = wordCounter.countWord(text);

				// Create output stream to send output to the client
				DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
				outToClient.writeInt(totalWords);

				// Close connection
				inFromClient.close();
				outToClient.close();
				socket.close();

				// Update request status
				serverFrame.updateRequestStatus("Text: " + text);
				serverFrame.updateRequestStatus("Total words: " + totalWords);
				serverFrame.updateRequestStatus("Accept connection from client.  "
						+ "Total request = " + ++totalRequest);

			}
			
		} catch (Exception exception) {

			exception.printStackTrace();
			serverFrame.updateRequestStatus("DURIAN TUNGGAL, WE HAVE A PROBLEM!");
			serverFrame.updateRequestStatus("Exception: " + exception.getMessage());
		}
	}
		

}
