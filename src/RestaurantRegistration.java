

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
 * Servlet implementation class RestaurantRegistration
 */
@WebServlet("/RestaurantRegistration")
public class RestaurantRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantRegistration() {
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

//		String shops_password = request.getParameter("password");
//		String shops_name = request.getParameter("name");
//		String shops_phonetic = request.getParameter("phonetic");
//		String shops_open_time = request.getParameter("open_time");
//		String shops_tel = request.getParameter("tel");
//		String shops_address = request.getParameter("address");
//		String shops_average_budget = request.getParameter("average_budget");
//		String shops_point_latitube = request.getParameter("point_latitube");
//		String shops_point_ongitube = request.getParameter("point_ongitube");
//		String shops_lunch_service = request.getParameter("lunch_service");
//		String shops_non_smoking_seat = request.getParameter("non_smoking_seat");
//		String shops_card_usage = request.getParameter("card_usage");
//		String shops_image1 = request.getParameter("image1");
//		String shops_image2 = request.getParameter("image2");
//
//		String freeword_no = request.getParameter("freeword_no");
//		String freeword_name = request.getParameter("freeword_name");

		int shops_id = 0;
		int count = 0;

		String shops_password = "";
		String shops_name = "";
		String shops_phonetic = "";
		String shops_open_time = "";
		String shops_tel = "";
		String shops_address = "";
		String shops_average_budget = "1";
		String shops_point_latitube = "0";
		String shops_point_ongitube = "0";
		String shops_lunch_service = "1";
		String shops_non_smoking_seat = "1";
		String shops_card_usage = "1";
		String shops_image1 = "";
		String shops_image2 = "";

		String freeword_no = "4";
		String freeword_name = "";

		/*****************
		 * 店登録のSQL文 *
		 *****************/

		String sql = "INSERT INTO shops(password, "
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
						+ "	("+shops_password+","
						+ "'"+shops_name+"',"
						+ "'"+shops_phonetic+"',"
						+ "'"+shops_open_time+"',"
						+ "'"+shops_tel+"',"
						+ "'"+shops_address+"',"
						+ ""+shops_average_budget+","
						+ ""+shops_point_latitube+","
						+ ""+shops_point_ongitube+","
						+ ""+shops_lunch_service+","
						+ ""+shops_non_smoking_seat+","
						+ ""+shops_card_usage+","
						+ "'"+shops_image1+"',"
						+ "'"+shops_image2+"')"
				+ ";";


		/**************
		 * 店舗登録用 *
		 **************/

		AccessDao dao = null;
		try {
			dao = new AccessDao();
			shops_id = dao.InsertAut(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(dao != null) {
				try {
					dao.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}

		/*********************
		 * フリーワードのSQL *
		 *********************/

		String sql1 = "INSERT INTO `freeword`(shops_id, no, name) "
				+ "VALUES ("+shops_id+","+freeword_no+",'"+freeword_name+"')";


		/**********************
		 * フリーワードの登録 *
		 **********************/
		AccessDao dao1 = null;
		try {
			dao1 = new AccessDao();
			count = dao1.update(sql1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally {
			if(dao1 != null) {
				try {
					dao1.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}

		/**************
		 * 登録の可否 *
		 **************/

		if(count != 0) {
			request.setAttribute("result", "true");
		}
		else {
			request.setAttribute("result", "false");
		}



		RequestDispatcher rd = request.getRequestDispatcher("./RegistrationResult.jsp");
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
