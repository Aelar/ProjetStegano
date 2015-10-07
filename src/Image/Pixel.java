package Image;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by aelar on 30/09/15.
 */
public class Pixel {
    Collection<Integer> R;
    Collection<Integer> V;
    Collection<Integer> B;

    public Collection<Integer> getR() {
        return R;
    }
    private List<Integer> reverse(List<Integer> list){
        Integer temp=0;
        for(int i=0;i<list.size()/2;++i){
            temp = list.get(i);
            list.set(i,list.get(list.size()-1-i));
            list.set(list.size()-1-i,temp);
        }
        return list;
    }
    public Collection<Integer> getV() {
        return V;
    }

    public Collection<Integer> getB() {
        return B;
    }

    private Collection<Integer> toBinaryCol(String binary){
        java.util.List<Integer> Bin = new ArrayList<Integer>();

        for(int i=binary.length()-1;i>=0;i--){
            Bin.add(Character.getNumericValue(binary.charAt(i)));
        }
        for(int i = 0;i<8-binary.length();i++){
            Bin.add(0);
        }
        Bin=reverse(Bin);
        //System.out.println(binary.length());
        return Bin;
    }


    public Pixel(Color col) {

        /*R = toBinary(col.getRed());
        V = toBinary(col.getGreen());
        B = toBinary(col.getBlue());*/

        R = toBinaryCol(Integer.toBinaryString(col.getRed()));
        V= toBinaryCol(Integer.toBinaryString(col.getGreen()));
        B= toBinaryCol(Integer.toBinaryString(col.getBlue()));
    }

    @Override
    public String toString() {
        return  R + " " + V + " " + B;
    }
}
