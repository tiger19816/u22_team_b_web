

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
 * Servlet implementation class StoreLoginJsonServlet
 */
@WebServlet("/StoreLoginJsonServlet")
public class StoreLoginJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreLoginJsonServlet() {
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

		//妻ID取得
		String storeId = request.getParameter("id");
		String storePassword = request.getParameter("password");

		//結果
		Boolean dataExisted = true;

		//行毎のデータ
		ArrayList<String> storeDatas = new ArrayList<String>();

		//DBに接続
		DataAccess da = null;
		try {
			da = new DataAccess();
			storeDatas = da.StoreLoginSelect(storeId, storePassword);
			if(storeDatas == null) {
				dataExisted = false;
			}
			da.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("STOREDATA", storeDatas);
		request.setAttribute("DATAEXISTED", dataExisted);
		RequestDispatcher rd = request.getRequestDispatcher("store_login_json.jsp");
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
