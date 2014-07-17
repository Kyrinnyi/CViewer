package ua.cviewer.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ua.cviewer.transfer.ImageToServer;

/**
 *
 * @author Vanya
 */
public class ClientTest {
  public static void main(String[] args) throws IOException{
      String url = "http://localhost:8084/CViewer/IMGController";
      File image = new File("E://1.jpg");
      Map<String, String> params = new HashMap<String, String>();
      params.put("id", "2323");
      params.put("pass", "23223323");
      String partName = "my_file";
      
      ImageToServer its = new ImageToServer(url, image, params, partName);
      String[] s = its.uploadImage();
      for (String s1 : s){
          System.out.println(s1);
      }
    }
}