package date.app.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClientWordCounterFrame extends JFrame implements ActionListener {
	
private static final long serialVersionUID = 1L;
	
	// Private frame components
	private JLabel lblServerTotalWords;
	private JTextArea txtText;
	
	// Private attributes for frame size
	private int width = 900;
	private int height = 300;
	
	/**
	 * The constructor that initialize and organize the Swing components on 
	 * the frame.
	 */
	public ClientWordCounterFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Word Counter Application: Client Side ");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
        lblServerTotalWords = new JLabel("-");
		
		// Row, Column
		this.txtText = new JTextArea(10, 40);
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	/**
	 * This method update the value of date on the frame
	 * 
	 * @param serverDate: Server's date
	 */
	private void updateTotalWords (int totalWords) {
		
		// Parse to string for display
		String parsedTotalWords = Integer.toString(totalWords);
		
		
		this.lblServerTotalWords.setText(parsedTotalWords);
		
	}
	
	
	
	/**
	 * This method creates and arrange Swing components to display status of 
	 * client's connection to the server.
	 * 
	 * @param font
	 * @return Swing components organized in a panel.
	 */
	private JPanel getInputPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblText = new JLabel ("Enter text: ");
		JButton btnSubmit = new JButton("Get Total Words");
		JButton btnClear = new JButton("Clear");
		
		
		// Set action command - All buttons are registered to one listener
		btnSubmit.setActionCommand("submit");
		btnClear.setActionCommand("clear");
		
		// Register button to listener
		btnSubmit.addActionListener(this);
		btnClear.addActionListener(this);
		
		// Style the component
		lblText.setFont(font);
		lblText.setBackground(Color.WHITE);
		lblText.setOpaque(true);
		
		// Styling the request text
		txtText.setFont(new Font("Courier", Font.PLAIN, 15));
		txtText.setLineWrap(true);
		
		// Organize components into panel
		
		panel.add(lblText);
		panel.add(txtText);
		panel.add(btnClear);
		panel.add(btnSubmit);
		
		return panel;
		
	}
	
	/**
	 * This method creates and arrange Swing components to date retrieve from 
	 * the server.
 	 *
	 * @param font
	 * @return Swing components organized in panel
	 */
	private JPanel getOutputPanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblTotalWords = new JLabel ("Total Words: ");

		// Style the component
		lblTotalWords.setFont(font);
		lblServerTotalWords.setFont(font);
		lblTotalWords.setBackground(Color.WHITE);
		lblTotalWords.setOpaque(true);
		lblServerTotalWords.setBackground(Color.WHITE);
		lblServerTotalWords.setOpaque(true);

		// Organize components into panel
		panel.add(lblTotalWords);
		panel.add(lblServerTotalWords);
		
		return panel;
	} 
	
	
	/**
	 * This method arrange the Swing components on the frame.
	 */
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getInputPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get server date's panel and add to frame
		JPanel center = getOutputPanel(font);
		this.add(center, BorderLayout.CENTER);
		
	}
	
	
	/**
	 * This method define a font to a generic style.
	 * 
	 * @return font object
	 */
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		String actionCommand = event.getActionCommand();
		
		switch (actionCommand) {
			
		case "submit":
			// Process word counting
			
			try {
				
				// Send data to server for processing
				WordCounter wordCounter = new WordCounter();
				int totalWords = wordCounter.countWord(txtText.getText());
				
				// Display word count
				this.updateTotalWords(totalWords);
				
				
			} catch (Exception exception) {
				
				
			}
			
			break;
		
		case "clear": 
			// Clear the frame
			
			clearFrameDisplay();
			
			break;
			
		} // end of switch-actionCommand
		
		
	}
	
	/**
	 * This method clears all input and output display
	 */
	private void clearFrameDisplay () {
		
		txtText.setText("");
		lblServerTotalWords.setText("-");
	}

}
