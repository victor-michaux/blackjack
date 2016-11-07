import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BlackJackGUI();
	}
}
