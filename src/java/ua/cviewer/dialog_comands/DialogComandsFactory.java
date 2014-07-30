
package ua.cviewer.dialog_comands;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class DialogComandsFactory {
    final static String COM = "command";
    final static Map<String, Command> commands = new HashMap<String, Command>();
    
    static {
        commands.put("givemyrate", new GiveRateCommand());
        commands.put("glpid", new GetLastPhotoId());
        commands.put("like", new LikePhotoCommand());
    }
    
    
    public static Command getCommand(HttpServletRequest request){
        String command = request.getParameter(COM);
        Command c = commands.get(command);
        return c;
    }
    
}
