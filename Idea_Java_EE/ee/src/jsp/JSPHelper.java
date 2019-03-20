package jsp;

public class JSPHelper {
    public static int getFacotial(int a) {
        if (a <= 1) {return a;}
        else return a * getFacotial(a - 1);
    }
}
