package project02_Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoviesDAO;
import dto.MoviesDTO;

/**
 * Servlet implementation class movieServlet
 */
@WebServlet("*.movies")
public class movieController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		MoviesDAO dao = MoviesDAO.getInstance();
		System.out.println(cmd);
		if(cmd.equals("/input.movies")) {
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			System.out.println(title+":"+genre);
			MoviesDTO movie = new MoviesDTO(title, genre);
			try {
				int result = dao.insert(movie);
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(cmd.equals("/update.movies")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			System.out.println(id+":"+title+":"+genre);
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
