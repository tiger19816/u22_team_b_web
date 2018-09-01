

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.DataAccess;
import entities.Shops;

/**
 * Servlet implementation class StoreNewRegistrationServlet
 */
@WebServlet("/StoreNewRegistrationServlet")
public class StoreNewRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreNewRegistrationServlet() {
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

		//登録が完了したか否かを示す変数(店ID)
		String result = "";

		System.out.println("ここまできたよ?");

		//登録内容取得
		Shops s = new Shops();
		s.setPassword( (String)request.getParameter("postPassword") );
		s.setName( (String)request.getParameter("postShopName") );
		s.setPhonetic( (String)request.getParameter("postPhonetic") );
		System.out.println("ここまできたよ?2");
		s.setOpenTime( (String)request.getParameter("postOpenTime") );
		System.out.println("ここまできたよ?2.1");
		s.setTel( (String)request.getParameter("postTel") );
		System.out.println("ここまできたよ?2.2");
		s.setAddress( (String)request.getParameter("postAddress") );
		System.out.println("ここまできたよ?2.3");
		s.setAverageBudget((String)request.getParameter("postAverageBudget"));
		System.out.println("ここまできたよ?3");
		s.setPointLatitude( (String)request.getParameter("postPointLatitude") );
		s.setPointLongitude( (String)request.getParameter("postLongitude") );
		s.setLunchService( (String)request.getParameter("postLunchService") );
		s.setNonSmokingSeat( (String)request.getParameter("postNonSmokingSeat") );
		s.setCardUsage( (String)request.getParameter("postCardUsage") );
		System.out.println("ここまできたよ?4");
		s.setImage1( (String)request.getParameter("image1") );
		s.setImage2( (String)request.getParameter("image2") );
		s.setFreeName( (String)request.getParameter("postFreeName") );
		System.out.println("ここまできたよ?5");

		System.out.println("INSERT INTO shops "
				+ "(id, "
				+ "password, "
				+ "name, "
				+ "phonetic, "
				+ "open_time, "
				+ "tel, "
				+ "address, "
				+ "average_budget, "
				+ "point_latitude, "
				+ "point_longitude, "
				+ "lunch_service, "
				+ "non_smoking_seat, "
				+ "card_usage, "
				+ "image1, "
				+ "image2) "
				+ "VALUES "
				+ "('"+"','"+s.getPassword()+"','"+s.getName()+"','"+s.getPhonetic()+"','"+s.getOpenTime()+"','"+s.getTel()+"'"
						+ ",'"+s.getAddress()+"','"+s.getAverageBudget()+"','"+s.getPointLatitude()+"','"+s.getPointLongitude()+"','"+s.getLunchService()+"',"
								+ "'"+s.getNonSmokingSeat()+"','"+s.getCardUsage()+"','"+s.getImage1()+"','"+s.getImage2()+"')");

		//DBに接続
		DataAccess da = null;
		try {
			da = new DataAccess();

			//店新規登録
			result = da.addStore(s);
			da.close();
		}
		catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if(!"".equals(result)) {
			request.setAttribute("RESULT", String.valueOf(true));
		}else {
			request.setAttribute("RESULT", String.valueOf(false));
		}
		request.setAttribute("SHOPID", result);
		RequestDispatcher rd = request.getRequestDispatcher("store_new_registration.jsp");
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
