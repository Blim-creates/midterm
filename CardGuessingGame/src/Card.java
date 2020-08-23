import java.awt.image.BufferedImage;

//creating the Card Object
public class Card {
//properties for suits
	public final static int 
		SPADES = 0, 
		HEARTS = 1, 
		DIAMONDS = 2, 
		CLUBS = 3;

	public final static int 
		ACE = 1,
		JACK = 11,
		QUEEN = 12,
		KING = 13;

	//The suit is one of the 4 
	private final int suit; 					

	//Value 1 through 14
	private final int value; 

	//card image
	private BufferedImage cardImage;

	//creating a card constructor 
	public Card(int theValue, int theSuit, BufferedImage card) 
	{
		value = theValue;
		suit = theSuit;
		cardImage = card;
	}

	public int getSuit() 
	{
		// Returns the card int suit
		return suit;
	}

	public int getValue() 
	{
		// Return the int for card value
		return value;
	}

	// returns int of card rank
	public int getRank() 
	{
		return (getSuit() * 13) + getValue();
	}

	// returns card object image
	public BufferedImage getCardImage() 
	{

		return cardImage;
	}
	
	// Return a String representing the card's suit.
	public String getSuitAsString() 
	{
		switch (suit) {
		case SPADES:
			return "Spades";
		case HEARTS:
			return "Hearts";
		case DIAMONDS:
			return "Diamonds";
		case CLUBS:
			return "Clubs";
		default:
			return "??";
		}
	}
	
	// Return a String representing the card's value.
	public String getValueAsString() 
	{
		
		switch (value) 
		{
		case 1:
			return "Ace";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return "??";
		}
	}

	// Return a String representation of this card
	public String toString() 
	{
		return getValueAsString() + " of " + getSuitAsString();
	}
}