package mini_tennis;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * What is this file doing? It controls anything that the Pong does, movement, speed, collision, sound ,direction etc. 
 * 0.) Connecting to the Main class
 * 1.) Movement
 * 2.) Speed & Direction
 * 3.) Collision
 * 4.) Sound
 */

public class Pong {

	   private static final int DIAMETER = 30;
	
		int x = 0;
		int y = 0;
		

		int xa = 1; 
		int ya = 1;

		
		// 0.) Connecting to the Main class
		private Main game;
		
		public Pong (Main game){
			this.game = game;
		}
		
		// 1.) Movement , You need to throw the MalformURLException for the url connection to work.
		 
		public void movePong() throws MalformedURLException{
			boolean changeDirection = true;
		// 2,3,and 4 .) Speed & Direction, Collision, Sound , Determines the Diameter of the Pong and the speed of which the Pong is going if
			// Collision of the Pong happens change the direction and speed. Once the collison occurs or Direction changes the PongURL sound activates.
			if (x + xa < 0)
				xa = game.speed; 
			else if (x + xa > game.getWidth() - DIAMETER)
				xa = -game.speed; 
			else if (y + ya < 0)
				ya = game.speed; 
			else if (y + ya > game.getHeight() - DIAMETER)
				game.gameOver();
			

			else if (collision()){
				ya = -game.speed;
				y = game.racquet.getTopY() - DIAMETER;
				game.speed++;
			}else{
				changeDirection = false;
			}
			if (changeDirection){
				//plays sound
				 URL PongUrl = new URL("http://www.shockwave-sound.com/sound-effects/explosion-sounds/boom.wav");
				 AudioClip Pong = Applet.newAudioClip(PongUrl);
				 Pong.play();
			}
			
			x = x + xa;
			y = y + ya;
		}
		
		// 2.) Speed & Direction if Collison occures the direction and change changes as well.
		private boolean collision() {
			return game.racquet.getBounds().intersects(getBounds());
		}
     
		public void paint(Graphics2D g) {
			g.fillOval(x, y, DIAMETER, DIAMETER);
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, DIAMETER, DIAMETER);
		}
		
}
