

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.team.works.u22.hal.u22teamb.api.ApiConnect;

/**
 * Servlet implementation class StoreDetailsServlet
 */
@WebServlet("/StoreDetailsServlet")
public class StoreDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		//店舗id
		String id = request.getParameter("id");
		// エンドポイント
		String prmKeyid = "&keyid=" + ApiConnect.ACCKEY;
		String prmId ="&id=" + id;

		System.out.println(prmKeyid);
		// URI組み立て
		StringBuffer uri = new StringBuffer();
		uri.append(ApiConnect.GNAV_URL);
		uri.append(ApiConnect.FORMAT);
		uri.append(prmKeyid);
		uri.append(prmId);

		// API実行、結果を取得し出力
		String str = ApiConnect.getNodeList(uri.toString());
		//JSONを作成する
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println(str);

		System.out.println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
