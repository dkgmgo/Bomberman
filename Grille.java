import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Grille {
	private int[][] grille = new int[19][13];
	private Image image_vide, image_obstacle_1, image_obstacle_2;
	
	public Grille() throws SlickException {
		image_vide = new Image("images/vide.png");
		image_obstacle_2 = new Image("images/obstacle_indestructible.png");
		image_obstacle_1 = new Image("images/obstacle_destructible.png");
		for(int i=0; i<19; i++) {
			for(int j =0; j<13; j++) {
				if(i==0 || i == 18 || j == 0 || j == 12) {
					grille[i][j] = 2;
				}
				else if(i%2 == 0 && j%2 == 0) {
					grille[i][j] = 2;
				}
				else if(i==1 && j==1 || i==1 && j==2 || i==2 && j==1 || i==17 && j==10 || i==17 && j==11 || i==16 && j==11 || i==3 && j==3 || i==3 && j==1 || i==1 && j==3 || i==3 && j==2) {
					grille[i][j] = 0;
				}
				else {
					grille[i][j] = (int)(Math.random() * 2);
				}
			}
		}
	}
	
	public void dessiner(Graphics g) {
		for(int i=0; i<19; i++) {
			for(int j =0; j<13; j++) {
				if(grille[i][j] == 0) {
					g.drawImage(image_vide, i*30, j*30);
				}
				else if(grille[i][j] == 1) {
					g.drawImage(image_obstacle_1, i*30, j*30);
				}
				else if(grille[i][j] == 2) {
					g.drawImage(image_obstacle_2, i*30, j*30);
				}
			}
		}
	}
	
	public int typeCase(int i, int j) {
		int s = 0;
		if(grille[i][j] == 0) {
			s =0;
		}
		else if(grille[i][j] == 1) {
			s =1;
		}
		else if(grille[i][j] == 2) {
			s =2;
		}
		return s;
	}
	
	public void effetBombe(int x, int y) {
		if(grille[x][y] == 0) {
			grille[x][y] = 0;
		}
		else if(grille[x][y] == 1) {
			grille[x][y] = 0;
		}
		else if(grille[x][y] == 2) {
			grille[x][y] = 2;
		}
	}
}
