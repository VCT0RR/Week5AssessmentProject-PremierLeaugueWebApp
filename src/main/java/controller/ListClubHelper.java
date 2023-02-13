/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Feb 12, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListClubs;

public class ListClubHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PremierLeagueWebApp");
	
	public void insertClub(ListClubs lc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListClubs> showAllClubs() {
		EntityManager em = emfactory.createEntityManager();
		List<ListClubs> allClubs = em.createQuery("SELECT i FROM ListClubs i").getResultList();
		return allClubs;
	}
	
	public void deleteClub(ListClubs toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListClubs>typedQuery = em.createQuery("select lc from ListClubs lc where lc.city "
				+ "= :selectedCity and lc.club = :selectedClub", ListClubs.class);
		
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedClub", toDelete.getClub());
		
		typedQuery.setMaxResults(1);
		
		ListClubs result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListClubs> searchForClubByCity(String cityName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListClubs>typedQuery = em.createQuery("select lc from ListClubs lc where lc.city "
				+ "= :selectedCity", ListClubs.class);
		typedQuery.setParameter("selectedCity", cityName);
		
		List<ListClubs> foundClubs = typedQuery.getResultList();
		em.close();
		return foundClubs;
	}
	
	public List<ListClubs> searchForClubByClub(String clubName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListClubs>typedQuery = em.createQuery("select lc from ListClubs lc where lc.club"
				+ "= :selectedClub", ListClubs.class);
		typedQuery.setParameter("selectedClub", clubName);
		
		List<ListClubs> foundClubs = typedQuery.getResultList();
		em.close();
		return foundClubs;
	}
	
	public ListClubs searchForClubById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListClubs found = em.find(ListClubs.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateClub(ListClubs toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}























