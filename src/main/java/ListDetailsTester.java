import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListClubs;
import model.ListDetails;
import model.Player;

/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 20, 2023
 */

public class ListDetailsTester {

	public static void main(String[] args) {
		
		Player rashford = new Player("Rashford");
		Player grealish = new Player("Grealish");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListClubs manCity = new ListClubs("Manchester", "Manchester City", "Pep Guardiola", "2");
		ListClubs manUtd = new ListClubs("Manchester", "Manchester United", "Erik ten Hag", "3");
		
		List<ListClubs> rashfordsClub = new ArrayList<ListClubs>();
		List<ListClubs> grealishClub = new ArrayList<ListClubs>();
		rashfordsClub.add(manUtd);
		grealishClub.add(manCity);
		
		ListDetails abhisList = new ListDetails("Abhi's PL Club List", LocalDate.now(), rashford);
		abhisList.setListOfClubs(rashfordsClub);
		ListDetails ryansList = new ListDetails("Ryan's PL Club List", LocalDate.now(), grealish);
		ryansList.setListOfClubs(grealishClub);

		
		ldh.insertNewListDetails(abhisList);
		ldh.insertNewListDetails(ryansList);
		
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}
}
