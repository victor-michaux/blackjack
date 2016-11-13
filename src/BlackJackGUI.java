import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

import javafx.scene.layout.Border;

public class BlackJackGUI {

	private BlackJack blackJack;

	private JPanel playerPanel;
	private JPanel bankPanel;

	private JButton anotherCard;
	private JButton noMoreCard;
	private JButton reset;

	public BlackJackGUI() {
		JFrame frame = new JFrame("BlackJack GUI");
		frame.setMinimumSize(new Dimension(640, 480));

		this.blackJack = new BlackJack();
		
		JPanel topPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		this.bankPanel = new JPanel();
		this.playerPanel = new JPanel();
		
		frame.setLayout(new BorderLayout());
		
		topPanel.setLayout(new GridLayout(1, 3));
		
		this.bankPanel.setBorder(BorderFactory.createTitledBorder("Bank"));
		this.playerPanel.setBorder(BorderFactory.createTitledBorder("Player"));
		
		this.anotherCard = new JButton("Another Card");
		this.noMoreCard = new JButton("No More Card");
		this.reset = new JButton("Reset");

		this.anotherCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					blackJack.playerDrawAnotherCard();
					System.out.println(blackJack.getPlayerHandString());
					updatePlayerPanel();
					if(blackJack.isGameFinished()) {
						anotherCard.setEnabled(false);
						noMoreCard.setEnabled(false);
					}
				} catch(EmptyDeckException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				} catch (FileNotFoundException exception) {
					exception.printStackTrace();
				}
			}
		});

		this.noMoreCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					blackJack.bankLastTurn();
					updateBankPanel();
					if(blackJack.isGameFinished()) {
						anotherCard.setEnabled(false);
						noMoreCard.setEnabled(false);
					}
				} catch(EmptyDeckException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				} catch (FileNotFoundException exception) {
					exception.printStackTrace();
				}
			}
		});

		this.reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					blackJack.reset();
					updateBankPanel();
					updatePlayerPanel();
				} catch(EmptyDeckException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					System.exit(-1);
				} catch (FileNotFoundException exception) {
					exception.printStackTrace();
				}
				anotherCard.setEnabled(true);
				noMoreCard.setEnabled(true);
			}
		});
		
		topPanel.add(this.anotherCard);
		topPanel.add(this.noMoreCard);
		topPanel.add(this.reset);
		
		centerPanel.setLayout(new GridLayout(2, 1));
		centerPanel.add(this.bankPanel);
		centerPanel.add(this.playerPanel);

		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);

		try{
			updatePlayerPanel();
			updateBankPanel();
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.pack();
		frame.setVisible(true);
		
	}

	private void addToPanel(JPanel p, String token) throws FileNotFoundException{
		File file = new File("./src/img/card_" + token + ".gif");
		if (!file.exists()) {
			throw new FileNotFoundException("Can't find "+file.getPath());
		}
		ImageIcon icon = new ImageIcon(file.getPath()); // Create the image from the filename
		JLabel label = new JLabel(icon); // Associate the image to a label
		p.add(label); // Add the label to a panel
	}

	private void updatePlayerPanel()throws FileNotFoundException {
		this.playerPanel.removeAll();
		for(Card card: this.blackJack.getPlayerCardList()) {
			String token = card.getColorSymbole() + "_" + card.getValueSymbole();
			addToPanel(this.playerPanel, token.toLowerCase());
		}
		this.playerPanel.add(new JLabel("Player Best : " + this.blackJack.getPlayerBest()));
		this.playerPanel.updateUI();
	}

	private void updateBankPanel()throws FileNotFoundException {
		this.bankPanel.removeAll();
		for(Card card: this.blackJack.getBankCardList()) {
			String token = card.getColorSymbole() + "_" + card.getValueSymbole();
			addToPanel(this.bankPanel, token.toLowerCase());
		}
		this.bankPanel.add(new JLabel("Bank Best : " + this.blackJack.getBankBest()));
		this.bankPanel.updateUI();
	}
	
	public static void main(String[] args) {
		new BlackJackGUI();
	}
}
