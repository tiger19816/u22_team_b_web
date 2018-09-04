

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
 * Servlet implementation class MalePasswordUpdateJsonServlet
 */
@WebServlet("/MalePasswordUpdateJsonServlet")
public class MalePasswordUpdateJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MalePasswordUpdateJsonServlet() {
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
		String userCode = request.getParameter("code");
		String userPassword = request.getParameter("password");

		ArrayList<String> userDatas = new ArrayList<String>();

		//DBに接続
		DataAccess da = null;
		AccessDao ad = null;
		try {
			da = new DataAccess();
			ad = new AccessDao();
			userDatas.add(da.MaleRegistrationCodeSelect2(userCode));
			da.close();
			userDatas.add(String.valueOf(ad.malePasswordUpdate(userDatas.get(0), userPassword)));
			ad.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("USERDATAS", userDatas);
		RequestDispatcher rd = request.getRequestDispatcher("male_password_update_json.jsp");
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
