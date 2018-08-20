

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

		//登録が完了したか否かを示す変数
		boolean result = false;

		//登録内容取得
		Shops s = new Shops();
		s.setId( request.getParameter("postShopId") );
		s.setPassword( request.getParameter("postPassword") );
		s.setName( request.getParameter("postShopName") );
		s.setPhonetic( request.getParameter("postPhonetic") );
		s.setOpenTime( request.getParameter("postOpenTime") );
		s.setTel( request.getParameter("postTel") );
		s.setAddress( request.getParameter("postAddress") );
		s.setAverageBudget( request.getParameter("postAverageBudget") );
		s.setPointLatitude( request.getParameter("postPointLatitude") );
		s.setPointLongitude( request.getParameter("postLongitude") );
		s.setLunchService( request.getParameter("postLunchService") );
		s.setNonSmokingSeat( request.getParameter("postNonSmokingSeat") );
		s.setCardUsage( request.getParameter("postCardUsage") );
		s.setImage1( request.getParameter("image1") );
		s.setImage2( request.getParameter("image2") );
		s.setNo( request.getParameter("postNo") );
		s.setFreeName( request.getParameter("postFreeName") );

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

		request.setAttribute("RESULT", result);
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
