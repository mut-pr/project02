package project02_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MoviesDAO;
import dto.MoviesDTO;

/**
 * Servlet implementation class movieServlet
 */
@WebServlet("*.movies")
public class movieController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getRequestURI();
		HttpSession session = request.getSession(true);
		MoviesDAO dao = MoviesDAO.getInstance();
		System.out.println(cmd);
		if (cmd.equals("/input.movies")) {
			String title = request.getParameter("title");
			String genre = request.getParameter("genre");
			System.out.println(title + ":" + genre);
			MoviesDTO movie = new MoviesDTO(title, genre);
			try {
				int result = dao.insert(movie);
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("/output.movies")) {
			try {
				List<MoviesDTO> list = dao.getList();
				for(MoviesDTO movies : list) {
					System.out.println(movies.getTitle());
				}
				session.setAttribute("list", list);
				request.getRequestDispatcher("/output.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (cmd.equals("/delete.movies")) {
			int id = Integer.parseInt(request.getParameter("deleteid"));
			System.out.println(id);
			try {
				int deleteResult = dao.deleteById(id);
				System.out.println(deleteResult);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(cmd.equals("/update.movies")) {
			int updatedId = Integer.parseInt(request.getParameter("id"));
			String updatedTitle = request.getParameter("title");
			String updatedGenre = request.getParameter("genre");
			System.out.println(updatedId+":"+updatedTitle+":"+updatedGenre);
			
			try {
				int updateResult = dao.updateList(updatedId, updatedTitle, updatedGenre);
				System.out.println(updateResult);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
