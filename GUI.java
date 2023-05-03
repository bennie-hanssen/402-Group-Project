import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/**
 * 
 * GUI class for displaying output to user
 * 
 * May 3, 2023
 */

/////////This implemenets actions from the button
public class GUI implements ActionListener {
	private JLabel passwordlabel;
	private JPasswordField passwordText = new JPasswordField();
	private JButton checkButton;
	private JButton clearButton;
	private String typedPassword;
	private JLabel passwordTextDisplayed = new JLabel();
	TesterCheckPassword password = new TesterCheckPassword();
	JTextArea textArea = new JTextArea(10, 40);
	private final static String newline = "\n";

	// Sizing of the frame
	// JPanel panel = new JPanel();
	JFrame frame = new JFrame();

	GUI() {
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate program on close
		frame.setTitle("Password Strength Tester"); // title of window

		// Customize Java logo
		ImageIcon image = new ImageIcon("passwordstrength.jpg");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(255, 255, 255));// changes background color

		// This is the label for password text box
		passwordlabel = new JLabel("Password");
		passwordlabel.setBounds(20, 20, 100, 25);
		frame.add(passwordlabel);
		passwordText.setBounds(100, 20, 165, 25);
		frame.add(passwordText);

		// The text area where the output of tips and strength of password will be
		// displayed
		textArea.setBounds(0, 105, 350, 140);
		;
		textArea.setForeground(Color.RED);
		textArea.setEditable(false);
		frame.add(textArea);

		// Button to check for requirements
		checkButton = new JButton("Check");
		checkButton.setFocusable(false);
		checkButton.setBounds(10, 80, 80, 25);
		checkButton.addActionListener(this);
		frame.add(checkButton);

		// Button that clears

		clearButton = new JButton("Clear");
		clearButton.setFocusable(false);
		clearButton.setBounds(90, 80, 80, 25);
		clearButton.addActionListener(this);
		frame.add(clearButton);

		// Label that displays the password

		passwordTextDisplayed.setBounds(125, 250, 1000, 35);
		passwordTextDisplayed.setFont(new Font(null, Font.ITALIC, 25));
		frame.add(passwordTextDisplayed);

		frame.setLayout(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		/**
		 * removes text and the message that was displayed notifying the user of the
		 * password strength
		 */
		if (e.getSource() == clearButton) {
			if (textArea.getText() != "") {
				textArea.setText("");
			}
			passwordText.setText("");
		}

		/**
		 * When check button is pressed, a message will be displayed notifying the user
		 * of the password strength
		 */
		if (e.getSource() == checkButton) {
			typedPassword = String.valueOf(passwordText.getPassword());

			if (typedPassword != null) {
				textArea.append(password.TesterCheckPassword(typedPassword));
			}

		}

	}

}
