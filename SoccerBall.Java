package Sanbox;

import zen.core.Zen;
import zen.game.Game;
import zen.shape.Line;

public class GameExample extends Game {

	SoccerBall b;
	Foot f;
	Foot opponent;
		
	public static void main(String[] args) {
		Zen.connect();
		GameExample g; // Make a variable to restore this game
		g = new GameExample(); // Create the game
		g.run();
	}

	@Override
	public void setup() {
		
		b = new SoccerBall();
		b.set(250,250);
		addSprite(b);
		
		f = new Foot();
		f.followMouse = true;
		f.set(300,300);
		addSprite(f);
		
		opponent = new Foot();
		addSprite(opponent);
	}

	@Override
	public void loop() {
		Zen.setBackground("green");
		Zen.setColor("white");
		Zen.fillRect(20, 20, 460, 5);
		Zen.fillRect(20, 20, 460, 5);
		
		Zen.write("anishx", f.getX());
		Zen.write("anishy", f.getY());
		
		opponent.setX(Zen.readInt("keshavx") );
		opponent.setY(Zen.readInt("keshavy") );
		
		
		if (Zen.isKeyPressed("space")) {
			Line l = new Line(b, f);
			int angle = (int) Math.toDegrees(l.angle());
			b.rotateTo(angle);
			if (b.getX() > 25 && b.getX() < 475 && b.getY() > 25 && b.getY() < 475) {
			b.move(-400 / b.distanceTo(f));
			}
			else {
				b.move(5);
			}
		}	
	}

	@Override
	public void background() {
		// TODO Auto-generated method stub
		
	}

}
