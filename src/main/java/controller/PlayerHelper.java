/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 16, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class PlayerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PremierLeagueWebApp");
	
	public void insertPlayer(Player p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT p FROM Player p").getResultList();
		return allPlayers;
	}
	
	public Player findPlayer(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select ph from Player ph where ph.playerName = :selectedName", Player.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Player foundPlayer;
		
		try {
			foundPlayer = typedQuery.getSingleResult();
		} catch(NoResultException ex) {
			foundPlayer = new Player(nameToLookUp);
		}
		em.close();
		
		return foundPlayer;
	}

}
