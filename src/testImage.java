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
    //Stocke l'image
    BufferedImage img;

    //Matrice de pixel
    List<List<Pixel>> matrix = new ArrayList<List<Pixel>>();

    public testImage(String nom) throws IOException {

        //Charge l'image dans le buffer
        img = ImageIO.read(new File(nom));

        //Parcours de l'image pixel par pixel pour recuperer les couleurs

        //Boucle colonne
        for(int i = 0; i<img.getWidth();++i){
            matrix.add(new ArrayList<Pixel>());
            //Boucle ligne
            for(int j = 0; j<img.getHeight();++j){
                //Stocke le pixel a ça position dans la matrice
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
