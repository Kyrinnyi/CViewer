package ua.cviewer.pass;

import java.util.Random;

/**
 *
 * @author Vanya
 * creates password with id on client side
 */
public class SimplePassCreator implements PassCreator{
    private final long mask;

    public SimplePassCreator(long mask) {
        this.mask = mask;
    }

    @Override
    public long createPass(int id) {
        if (id < 1){
            return  -1;
        }
        Random rnd = new Random();
        int r = 0;
        while (r == 0){
            r = rnd.nextInt(Integer.MAX_VALUE);
        }
        long pass = r * (long)id;
        pass = pass ^ mask;
        pass = pass + 12 * id;
        return pass;        
    }
    
}
