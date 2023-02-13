package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListClubs;

/**
 * Servlet implementation class EditClubServlet
 */
@WebServlet("/editClubServlet")
public class EditClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListClubHelper dao = new ListClubHelper();
		
		String city = request.getParameter("city");
		String club = request.getParameter("club");
		String teamManager = request.getParameter("teamManager");
		String footballRanking = request.getParameter("footballRanking");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListClubs clubToUpdate = dao.searchForClubById(tempId);
		clubToUpdate.setClub(club);
		clubToUpdate.setCity(city);
		clubToUpdate.setTeamManager(teamManager);
		clubToUpdate.setFootballRanking(footballRanking);
		
		dao.updateClub(clubToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllClubsServlet").forward(request, response);
	}

}
