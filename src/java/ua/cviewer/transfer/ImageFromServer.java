package ua.cviewer.transfer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 *
 * @author Vanya
 * helps to get image from server 
 */
public class ImageFromServer {
    private final HttpResponse response;
    private final File image;

    public ImageFromServer(HttpResponse response, File image) {
        this.response = response;
        this.image = image;
    }
    
    public void get() throws IOException{
        HttpEntity resEntity = response.getEntity(); 
        OutputStream os = new FileOutputStream(image);
        resEntity.writeTo(os);
    }
    
}
