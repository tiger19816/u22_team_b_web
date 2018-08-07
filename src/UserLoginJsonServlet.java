

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
 * Servlet implementation class UserLoginJsonServlet
 */
@WebServlet("/UserLoginJsonServlet")
public class UserLoginJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginJsonServlet() {
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

		//取得
		String userMail = request.getParameter("mail");
		String userPassword = request.getParameter("password");

		if(userMail.equals("1")) {
			userMail = "kazuki@ezweb.ne.jp";
			userPassword = "12345";
		} else {
			userMail = "yumiko@ezweb.ne.jp";
			userPassword = "12345";
		}

		//行毎のデータ
		ArrayList<String> userDatas = new ArrayList<String>();

		//DBに接続
		DataAccess da = null;
		try {
			da = new DataAccess();
			userDatas = da.UserLoginSelect(userMail, userPassword);
			da.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("USERDATAS", userDatas);
		RequestDispatcher rd = request.getRequestDispatcher("user_login_json.jsp");
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
