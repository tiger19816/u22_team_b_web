

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.AccessDao;

/**
 * Servlet implementation class ReservationInsert
 */
@WebServlet("/ReservationInsert")
public class ReservationInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());


		/****************
		 * 文字化け対策 *
		 ****************/
		request.setCharacterEncoding("utf-8");


		/****************
		 * 値の受け取り *
		 ****************/

		String shops_id = request.getParameter("shops_id");
		String shop_name = request.getParameter("shop_name");
		String menu_no = request.getParameter("menu_no");
		String female_id = request.getParameter("female_id");
		String use_date_time = request.getParameter("use_date_time");

//		String shops_id = "1234567";
//		String menu_no = "7";
//		String female_id = "7";
//		String use_date_time = "2018-07-28 07:07:07";


		/***************
		 * SQL文の作成 *
		 ***************/
		String Insert_sql = "INSERT INTO reservation(shops_id,menu_no,female_id,use_date_time"
				+ ")VALUES('"+shops_id+"',"+menu_no+","+female_id+",'"+use_date_time+"');";
		System.out.println(Insert_sql);

		/**********************
		 * 登録件数のカウント *
		 **********************/

		int count = 0;


		/************************
		 * 予約テーブルへの登録 *
		 ************************/

		AccessDao dao1 = null;
		try {
			 dao1 = new AccessDao();
			 dao1.shopInsert(shops_id, shop_name);
			 count = dao1.update(Insert_sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if(dao1 != null) {
				try {
					dao1.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}


		/************
		 * 登録結果 *
		 ************/

		if(count != 0) {
			request.setAttribute("result", "true");
		}
		else {
			request.setAttribute("result", "false");
		}



		RequestDispatcher rd = request.getRequestDispatcher("./RegistrationResult.jsp");
		rd.forward(request, response);

		//JSONを作成する
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print("{");
//		out.println("\"result\":true");
//		out.println("}");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
