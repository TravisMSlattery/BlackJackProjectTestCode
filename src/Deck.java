import java.util.*; // for ArrayList and Collections
import java.util.Random; //Random number generator utility


public class Deck {

	public ArrayList<Card> myCards = new ArrayList<Card>();

	public void Shoe() {
		this.myCards.clear();
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int[] rankValues = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		int numDecks;

		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		for (numDecks = 0; numDecks < 5; numDecks++){
			for (int i = 0; i < ranks.length; i++) {
				for (int j = 0; j < suits.length; j++) {
					this.myCards.add(new Card(ranks[i], suits[j], rankValues[i]));
				}
			}
		}
	}

	public Card takeCard() { // Removes card from top of card group's ArrayList
								// and returns it
		if (this.myCards.size() < 1) {
			System.out.println("Error: no more cards!");
			System.exit(0);
		}
		Card tempCard = this.myCards.get(this.myCards.size() - 1);
		this.myCards.remove(this.myCards.size() - 1);
		return tempCard;
	}

	public void shuffle() {
		Random rng = new Random(); // Seed for random class
		Collections.shuffle(this.myCards, rng); // Swapping a randomly selected element into the "current position"
	}

	public int getTotalValue() {
		int totalValue = 0;
		for (int i = 0; i < this.myCards.size(); i++)
			totalValue += this.myCards.get(i).value;
		return totalValue;
	}

	public int getNumAces() {
		int numAces = 0;
		for (int i = 0; i < this.myCards.size(); i++)
			if (this.myCards.get(i).rank == "Ace")
				numAces++;
		return numAces;
	}

	public int getCount() {
		return this.myCards.size();
	}

	public void printDeck() {
		for (int i = 0; i < this.myCards.size(); i++) {
			this.myCards.get(i).print();
		}
	}

	@Override
	public String toString() {
		return "Deck{" +
				"myCards=" + myCards +
				'}';
	}
}
