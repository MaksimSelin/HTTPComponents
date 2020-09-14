

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CloseableHttpResponse resp = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://speller.yandex.net/services/spellservice/checkText?text=олна+пашла+за+хлибам");
            resp = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(resp.getEntity()));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                resp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
