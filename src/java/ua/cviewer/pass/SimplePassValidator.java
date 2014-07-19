package ua.cviewer.pass;

/**
 *
 * @author Vanya
 * cheacks pass on the server side
 */
public class SimplePassValidator implements PassValidator{
    private final long mask;

    public SimplePassValidator(long mask) {
        this.mask = mask;
    }
    
    @Override
    public boolean checkPass(int id, long pass) {
        long x = pass - 12 * id;
        x = x ^ mask;
        return x % id == 0;
    }    
    
    public static void main (String... args){
        long mask = 12132131;
        int id = 12131;
        PassCreator pc = new SimplePassCreator(mask);
        long pass = pc.createPass(id);
        System.out.println(pass);
        PassValidator pv = new SimplePassValidator(mask);
        System.out.println(pv.checkPass(id, pass));
    }
}
