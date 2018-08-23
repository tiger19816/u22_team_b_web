

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.DataAccess;
import b.team.works.u22.hal.u22teamb.tools.MyMessage;

/**
 * 来店処理を行うサーブレット。
 * 
 * @author Yuki Yoshida
 */
@WebServlet("/UpdateVisitFlagServlet")
public class UpdateVisitFlagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVisitFlagServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		String reservationId = request.getParameter("reservation_id");
		
		String title = "U22夫管理アプリ";
		String message = "さんが店舗へ来店しました！";
		
		try {
			DataAccess da = new DataAccess();
			da.updateVisitFlag(reservationId);
			
			String token = "";
			String male = "";
			
			// この後、妻に通知したい。
//			MyMessage push = new MyMessage(title, male + message);
//			push.sendToToken(token);
			
			da.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
