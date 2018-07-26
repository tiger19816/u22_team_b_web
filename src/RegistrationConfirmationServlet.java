

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.AccessDao;

/**
 * Servlet implementation class RegistrationConfirmationServlet
 */
@WebServlet("/RegistrationConfirmationServlet")
public class RegistrationConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationConfirmationServlet() {
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


				/**************
				 * 夫側の情報 *
				 **************/
				int male_id = 0;
//				String male_name = request.getParameter("male_name");
//				String male_birthday = request.getParameter("male_birthday");
//				String male_height = request.getParameter("male_height");
//				String male_weight = request.getParameter("male_weight");
//				String male_profession = request.getParameter("male_profession");

				String male_name = "伊勢田こずえ";
				String male_birthday = "2000-08-27";
				String male_height = "200";
				String male_weight = "70";
				String male_profession = "100";


				/******************
				 * 夫側のINSERT文 *
				 ******************/
				String male_insert_sql = "INSERT INTO male(name,birthday,height,weight,profession)";
				male_insert_sql +="VALUES('"+male_name+"','"+male_birthday+"',"+male_height+","+male_weight+",'"+male_profession+"');";
				System.out.print(male_insert_sql);

				/**************
				 * 妻側の情報 *
				 **************/

//				String female_name = request.getParameter("female_name");
//				String female_birthday = request.getParameter("female_birthday");
//				String female_mail = request.getParameter("female_mail");
//				String female_password = request.getParameter("female_password");
//				String female_icon_url = request.getParameter("female_icon_url");
//				String female_card_number = request.getParameter("female_card_number");
//				String female_card_expiraion_date = request.getParameter("female_card_expiration_date");
//				String female_card_security_code = request.getParameter("female_card_security_code");
//				String female_card_nominee = request.getParameter("female_card_nominee");
//				String female_address = request.getParameter("female_address");
//				String female_point_latitude = request.getParameter("female_point_latitude");
//				String female_point_longitude = request.getParameter("female_point_longtude");

				String female_name = "伊勢田和雅";
				String female_birthday = "1997-01-20";
				String female_mail = "@@";
				String female_password = "pas";
				String female_icon_url = "c.html";
				String female_card_number = "0000111122223333";
				String female_card_expiraion_date = "1807";
				String female_card_security_code = "1111";
				String female_card_nominee = "ISEDA";
				String female_address = "大阪";
				String female_point_latitude = "111";
				String female_point_longitude = "8";




				ResultSet rs = null;


				/***********************
				 * 夫の情報を登録用    *
				 * 仮としてdao1と表記  *
				 ***********************/
				AccessDao  dao1 = null;
				try {
					dao1 = new AccessDao();
					male_id = dao1.InsertAut(male_insert_sql);
					System.out.print("******************************");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				} finally {
					if(dao1 != null) {
						try {
							dao1.close();
						} catch (SQLException e) {
							// TODO: handle exception
						}
					}
				}





				/****************
				 * 妻側の登録   *
				 * 仮としてdao3 *
				 ****************/


				String female_insert_sql = "INSERT INTO female(name,birthday,mail,password,icon_url,card_number,card_expiration_date,card_security_code,card_nominee,address,point_latitude,point_longitude,male_id)";
				female_insert_sql += "VALUES('"+female_name+"','"+female_birthday+"','"+female_mail+"','"+female_password+"','"+female_icon_url+"','"+female_card_number+"','"+female_card_expiraion_date+"','"+female_card_security_code+"','"+female_card_nominee+"','"+female_address+"',"+female_point_latitude+","+female_point_longitude+","+male_id+")";

				System.out.print(female_insert_sql);


				try {
					System.out.print(female_insert_sql);

					AccessDao dao3 = new AccessDao();
					int insert = dao3.update(female_insert_sql);

					if(insert != 0) {
							request.setAttribute("result", "true");
						}
						else {
							request.setAttribute("result", "false");
						}
				} catch (ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					System.out.print(e);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					System.out.print(e);
				}






				RequestDispatcher rd = request.getRequestDispatcher("./RegistrationResult.jsp");
				rd.forward(request, response);

				//JSONを作成する
//				response.setContentType("application/json; charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				out.print("{");
//				out.println("\"result\":true");
//				out.println("}");




		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
