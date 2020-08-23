import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import guessCardGame.Card;

public class deckOfCards {
	public static Card[] deck;

	//calling on a deck of cards method
	public deckOfCards() throws IOException {

		//deck array of 52 cards
		deck = new Card[52];

		int deckNum = 0;
		int deckImage = 1;

		for (int i = 0; i < 4; i++) { 

			for (int j = 1; j < 14; j++) { 

				// creating card object
				deck[deckNum] = new Card(j, i, ImageIO.read(new File("images/" + deckImage + ".gif")));
				deckNum++;
				deckImage++;
			}
		}
	}

	// shuffle method 
	public void shuffle() {
		int deckLength = deck.length - 1;

		for (int i = 0; i < deckLength; i++) {
			int r = i + (int) (Math.random() * (deckLength - i));
			Card temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
	}

	// method to deal top card
	public int dealTopCard() {
		int topCard = -1;

		if (deck.length > 0) {
			topCard++;
			return deck[topCard].getRank();

		} else {
			return 0;
		}
	}
}
