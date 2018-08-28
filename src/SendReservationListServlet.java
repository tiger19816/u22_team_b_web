

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.DataAccess;
import entities.ReservationFromMale;

/**
 * 店毎に予約一覧をJSON出力するメソッド。
 *
 * @author Yuki Yoshida
 */
@WebServlet("/SendReservationListServlet")
public class SendReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendReservationListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		// イニシャライズ。
		PrintWriter out = response.getWriter();	// 排出用変数。
		ArrayList<ReservationFromMale> list = new ArrayList<ReservationFromMale>();
		String result = "";	// 排出文字列。
		String shopId = request.getParameter("shop_id");

		// DBアクセス。
		try {
			DataAccess da = new DataAccess();
			list = da.ReservationListPerShopSelect(shopId);
			da.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// JSONの生成。
		result += "[";
			for (int i = 0; i < list.size(); i++) {
				result += "{";
					result += "\"male_name\":\"" +list.get(i).getMaleName()+ "\",";
					Calendar useDateTime = Calendar.getInstance();
					useDateTime.setTime(list.get(i).getUseDateTime());
					result += "\"use_date_time\":{"
								+ "\"year\":\"" +useDateTime.get(Calendar.YEAR)+ "\","
								+ "\"month\":\"" +(useDateTime.get(Calendar.MONTH)+1)+ "\","
								+ "\"date\":\"" +useDateTime.get(Calendar.DATE)+ "\","
								+ "\"hour\":\"" +useDateTime.get(Calendar.HOUR_OF_DAY)+ "\","
								+ "\"minute\":\"" +useDateTime.get(Calendar.MINUTE)+ "\""
							+ "}";
				result += "}";
				if (i != (list.size() - 1)){
					result += ",";
				}
			}
		result += "]";

		// 文字列の生成。
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
