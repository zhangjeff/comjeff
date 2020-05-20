package weixin;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WeixinTest {
    public static void main(String[] args) throws Exception {
//        printERweima();

    }

    public static void printERweima() throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
        HttpPost httpPost = new HttpPost(url);
        String body = " {\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
        httpPost.setEntity(new StringEntity(body));
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode() + "\n");
        HttpEntity entity = response.getEntity();
        String responseContent = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseContent);
        response.close();
        httpClient.close();
    }

    public static void getCode(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=gh_a1994ea50cb5" +
                "&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE" +
                "&state=STATE#wechat_redirect";
//        HttpGet httpPost = new HttpPost(url);
    }
}
