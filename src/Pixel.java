import java.awt.*;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by aelar on 30/09/15.
 */
public class Pixel {
    Integer R;
    Integer V;
    Integer B;

    public Integer getR() {
        return R;
    }

    public Integer getV() {
        return V;
    }

    public Integer getB() {
        return B;
    }

    private Collection<Integer> toBinary(int i){
        Collection<Integer> Bin = new TreeSet<Integer>();
        if(i<2){
            Bin.addAll(toBinary(i/2));
        }
        Bin.add(i%2);
        return Bin;
    }


    public Pixel(Color col) {

        /*R = toBinary(col.getRed());
        V = toBinary(col.getGreen());
        B = toBinary(col.getBlue());*/

        R = col.getRed();
        V= col.getGreen();
        B= col.getBlue();
    }

    @Override
    public String toString() {
        return  R + " " + V + " " + B;
    }
}
