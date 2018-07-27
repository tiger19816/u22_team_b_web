

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

/**
 * Servlet implementation class HistoryListJsonServlet
 */
@WebServlet("/HistoryListJsonServlet")
public class HistoryListJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryListJsonServlet() {
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
				String femaleId = request.getParameter("id");

				//行毎のデータ
				ArrayList<ArrayList<String>> historyList = new ArrayList<ArrayList<String>>();

				//DBに接続
				DataAccess da = null;
				try {
					da = new DataAccess();
					historyList = da.HistoryListSelect(Integer.parseInt(femaleId));
					da.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
				}

				request.setAttribute("LIST", historyList);
				RequestDispatcher rd = request.getRequestDispatcher("history_list_json.jsp");
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
