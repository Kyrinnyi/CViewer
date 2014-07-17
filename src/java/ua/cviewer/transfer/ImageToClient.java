package ua.cviewer.transfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Vanya
 * helps to sent images in response to client
 */
public class ImageToClient {
    private final HttpServletResponse response;
    private final File image;

    public ImageToClient(HttpServletResponse response, File image) {
        this.response = response;
        this.image = image;
    }
    
    public void sent () throws IOException{
        OutputStream os = response.getOutputStream();
        InputStream is = new FileInputStream(image);
        IOUtils.copy(is, os);
        os.close();
    }    
}