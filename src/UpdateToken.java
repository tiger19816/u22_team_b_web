

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.tools.DataAccess;

/**
 * トークンを更新するサーブレット。
 * 
 * @author Yuki Yoshida
 */
@WebServlet("/UpdateToken")
public class UpdateToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateToken() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		String userId = request.getParameter("user_id");
		String gender = request.getParameter("gender");
		String token = request.getParameter("token");
		
		try {
			DataAccess da = new DataAccess();
			
			int i = da.updateToken(userId, Integer.parseInt(gender), token);
			
			da.close();
			
			System.out.println("The token was updated. Update Records = " + i + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
