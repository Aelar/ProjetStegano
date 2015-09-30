import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aelar on 23/09/15.
 */
public class testImage {
    BufferedImage img;
    List<List<Pixel>> matrix = new ArrayList<List<Pixel>>();

    public testImage(String nom) throws IOException {

        img = ImageIO.read(new File(nom));
        for(int i = 0; i<img.getWidth();++i){
            matrix.add(new ArrayList<Pixel>());
            for(int j = 0; j<img.getHeight();++j){

                matrix.get(i).add(new Pixel(new Color(img.getRGB(i,j))));
            }
        }

    }

    public List<List<Pixel>> getMatrix() {
        return matrix;
    }

    public static void main(String[] args) throws IOException {
        testImage img = new testImage("/home/aelar/IdeaProjects/ProjetStegano/output/production/ProjetSteganog/img.jpg");
        System.out.println(img.getMatrix().toString());

    }
}
