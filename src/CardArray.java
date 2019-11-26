import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class CardArray extends JPanel {
	
	// This class extends JPanel, and will create a panel which displays the images of a number of cards,
	// stored in an instance of CardGroup, next to each other. Additionally the card total is displayed using standard Ace subtraction rule.

	CardArray(Deck deck, int left, int top, int width, int height, int gap) {

		int numCards = deck.myCards.size();

		setBounds(left, top, 35 + numCards * (width + gap), height);
		setLayout(null);
		setOpaque(false); // for transparent background

		int total = deck.getTotalValue();
		if (total > 21 && deck.getNumAces() > 0)
			total -= 10;

		JLabel playerScoreLbl = new JLabel((total == 21 ? "BJ" : total) + "");
		playerScoreLbl.setForeground(Color.WHITE);
		playerScoreLbl.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		playerScoreLbl.setVerticalAlignment(SwingConstants.CENTER);
		playerScoreLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		playerScoreLbl.setBounds(0, 0, 30, height);
		add(playerScoreLbl);

		for (int i = 0; i < numCards; i++) {
			GameWindow.ImagePanel cardImagePanel = new GameWindow.ImagePanel(deck.myCards.get(i).getFileName());
			cardImagePanel.setBounds(35 + i * (width + gap), 0, width, height);
			add(cardImagePanel);
		}
	}
}