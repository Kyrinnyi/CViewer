package ua.cviewer.transfer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Vanya
 * helps to sent image to server
 */
public class ImageToServer {
    private final String URL;
    private final File image;
    private final Map<String, String> params;
    private final String partName;

    public ImageToServer(String URL, File image, Map params, String partName) {
        this.URL = URL;
        this.image = image;
        this.params = params;
        this.partName = partName;
    }
    
    public String[] uploadImage() throws IOException{
        HttpPost post = new HttpPost(URL);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();        
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        
        for(String s : params.keySet()){
            builder.addTextBody(s, params.get(s)); 
        }
        
        FileBody fileBody = new FileBody(image);
        builder.addPart(partName, fileBody);  
     
        HttpEntity entity1 = builder.build();
        post.setEntity(entity1);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(post);
        
        Map<String, String> resp = new HashMap<String, String>();
        HttpEntity resEntity = response.getEntity();     
        if (resEntity != null) {
            String[] s = EntityUtils.toString(resEntity).split("\\s+");
            httpClient.close();
            return s;          
        } else {
            httpClient.close();
            return null;
        }
    }
}
