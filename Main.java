import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

		public static void main(String[] args) throws SlickException {
			// TODO Auto-generated method stub
			AppGameContainer app = new AppGameContainer(new Bomberman("Bomberman"));
			app.setShowFPS(false);
			app.start();
		}
	}
