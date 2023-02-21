package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListClubs;
import model.ListDetails;
import model.Player;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ListClubHelper lch = new ListClubHelper();
    	String listName = request.getParameter("listName");
    	System.out.println("List Name: "+ listName);
    	
    	String month = request.getParameter("month");
    	String day = request.getParameter("day");
    	String year = request.getParameter("year");
    	String playerName = request.getParameter("playerName");

    	LocalDate ld;
    	
    	try{
    		ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    	}catch(NumberFormatException ex) {
    		ld = LocalDate.now();
    	}
    	
    	String[] selectedClubs = request.getParameterValues("allClubsToAdd");
    	List<ListClubs> selectedClubsInList = new ArrayList<ListClubs>();
    	
    	if (selectedClubs != null && selectedClubs.length > 0) {
    		
    		for(int i = 0; i < selectedClubs.length; i++) {
    			System.out.println(selectedClubs[i]);
    			ListClubs c = lch.searchForClubById(Integer.parseInt(selectedClubs[i]));
    			selectedClubsInList.add(c);
    			}
    		}
    	Player player = new Player(playerName);
    	ListDetails sld = new ListDetails(listName, ld, player);
    	
    	sld.setListOfClubs(selectedClubsInList);
    	ListDetailsHelper slh = new ListDetailsHelper();
    	slh.insertNewListDetails(sld);
    	
    	System.out.println("Success!");
    	System.out.println(sld.toString());
    	
    	getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
