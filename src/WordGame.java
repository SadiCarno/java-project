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

	private JButton btnNewGame;
	private JButton btnCheck;
	private JTextField usersWord;
	private JLabel lblOutput;
	private static JLabel lblLetterPlaces;
	private char letter;
	
	public char newGame() {
		Random var = new Random();
		letter = (char) (65 + var.nextInt(26));  //65 is 'A' in char
		lblLetterPlaces.setText("Your letter is " + letter);
		return letter;
	}
	
	public void checkResult() {
		String stdIn = usersWord.getText();
		String message = "";
		char[] enterWord= stdIn.toCharArray();  //convert users word to check out
		lblLetterPlaces.setText("Your letter is " + letter);
		try {	
			for(int i = 0; i < enterWord.length; ++i) {
				Boolean numberFlag = Character.isDigit(enterWord[i]);
				if (numberFlag) {
					message = "Error. Wrong input. Try again.";
				} else if (enterWord[0] != letter) {
					message = "Error. Wrong input. Try again.";
				} else {
					message = "Nicely done! Let's play again!";
					btnNewGame.setVisible(true);
				}
			}
		} catch (Exception wrongWord) {
			message = "Error. Wrong input. Try again.";
		} finally {
			lblOutput.setText(message);
			usersWord.selectAll();
			newGame();
		}
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
		usersWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent enterWord) {
				checkResult();
			}
		});
		usersWord.setHorizontalAlignment(SwingConstants.LEFT);
		usersWord.setBounds(289, 108, 157, 23);
		getContentPane().add(usersWord);
		usersWord.setColumns(10);

		btnCheck = new JButton("Check result");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent checkWord) {
				checkResult();
			}
		});

		btnCheck.setBounds(289, 163, 143, 25);
		getContentPane().add(btnCheck);
		
		btnNewGame = new JButton("New game");
		btnNewGame.setVisible(false);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent startNewGame) {
				newGame();
			}
		});
		btnNewGame.setBounds(81, 163, 130, 25);
		getContentPane().add(btnNewGame);
	}
}
