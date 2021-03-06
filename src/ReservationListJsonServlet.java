

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.DataAccess;

/**
 * Servlet implementation class ReservationListJsonServlet
 */
@WebServlet("/ReservationListJsonServlet")
public class ReservationListJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationListJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("utf-8");

		//ID取得
		String id = request.getParameter("id");
		String sex = request.getParameter("sex");

		//行毎のデータ
		ArrayList<ArrayList<String>> reservationList = new ArrayList<ArrayList<String>>();

		//DBに接続
		DataAccess da = null;
		try {
			da = new DataAccess();
			if("0".equals(sex)) {
				reservationList = da.ReservationListSelect(Integer.parseInt(id));
			}else {
				reservationList = da.ReservationListSelect2(Integer.parseInt(id));
			}
			da.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("LIST", reservationList);
		RequestDispatcher rd = request.getRequestDispatcher("reservation_list_json.jsp");
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
