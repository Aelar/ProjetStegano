package Stegano;

import Image.imgMatrix;
import Text.HideFile;

import java.awt.*;

/**
 * Created by aelar on 05/10/15.
 */
public class hideInImage {
    imgMatrix img;
    String text;

    public hideInImage(imgMatrix img, HideFile text) {
        this.img = img;
        this.text = text.toBinary();
    }

    public void hide() {
        int count = 0;
        int r;
        int g;
        int b;
        img.hiddingMask();
        for (int i = 0; i < img.getHeight(); ++i) {
            for (int j = 0; j < img.getWidth(); ++j) {
                if (count + 12 < img.size() * 12 && count+12<text.length()) {
                    r = img.get(i, j).getRed() | Integer.getInteger(text.substring(count, count + 4), 2);
                    count += 4;
                    g = img.get(i, j).getGreen() | Integer.getInteger(text.substring(count, count + 4), 2);
                    count += 4;
                    b = img.get(i, j).getBlue() | Integer.getInteger(text.substring(count, count + 4), 2);
                    count += 4;
                    img.set(i, j, new Color(r, g, b));
                }
                else if(count + 8 < img.size()*12 &&  count + 8 < text.length()) {

                }
                else if(count + 4 < img.size()*12 &&  count + 4 < text.length()){

                }
            }
        }
    }

}
