package api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*******************************************************************************
 * ぐるなびWebサービスのレストラン検索APIで緯度経度検索を実行しパースするプログラム
 * 注意：緯度、経度、範囲は固定で入れています。
 *　　　　アクセスキーはアカウント登録時に発行されたキーを指定してください。
 *      JsonをパースするためにライブラリにJacksonを追加しています。
 ******************************************************************************/
public class ApiConnect {
	public static final String ACCKEY = "e412b87f8509cc08d56071f8dd5e4a1b";
	public static final String GNAV_URL = "https://api.gnavi.co.jp/RestSearchAPI/20150630/";
	public static final String FORMAT = "?format=json";

    public static String getNodeList(String url) {
        HttpURLConnection con = null;
        InputStream is = null;
        String result = "";
        try {
            URL restSearch = new URL(url);
            con = (HttpURLConnection)restSearch.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            is = con.getInputStream();
            result = is2String(is);
            //Jackson
//            ObjectMapper mapper = new ObjectMapper();
//            viewJsonNode(mapper.readTree(http.getInputStream()));
        }
        catch (MalformedURLException ex) {
        }
        catch (IOException ex) {
        }
        finally {
            if (con != null) {
                con.disconnect();
            }

            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException ex) {
                }
            }
        }
        return result;
    }

    private static String is2String(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuffer sb = new StringBuffer();
        char[] b = new char[1024];
        int line;
        while(0 <= (line = reader.read(b))) {
            sb.append(b, 0, line);
        }
        return sb.toString();
    }

}