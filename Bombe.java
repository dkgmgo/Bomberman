import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bombe {
	private int x, y;
	private Image image;
	private float temps;
	
	public Bombe(int x, int y) throws SlickException {
		if(x>=0 && x<=18 && y>=0 && y<=12) {
			this.x = x;
			this.y = y;
		}
		image = new Image("images/bombe.png");
		temps = 0;
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(image, x*30, y*30);
	}
	
	public boolean doitExploser(int delta) {
		boolean b = false;
		temps+= delta;
		if(temps>=2000)
			b = true;
		else
			b = false;
		return b;
	}
	
	public void exploser(Grille g) {
		g.effetBombe(x-1, y);
		g.effetBombe(x+1, y);
		g.effetBombe(x, y+1);
		g.effetBombe(x, y-1);
		g.effetBombe(x, y);
	}
	
	public boolean exploser(Personnage p) {
		boolean b = false;
		if(p.proche(x, y)) {
			b = true;
		}
		return b;
	}
	
	
}
