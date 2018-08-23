

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
 * 夫IDに対応した予約内容のJSONを生成するサーブレット。
 * 
 * @author Yuki Yoshida
 */
@WebServlet("/SendReservationDetailServlet")
public class SendReservationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendReservationDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		// イニシャライズ。
		PrintWriter out = response.getWriter();	// 排出用変数。
		ArrayList<ReservationFromMale> list = new ArrayList<ReservationFromMale>();
		String result = "";	// 排出文字列。
		String maleId = request.getParameter("male_id");
		String shopId = request.getParameter("shop_id");
		
		// DBアクセス。
		try {
			DataAccess da = new DataAccess();
			list = da.ReservationPerShopSelectFromMale(maleId, shopId);
			da.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Calendarへ変換。
		Calendar useDateTime = Calendar.getInstance();
		useDateTime.setTime(list.get(0).getUseDateTime());
		
		// JSONの生成。
		result = "{"
					+ "\"reservation_id\":\"" +list.get(0).getReservationId()+ "\","
					+ "\"female_name\":\"" +list.get(0).getFemaleName()+ "\","
					+ "\"male_name\":\"" +list.get(0).getMaleName()+ "\","
					+ "\"menu\":[" +list.get(0).getMenuNo()+ "],"
					+ "\"use_date_time\":{"
						+ "\"year\":\"" +useDateTime.get(Calendar.YEAR)+ "\","
						+ "\"month\":\"" +(useDateTime.get(Calendar.MONTH)+1)+ "\","
						+ "\"date\":\"" +useDateTime.get(Calendar.DATE)+ "\","
						+ "\"hour\":\"" +useDateTime.get(Calendar.HOUR_OF_DAY)+ "\","
						+ "\"minute\":\"" +useDateTime.get(Calendar.MINUTE)+ "\""
					+ "}"
				+ "}";
		
		// 文字列の生成。
		out.println(result);
	}

}
