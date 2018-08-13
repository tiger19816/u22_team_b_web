

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.AccessDao;

/**
 * Servlet implementation class UserLatLngServlet
 */
@WebServlet("/UserLatLngServlet")
public class UserLatLngServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLatLngServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		AccessDao dao = null;
		String[] result = new String[2];
		try {
			dao = new AccessDao();
			result = dao.selectLatLng(request.getParameter("id"));
		} catch (Exception e) {
		} finally {
			if(dao != null) {
				try {
					dao.close();
				} catch (Exception e) {
				}
			}
		}
		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("user_lat_lng_json.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
