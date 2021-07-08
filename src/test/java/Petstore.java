import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Petstore {

      /*
To execute api call:
1. Have/launch a client(postman)
2. Have valid URL
3. Specify desired/supported HTTP method
4. Define headers (if needed)
5. Define query string parameters (if needed)
6. Execute/click on Send button

 */

    //  https://petstore.swagger.io/v2/pet/1

    @Test
    public void getPetTest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("petstore.swagger.io");
        uriBuilder.setPath("v2/pet/1");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        HttpResponse response = client.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(200,statusCode);

        String responseBody=EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);

    }


}
