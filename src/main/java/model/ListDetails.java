/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 20, 2023
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id; //club id
	private String listName; //name of the list for the premier league club
	private LocalDate dateAdded; //added date of player
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Player player; //player name for the premier league club
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListClubs> listOfClubs; //4 parameters required for ListClubs

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the dateAdded
	 */
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the listOfClubs
	 */
	public List<ListClubs> getListOfClubs() {
		return listOfClubs;
	}

	/**
	 * @param listOfClubs the listOfClubs to set
	 */
	public void setListOfClubs(List<ListClubs> listOfClubs) {
		this.listOfClubs = listOfClubs;
	}

	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(int id, String listName, LocalDate dateAdded, Player player, List<ListClubs> listOfClubs) {
		this.id = id;
		this.listName = listName;
		this.dateAdded = dateAdded;
		this.player = player;
		this.listOfClubs = listOfClubs;
	}
	
	public ListDetails(String listName, LocalDate dateAdded, Player player, List<ListClubs> listOfClubs) {
		this.listName = listName;
		this.dateAdded = dateAdded;
		this.player = player;
		this.listOfClubs = listOfClubs;
	}
	
	public ListDetails(String listName, LocalDate dateAdded, Player player) {
		this.listName = listName;
		this.dateAdded = dateAdded;
		this.player = player;
	}
	
	public String toString() {
		return "[id=" + id + ", listName=" + listName + ", dateAdded=" + dateAdded + ", player=" + player + ", listOfClubs=" + listOfClubs + "]";
	} 

}
