import java.util.ArrayList;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Bomberman extends BasicGame {
	private Grille g;
	private Personnage p, p2;
	private ArrayList<Bombe> b = new ArrayList<Bombe>();
	private boolean message, message2;
	private int temps;

	public Bomberman(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		g.dessiner(arg1);
		for (int i = 0; i < b.size(); i++) {
			b.get(i).dessiner(arg1);
		}
		if (p != null)
			p.dessiner(arg1);
		if (message == true)
			arg1.drawString("Joueur 1 Eliminé", 10, 400);
		if (p2 != null)
			p2.dessiner(arg1);
		if (message2 == true)
			arg1.drawString("Joueur 2 Eliminé", 10, 430);
		if(message == true && message2 == true)
			arg1.drawString("Fin de Partie", 10, 460);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		message = message2 = false;
		temps = 0;
		g = new Grille();
		p = new Personnage(1, 1);
		p2 = new Personnage(3, 3);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input inp = arg0.getInput();
		if (p != null) {
			if (inp.isKeyPressed(Input.KEY_UP))
				p.haut(g);
			else if (inp.isKeyPressed(Input.KEY_DOWN))
				p.bas(g);
			else if (inp.isKeyPressed(Input.KEY_RIGHT))
				p.droite(g);
			else if (inp.isKeyPressed(Input.KEY_LEFT))
				p.gauche(g);
			if (inp.isKeyPressed(Input.KEY_NUMPAD9) && b.size() == 0) {
				Bombe boom = new Bombe(p.getX(), p.getY());
				b.add(boom);
			}
		}
		if (p2 != null) {
			if (inp.isKeyPressed(Input.KEY_Z))
				p2.haut(g);
			else if (inp.isKeyPressed(Input.KEY_S))
				p2.bas(g);
			else if (inp.isKeyPressed(Input.KEY_D))
				p2.droite(g);
			else if (inp.isKeyPressed(Input.KEY_Q))
				p2.gauche(g);
			if (inp.isKeyPressed(Input.KEY_F) && b.size() == 0) {
				Bombe boom2 = new Bombe(p2.getX(), p2.getY());
				b.add(boom2);
			}
		}
		for (int i = 0; i < b.size(); i++) {
			if (b.get(i).doitExploser(arg1)) {
				b.get(i).exploser(g);
				if (p != null && b.get(i).exploser(p)) {
					p = null;
					message = true;
				}
				if (p2 != null && b.get(i).exploser(p2)) {
					p2 = null;
					message2 = true;
				}
				b.remove(i);
			}
		}
		if(message == true && message2 == true) {
			temps += arg1;
			if(temps == 3000)
				arg0.exit();
		}
	}
}
