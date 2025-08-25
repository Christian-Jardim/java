package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame windown = new JFrame ();
		windown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windown.setResizable(true);
		windown.setTitle("2D Adventure");
		
		GamePanel panel = new GamePanel ();
		windown.add(panel);
		windown.pack();
		
		windown.setLocationRelativeTo(null);
		windown.setVisible(true);
	}
}