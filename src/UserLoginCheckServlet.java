

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
import entities.Female;

/**
 * Servlet implementation class UserLoginCheckServlet
 */
@WebServlet("/UserLoginCheckServlet")
public class UserLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCheckServlet() {
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

		//妻のメールアドレス・パスワード取得
		String mail = request.getParameter("mail"); //メルアド
		String password = request.getParameter("password"); //パスワード

		//妻情報を格納する配列
		ArrayList<Female> females = new ArrayList<Female>();

		//データベース接続
		DataAccess da = null;
		try {
			da = new DataAccess();

			//妻情報抽出
			females = da.FemaleSelect();

			//取得したメールアドレスとパスワードとがデータベースに登録されている内容と一致しているか否か
			for(int i = 0; i < females.size(); i++) {
				if(mail.equals( females.get(i).getMail() ) && password.equals( females.get(i).getPassword() )) {
					request.setAttribute("result", "true");
					break;
				}
				else {
					request.setAttribute("result", "false");
				}
			}

		}
		catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("user_login_check.jsp");
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
