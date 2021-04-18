package date.app.client;


import java.net.InetAddress;
import java.net.Socket;

/**
 * This class manage connection to the server
 * 
 * @author emalianakasmuri
 *
 */

public class ServerConnector {
	
	
	/**
	 * This method creates and establish connection to the server
	 * @return
	 * @throws Exception
	 */
	public Socket getConnection() throws Exception {
		
		Socket socket = new Socket(InetAddress.getLocalHost(), 5217);
			
		return socket;
	}

}
