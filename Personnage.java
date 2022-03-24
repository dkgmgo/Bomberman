import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Personnage {
	private int x, y;
	private Image image;
	
	public Personnage(int x, int y) throws SlickException {
		image = new Image("images/bomberman.png");
		this.x = x;
		this.y = y;
	}
	
	public void gauche(Grille g) {
		if(g.typeCase(x-1,y) == 0) {
			x--;
		}
	}
	
	public void droite(Grille g) {
		if(g.typeCase(x+1,y) == 0) {
			x++;
		}
	}
	
	public void bas(Grille g) {
		if(g.typeCase(x,y+1) == 0) {
			y++;
		}
	}
	
	public void haut(Grille g) {
		if(g.typeCase(x,y-1) == 0) {
			y--;
		}
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(image, x*30, y*30);
	}
	
	public boolean proche(int i, int j) {
		boolean b = false;
		if(x==i-1 && y==j || x==i+1 && y ==j || x==i && y==j-1 || x==i && y==j+1 || x==i && y==j)
			b = true;
		return b;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
