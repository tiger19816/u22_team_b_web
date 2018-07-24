

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
import entities.Male;

/**
 * Servlet implementation class MypageJsonTestServlet
 */
@WebServlet("/MypageJsonTestServlet")
public class MypageJsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageJsonTestServlet() {
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
		String id = request.getParameter("id");

		//※※デバック用※※
		id = "1";

		//妻情報を格納する配列
		ArrayList<Female> female = new ArrayList<Female>();

		//夫情報を格納する配列
		ArrayList<Male> male = new ArrayList<Male>();

		//DBに接続
		DataAccess da = null;
		try {
			da = new DataAccess();

			//妻情報抽出
			female = da.FemaleSelect(id);

			//夫ID取得
			int maleId = female.get(0).getMaleId();

			//夫情報抽出
			male = da.MaleSelect(maleId);

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

		request.setAttribute("female", female);
		request.setAttribute("male", male);
		RequestDispatcher rd = request.getRequestDispatcher("mypage_json_test.jsp");
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
