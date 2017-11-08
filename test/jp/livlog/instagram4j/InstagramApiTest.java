package jp.livlog.instagram4j;

import java.util.Map;

import org.junit.Test;

import jp.livlog.instagram4j.exception.InstagramApiException;


public class InstagramApiTest {

    @Test
    public void test()  {


        try {
            InstagramApi api = new InstagramApi("clientId","clientSecret");
            api.setAccessToken("accessToken");
            Map <?, ?> result = api.getMediaSearch("35.658593", "139.745441", null, null, "5000");
            System.out.println(result);
        } catch (InstagramApiException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }


    }

}
