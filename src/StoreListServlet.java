

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.ApiConnect;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class StoreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//緯度
		String lat = request.getParameter("lat");
		//経度
		String lon = request.getParameter("lon");

//		// 緯度
//		String lat = "35.670082";
//		// 経度
//		String lon = "139.763267";

		// 範囲
		String range = "2";
		//ランチのみ
		String lunch = "1";

		// エンドポイント
		String prmKeyid = "&keyid=" + ApiConnect.ACCKEY;
		String prmLat = "&latitude=" + lat;
		String prmLon = "&longitude=" + lon;
		String prmRange = "&range=" + range;
		String prmLunch = "&lunch=" + lunch;

		System.out.println(prmKeyid);
		// URI組み立て
		StringBuffer uri = new StringBuffer();
		uri.append(ApiConnect.GNAV_URL);
		uri.append(ApiConnect.FORMAT);
		uri.append(prmKeyid);
		uri.append(prmLat);
		uri.append(prmLon);
		uri.append(prmRange);
		uri.append(prmLunch);

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
