/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 12, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clubs")
public class ListClubs {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="CITY")
	private String city;
	@Column(name="CLUB")
	private String club;
	@Column(name="CLUBMANAGER")
	private String teamManager;
	@Column(name="FOOTBALLRANKING")
	private String footballRanking;

	public ListClubs() {
		super();
	}
	
	public ListClubs(String city, String club, String teamManager, String footballRanking) {
		super();
		this.city = city;
		this.club = club;
		this.teamManager = teamManager;
		this.footballRanking = footballRanking;
	}
	
	public ListClubs(String teamManager, String footballRanking) {
		super();
		this.teamManager = teamManager;
		this.footballRanking = footballRanking;
	}

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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the club
	 */
	public String getClub() {
		return club;
	}

	/**
	 * @param club the club to set
	 */
	public void setClub(String club) {
		this.club = club;
	}

	/**
	 * @return the teamManager
	 */
	public String getTeamManager() {
		return teamManager;
	}

	/**
	 * @param teamManager the teamManager to set
	 */
	public void setTeamManager(String teamManager) {
		this.teamManager = teamManager;
	}

	/**
	 * @return the footballRanking
	 */
	public String getFootballRanking() {
		return footballRanking;
	}

	/**
	 * @param footballRanking the footballRanking to set
	 */
	public void setFootballRanking(String footballRanking) {
		this.footballRanking = footballRanking;
	}
	
	public String returnClubDetails() {
		return this.city + ": " + this.club + ": " + 
				 this.teamManager + ": " + this.footballRanking;
	}

}
