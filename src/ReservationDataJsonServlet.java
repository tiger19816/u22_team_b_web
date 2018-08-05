

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.AccessDao;
import b.team.works.u22.hal.u22teamb.tools.DataAccess;

/**
 * Servlet implementation class ReservationDataJsonServlet
 */
@WebServlet("/ReservationDataJsonServlet")
public class ReservationDataJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDataJsonServlet() {
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

				String nextJsp = "";

				//予約ID取得
				Boolean theUpdateTime = Boolean.valueOf(request.getParameter("version"));
				String reservationId = request.getParameter("id");

				if(theUpdateTime) {
					//updateする時。
					nextJsp = "reservation_update_json.jsp";
					String menuNo = request.getParameter("menuNo");
					String date = request.getParameter("date");
					String time = request.getParameter("time");

					if(!"".equals(menuNo) || (!"".equals(date)  && !"".equals(time))) {
						//DBに接続
						AccessDao ad = null;
						try {
							ad = new AccessDao();
							Boolean result = ad.reservationUpdate(reservationId, menuNo, date, time);
							request.setAttribute("RESULT", result);
							ad.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						request.setAttribute("RESULT", true);
					}

				}else {

					//初めのページ表記の時。
					nextJsp = "reservation_data_json.jsp";

					//行毎のデータ
					ArrayList<String> reservationData = new ArrayList<String>();

					//DBに接続
					DataAccess da = null;
					try {
						da = new DataAccess();
						reservationData = da.ReservationDataSelect(Integer.parseInt(reservationId));
						da.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					request.setAttribute("DATA", reservationData);
				}

				RequestDispatcher rd = request.getRequestDispatcher(nextJsp);
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
