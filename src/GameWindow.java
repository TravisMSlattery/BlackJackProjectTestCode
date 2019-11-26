import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
	
	//The main window, displays the background image (note the dynamic boundaries are so the image stretches nicely for a given window size)

	GameWindow() {
		setTitle("M.T Pockets Blackjack");
		setSize(900, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		//setIconImage("casino.ico");
		
		ImagePanel bgImagePanel = new ImagePanel("background.png");

		bgImagePanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		setContentPane(bgImagePanel);
	}
	static class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(String imgStr) { // Constructor, passed image string
			this.img = new ImageIcon(imgStr).getImage();
			Dimension size = new Dimension(img.getWidth(null), img.getHeight(null)); // If we don't use setBounds (after instance is created), this is a fallback to the actual dimensions of the image
			setSize(size);
			setLayout(null);
		}

		public void paintComponent(Graphics g) { // Draw the image to the JPanel
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		}
	}

}
