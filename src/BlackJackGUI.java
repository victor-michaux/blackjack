import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

import javafx.scene.layout.Border;

public class BlackJackGUI {
	public BlackJackGUI() {
		JFrame frame = new JFrame("BlackJack GUI");
		frame.setMinimumSize(new Dimension(640, 480));
		
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		JPanel bankPanel = new JPanel();
		JPanel playerPanel = new JPanel();
		
		frame.setLayout(new BorderLayout());
		
		topPanel.setLayout(new GridLayout(1, 3));
		
		bankPanel.setBorder(BorderFactory.createTitledBorder("Bank"));
		playerPanel.setBorder(BorderFactory.createTitledBorder("Player"));
		
		JButton anotherCard = new JButton("Another Card");
		JButton noMoreCard = new JButton("No More Card");
		JButton reset = new JButton("Reset");
		
		topPanel.add(anotherCard);
		topPanel.add(noMoreCard);
		topPanel.add(reset);
		
		centerPanel.setLayout(new GridLayout(2, 1));
		centerPanel.add(bankPanel);
		centerPanel.add(playerPanel);

		try{
			addToPanel(playerPanel, "CLUB_j".toLowerCase());
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);


		
	}

	private void addToPanel(JPanel p, String token) throws FileNotFoundException{
		File file = new File("./img/card_" + token + ".gif");
		System.out.println(file.getPath());
		ImageIcon icon = new ImageIcon(file.getPath()); // Create the image from the filename
		JLabel label = new JLabel(icon); // Associate the image to a label
		p.add(label); // Add the label to a panel
	}
	
	public static void main(String[] args) {
		new BlackJackGUI();
	}
}
