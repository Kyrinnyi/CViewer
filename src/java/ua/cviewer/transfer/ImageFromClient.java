package ua.cviewer.transfer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Vanya
 * helps to get image from client
 */
public class ImageFromClient {
    private final HttpServletRequest request;
    private final String partName;
    private final String filePath;

    public ImageFromClient(HttpServletRequest request, String filePath, String partName) {
        this.request = request;
        this.partName = partName;
        this.filePath = filePath;
    }
    
    public void loadImage() throws IOException, IllegalStateException, ServletException{
       Map<String,String> map = new HashMap();

       for (Part part : request.getParts()) {           
           if (part.getName().equals(partName)){
                part.write(filePath);
           }
        }
    }
}
