package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListClubs;

/**
 * Servlet implementation class AddClubServlet
 */
@WebServlet("/addClubServlet")
public class AddClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = request.getParameter("city");
		String club = request.getParameter("club");
		String teamManager = request.getParameter("teamManager");
		String footballRanking = request.getParameter("footballRanking");
		
		ListClubs lc = new ListClubs(city, club, teamManager, footballRanking);
		ListClubHelper dao = new ListClubHelper();
		dao.insertClub(lc);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
