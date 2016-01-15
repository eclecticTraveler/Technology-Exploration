package mini_tennis;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * What does this file do? This file is the Main which runs both the Pong.java and the Racquet.java 
 * It listens to keys , connect with Pong and Racquet. This is also where you would repaint the Pong and Racquet. And lastly this is where the Game loop is played and where the Threading and Frame is stored.
 * 1.) Key listener
 * 2.) Connecting to Pong and Raquet
 * 3.) Repaint
 * 4.) Sound
 * 5.) Frame
 * 6.) Game Loop
 * */

@SuppressWarnings("serial")
public class Main extends JPanel{	
	
	//2.) Connecting To Pong and Racquet
	Pong ball = new Pong(this);
	Racquet racquet = new Racquet(this);
	int speed = 1;
	
	private int getScore() {
		return speed - 1;
	}
	
	//1.) key listener
	public Main() throws MalformedURLException {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	
	private void move() throws Exception{
		ball.movePong();
		racquet.move();
	}
	
	
	//3.) repaint
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}
	
	//4.) Sound
	 URL BackUrl = new URL("http://www.wav-sounds.com/vehicle/jetplanef16.wav");
	 AudioClip BACK = Applet.newAudioClip(BackUrl);
	 public void gameOver() throws MalformedURLException {
	 BACK.stop();		
		URL GameOverUrl = new URL("http://www.wav-sounds.com/funny/tara.wav");
		AudioClip GAMEOVER = Applet.newAudioClip(GameOverUrl);
		GAMEOVER.play();
		
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	// Frame
	public static void main(String[] args) throws Exception{	
				
		// Creates the Frame Border (window)
		JFrame frame = new JFrame("Mini Tennis"); 		
		Main game = new Main();
		frame.add(game);		
		frame.setSize(300,400);
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		

	// Game Loop	
		// Repaints the Ball and racket
		while (true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
