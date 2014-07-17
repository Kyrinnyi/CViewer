package ua.cviewer.base;

import java.io.File;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import ua.cviewer.transfer.ImageFromServer;

/**
 *
 * @author Vanya
 */
public class ClientGetImg {
    public static void main(String[] args) throws IOException{
        HttpPost post = new HttpPost("http://localhost:8084/CViewer/IMGGetController");
        File image = new File("E://Images/10.jpg");

        EntityBuilder eb = EntityBuilder.create();
        eb.setParameters(new Pair("com", "givemeimg"), new Pair("id", "2222"), new Pair("pass", "232332"));
        
        HttpEntity entity1 = eb.build();
        post.setEntity(entity1);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(post);
        ImageFromServer ifs = new ImageFromServer(response, image);
        ifs.get();      
    }  
    
    private static class Pair implements NameValuePair{
        private final String name;
        private final String value;

        public Pair(String name, String value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getValue() {
            return value;
        }      
    }
}
