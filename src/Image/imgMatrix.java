package Image;

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
public class imgMatrix {
    //Stocke l'image
    BufferedImage img;
    String hideMask="11110000";
    String getterMask="00001111";

    //Matrice de pixel stocké en tableau de bit


    public List<List<Color>> getByteMatrix() {
        return byteMatrix;
    }

    public int getHeight(){
        return byteMatrix.size();
    }

    public int getWidth(){
        return byteMatrix.get(0).size();
    }
    public int size(){return byteMatrix.size()*byteMatrix.get(0).size();}

    public void hiddingMask(){
        int r;
        int g;
        int b;
        for(int i = 0;i<getHeight();++i){
            for(int j=0;j<getWidth();++j){
                r=byteMatrix.get(i).get(j).getRed() & Integer.parseInt(hideMask,2);
                g=byteMatrix.get(i).get(j).getGreen() & Integer.parseInt(hideMask,2);
                b=byteMatrix.get(i).get(j).getBlue() & Integer.parseInt(hideMask,2);
                byteMatrix.get(i).set(j,new Color(r,g,b));


            }
        }

    }

    public void gettingMask(){
        int r;
        int g;
        int b;
        for(int i = 0;i<getHeight();++i){
            for(int j=0;j<getWidth();++j){
                //System.out.println(get(i,j).getRed());
                r=(byteMatrix.get(i).get(j).getRed() & Integer.parseInt(getterMask,2))<<4;
                g=(byteMatrix.get(i).get(j).getGreen() & Integer.parseInt(getterMask,2))<<4;
                b=(byteMatrix.get(i).get(j).getBlue() & Integer.parseInt(getterMask,2))<<4;
                byteMatrix.get(i).set(j,new Color(r,g,b));


            }
        }

    }

    public void set(int x,int y,Color color){
        byteMatrix.get(x).set(y,color);
    }

    public Color get(int x,int y){
        return byteMatrix.get(x).get(y);
    }

    public void toHideMask(){
        int r;
        int g;
        int b;
        for(int i = 0;i<getHeight();++i) {
            for (int j = 0; j < getWidth(); ++j) {
                r=(byteMatrix.get(i).get(j).getRed() & Integer.parseInt(hideMask)) >> 4;
                g=(byteMatrix.get(i).get(j).getGreen() & Integer.parseInt(hideMask)) >> 4;
                b=(byteMatrix.get(i).get(j).getBlue() & Integer.parseInt(hideMask)) >> 4;
                byteMatrix.get(i).set(j,new Color(r,g,b));
            }
        }

    }

    List<List<Color>> byteMatrix = new ArrayList<List<Color>>();

    public imgMatrix(String nom) throws IOException {

        //Charge l'image dans le buffer
        img = ImageIO.read(new File(nom));


        //Parcours de l'image pixel par pixel pour recuperer les couleurs

        //Boucle colonne
        for(int i = 0; i<img.getWidth();++i){
            byteMatrix.add(new ArrayList<Color>());
            //Boucle ligne
            for(int j = 0; j<img.getHeight();++j){
                //Stocke le pixel a ça position dans la matrice
                byteMatrix.get(i).add(new Color(img.getRGB(i,j)));
            }
        }

    }

    public imgMatrix(int height,int width){
        for(int i=0; i<height;++i){
            byteMatrix.add(new ArrayList<Color>());
            for (int j=0;j<width;++j){
                byteMatrix.get(i).add(new Color(0,0,0));
            }
        }
    }
    public imgMatrix(imgMatrix Img){

        for(int i = 0; i<Img.getHeight();++i){
            //matrix.add(new ArrayList<Image.Pixel>());
            byteMatrix.add(new ArrayList<Color>());
            //Boucle ligne
            for(int j = 0; j<Img.getWidth();++j){

                //Stocke le pixel a ça position dans la matrice
                //set(i).add(new Image.Pixel(new Color(img.get(i, j).getRGB())));
                byteMatrix.get(i).add(new Color(Img.get(i, j).getRGB()));
            }
        }
    }

    public List<List<Color>> getMatrix() {
        return byteMatrix;
    }

    public BufferedImage getImg() {
        return img;
    }

    public static void main(String[] args) throws IOException {
        imgMatrix img = new imgMatrix("/home/aelar/IdeaProjects/ProjetStegano/output/production/ProjetSteganog/img.jpg");
        //System.out.println(img.getMatrix().toString());
        //System.out.println(new Color(img.getImg().getRGB(img.getImg().getWidth() - 1, img.getImg().getHeight() - 1)));
        System.out.println(img.getByteMatrix().get(0).get(0));
    }
}
