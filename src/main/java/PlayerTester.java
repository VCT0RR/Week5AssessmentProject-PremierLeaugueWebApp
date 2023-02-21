import java.util.List;

import controller.PlayerHelper;
import model.Player;

/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 16, 2023
 */

public class PlayerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player haaland = new Player("Haaland");
		Player casemiro = new Player("Casemiro");

		PlayerHelper ph = new PlayerHelper();

		ph.insertPlayer(haaland);
		ph.insertPlayer(casemiro);
		
		List<Player> allPlayers = ph.showAllPlayers();
		for(Player a : allPlayers) {
			System.out.println(a.toString());
		}

	}

}
