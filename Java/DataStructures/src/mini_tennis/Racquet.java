package mini_tennis;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/*
 * What does this file do? This file controls the racquet's movement, direction (left and right)
 * 1.) movement speed
 * 2.) Direction
 * */

public class Racquet {

	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0; 
	int xa = 0; 	
	private Main game;
	
	
	public Racquet(Main game) {
		this.game= game;
	}
// 1.) movement speed
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()- WIDTH)
			x = x + xa;
	}
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	
// 2.) Direction
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = game.speed;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
	public int getTopY(){
		return Y;
	}
}