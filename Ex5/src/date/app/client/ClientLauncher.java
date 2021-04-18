package date.app.client;

/**
 * This class contains main() method to launch the client window
 * @author emalianakasmuri
 *
 */
public class ClientLauncher {

	/**
	 * Main entry point of client
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Launch client frame
		ClientWordCounterFrame clientFrame = new ClientWordCounterFrame();
		clientFrame.setVisible(true);
	}

}
