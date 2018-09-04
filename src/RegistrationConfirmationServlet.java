

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

				maleDatas[0] = request.getParameter("maleName");
				maleDatas[1] = request.getParameter("maleMail");
				maleDatas[2] = request.getParameter("malePassword");
				maleDatas[3] = request.getParameter("maleBirthday");
				maleDatas[4] = request.getParameter("maleHeight");
				maleDatas[5] = request.getParameter("maleWeight");
				maleDatas[6] = request.getParameter("maleProfession");

				/**************
				 * 妻側の情報 *
				 **************/
				String[] femaleDatas;
				femaleDatas = new String[12];

				femaleDatas[0] = request.getParameter("femaleName");
				femaleDatas[1] = request.getParameter("femaleBirthday");
				femaleDatas[2] = request.getParameter("femaleMail");
				femaleDatas[3] = request.getParameter("femalePassword");
				femaleDatas[4] = request.getParameter("femaleIcon");
				femaleDatas[5] = request.getParameter("femaleCardNo");
				femaleDatas[6] = request.getParameter("femaleCardDoneDeadline");
				femaleDatas[7] = request.getParameter("femaleSecurityCode");
				femaleDatas[8] = request.getParameter("femaleCardNomineeName");
				femaleDatas[9] = request.getParameter("femaleAddress");
				femaleDatas[10] = request.getParameter("femaleLongitude");
				femaleDatas[11] = request.getParameter("femaleLatitude");

				for(int i=0; i<femaleDatas.length; i++) {
					System.out.println(String.valueOf(i)+"番目:"+femaleDatas[i]);
				}

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
