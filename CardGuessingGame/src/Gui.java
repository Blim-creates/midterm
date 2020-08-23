import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui implements ActionListener, ItemListener {

	public deckOfCards deck;

	//For creating the Gui
	Card backCard = new Card(100, 100, ImageIO.read(new File("images/b.gif")));
	JFrame window = new JFrame("Card Guesing Game!");
	JButton button = new JButton("Deal Next Card");
	JPanel contentPane = new JPanel(new BorderLayout());
	JPanel suitPanel = new JPanel(new BorderLayout());
	JPanel valuePanel = new JPanel(new BorderLayout());
	JLabel backImage = new JLabel(new ImageIcon(backCard.getCardImage()));
	JLabel cardImage;
	JLabel gameStats;
	ImageIcon imgIcon;
	JComboBox suitSelect;
	JComboBox valueSelect;

	
	int suit = 0; 
	int value = 1;
	int nextCard = 0; 
	int userCardRank = 1; 
	int win = 0; 
	int loss = 0; 
	int rmngCards = 52; 

	//Calling to launch Gui
	public Gui() throws IOException {

		deck = new deckOfCards();

		//shuffle deck
		deck.shuffle();


		System.out.println(deckOfCards.deck[nextCard].toString());

		//Creating window Panel
		contentPane.setBorder(BorderFactory.createEmptyBorder(40, 40, 20, 40));
		contentPane.setLayout(new GridLayout(3, 5, 60, 40));
		suitPanel.setLayout(new GridLayout(0, 1));
		valuePanel.setLayout(new GridLayout(0, 1));

		//Card image
		imgIcon = new ImageIcon();
		cardImage = new JLabel(imgIcon);

		//Creating game stats shown in window
		gameStats = new JLabel("<html>Welcome!<br>" + "Matched: " + win + "<br> Loser: " + loss + "<br>Cards Remaining: "
				+ rmngCards + "</html>");

		//Drop down box used with combo box for suit
		JLabel suitLabel = new JLabel("Select Your Suit");
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		suitSelect = new JComboBox(suits);

		//Drop down box used with combo box for value
		JLabel valueLabel = new JLabel("Select Your Value");
		String[] value = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
		valueSelect = new JComboBox(value);
		
		((JFrame) window).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);
		button.setSize(200, 300);

		//adding event listeners to combo box
		suitSelect.addItemListener(this);
		suitPanel.add(suitLabel);
		suitPanel.add(suitSelect);
		valueSelect.addItemListener(this);
		valuePanel.add(valueLabel);
		valuePanel.add(valueSelect);

		//Adding labels to panel
		contentPane.add(backImage);
		contentPane.add(gameStats);
		contentPane.add(cardImage);
		contentPane.add(valuePanel);
		contentPane.add(suitPanel);
		contentPane.add(button);

		//adding main panel to window frame
		window.add(contentPane, BorderLayout.NORTH);
		window.pack();
		window.setVisible(true);

	}

	public static void main(String[] args) throws IOException {

		new Gui();

	}

	//Event Listener when button is clicked
	//compare user card to top card on deck

	public void actionPerformed(ActionEvent e) {

		imgIcon.setImage(deckOfCards.deck[nextCard].getCardImage());
		cardImage.repaint();

		//Output if card doesn't match in console
		if (deckOfCards.deck[nextCard].getRank() == userCardRank) {

			System.out.println("It's a Match");
			rmngCards--;
			win++;
		}

		//Output if card matches in console
		else {
			System.out.println("Not Correct");
			rmngCards--;
			loss++;
		}

		gameStats.setText("<html>Hello!<br>" + "Wins: " + win + "<br> Loss: " + loss + "<br>Cards Left: " + rmngCards
				+ "</html>");
		nextCard++;
	}

	//getting the user card
	public void itemStateChanged(ItemEvent e) {

		suit = suitSelect.getSelectedIndex();
		value = valueSelect.getSelectedIndex() + 1;

		userCardRank = (suit * 13) + value;
	}
}
