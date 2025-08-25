package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	final int size = 16;
	final int scale = 5;
	final int tile_size = size * scale;
	final int screen_col = 4;
	final int screen_row = 3;
	final int screen_width = tile_size * screen_col;
	final int screen_height = tile_size * screen_row;
	
	Thread game_thread;
	
	public GamePanel () {
		this.setPreferredSize(new Dimension(screen_width, screen_height));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}

	public void start_game_thread () {
		game_thread = new Thread (this);
		game_thread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}