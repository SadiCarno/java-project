import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordGame extends JFrame {

	private JTextField usersWord;
	private JLabel lblOutput;
	private JLabel lblLetterPlaces;

	public void checkResult() {
		String stdIn = usersWord.getText();
		String message = "";
		lblLetterPlaces.setText("");
		try { //needs to be refined
			if (stdIn == null)
			message = "";
			else
			message = "Nicely done! Let's play again!";
			newGame();
		}
		catch (Exception e) {
			message = "Enter a word with your letter.";
		} finally {
			lblOutput.setText(message);
			usersWord.selectAll();
		}
	}

	public void newGame() {//generate number
		Random var = new Random();
		char letter = (char) (65 + var.nextInt(26));//65 is 'A' in char;
		lblLetterPlaces.setText("Your letter is " + letter);
	}

	public static void main(String[] args) {
		WordGame currentGame = new WordGame();
		currentGame.newGame();
		currentGame.setSize(new Dimension(500,350));
		currentGame.setVisible(true);



	}
	public WordGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Word Game");
		getContentPane().setLayout(null);

		JLabel lblWordGame = new JLabel("Word Game");
		lblWordGame.setBounds(12, 12, 476, 23);
		lblWordGame.setFont(new Font("Source Han Sans KR Medium", Font.BOLD, 15));
		lblWordGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblWordGame);

		lblLetterPlaces = new JLabel("A letter places");
		lblLetterPlaces.setBounds(12, 59, 476, 23);
		lblLetterPlaces.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblLetterPlaces);

		JLabel lblThinkOfA = new JLabel("Think of a word with the letter:");
		lblThinkOfA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThinkOfA.setBounds(36, 108, 251, 23);
		getContentPane().add(lblThinkOfA);

		lblOutput = new JLabel("Enter a word with your letter.");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(12, 229, 476, 15);
		getContentPane().add(lblOutput);

		usersWord = new JTextField();
		usersWord.setHorizontalAlignment(SwingConstants.LEFT);
		usersWord.setBounds(289, 108, 157, 23);
		getContentPane().add(usersWord);
		usersWord.setColumns(10);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent word) {
				checkResult();
			}
			
		});
		btnNewGame.setBounds(192, 166, 117, 25);
		getContentPane().add(btnNewGame);
	}


}
