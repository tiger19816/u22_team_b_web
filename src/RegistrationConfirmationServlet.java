

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

		int femaleId = 0;

				/**************
				 * 夫側の情報 *
				 **************/
				String[] maleDatas;
				maleDatas = new String[7];
//				String male_name = request.getParameter("male_name");
//				String male_birthday = request.getParameter("male_mail");
//				String male_birthday = request.getParameter("male_password");
//				String male_birthday = request.getParameter("male_birthday");
//				String male_height = request.getParameter("male_height");
//				String male_weight = request.getParameter("male_weight");
//				String male_profession = request.getParameter("male_profession");

				maleDatas[0] = "伊勢田こずえ";
				maleDatas[1] = "mail@gmail.com";
				maleDatas[2] = "pass12345";
				maleDatas[3] = "2000-08-27";
				maleDatas[4] = "200";
				maleDatas[5] = "70";
				maleDatas[6] = "100";

				/**************
				 * 妻側の情報 *
				 **************/
				String[] femaleDatas;
				femaleDatas = new String[12];
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

				femaleDatas[0] = "伊勢田和雅";
				femaleDatas[1] = "1997-01-20";
				femaleDatas[2] = "@@";
				femaleDatas[3] = "pas";
				femaleDatas[4] = "c.html";
				femaleDatas[5] = "0000111122223333";
				femaleDatas[6] = "1807";
				femaleDatas[7] = "1111";
				femaleDatas[8] = "ISEDA";
				femaleDatas[9] = "大阪";
				femaleDatas[10] = "111";
				femaleDatas[11] = "8";

				/**************
				 * 情報を登録  *
				 *************/
				AccessDao ac = null;
				try {
					ac = new AccessDao();
					femaleId = ac.userInsert(maleDatas, femaleDatas);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				} finally {
					if(ac != null) {
						try {
							ac.close();
						} catch (SQLException e) {
							// TODO: handle exception
						}
					}
				}

				if(0<femaleId) {
					request.setAttribute("result", "true");
				}else {
					request.setAttribute("result", "false");
				}
		request.setAttribute("id", String.valueOf(femaleId));

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
