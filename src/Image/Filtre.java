package Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by aelar on 04/10/15.
 */
public final class Filtre {

    public static void sepia(ImgMatrix img) throws IOException {
        double r;
        double g;
        double b;
        ImgMatrix sepia = new ImgMatrix(img);
        for(int i=0; i<img.getHeight();++i){
            for(int j=0;j<img.getWidth();++j){
                r=(img.get(i,j).getRed()*.393)+(img.get(i,j).getGreen()*.769)+(img.get(i,j).getBlue()*.189);
                if(r>255)r=255;
                g=(img.get(i,j).getRed()*.349)+(img.get(i,j).getGreen()*.686)+(img.get(i,j).getBlue()*.168);
                if(g>255)g=255;
                b=(img.get(i,j).getRed()*.272)+(img.get(i,j).getGreen()*.534)+(img.get(i,j).getBlue()*.131);
                if(b>255)b=255;

                sepia.set(i,j,new Color((int)r,(int)g,(int)b));
            }
        }
        BufferedImage bImg = new BufferedImage(img.getHeight(),img.getWidth(),BufferedImage.TYPE_3BYTE_BGR);

        for(int i=0;i<img.getHeight();++i){
            for (int j=0;j<img.getWidth();++j){
                bImg.setRGB(i,j,sepia.get(i,j).getRGB());
            }
        }
        ImageIO.write(bImg, "jpg", new File("./sepia.jpg"));

    }

    public static void gray(ImgMatrix img) throws IOException {
        int r;
        int g;
        int b;

        //Image.ImgMatrix gray = new Image.ImgMatrix(img);

        BufferedImage bImg = new BufferedImage(img.getHeight(),img.getWidth(),BufferedImage.TYPE_3BYTE_BGR);
        for(int i=0;i<img.getHeight();++i){
            for (int j=0;j<img.getWidth();++j){
                r=(img.get(i,j).getRed()+img.get(i,j).getGreen()+img.get(i,j).getBlue())/3;
                g=(img.get(i,j).getRed()+img.get(i,j).getGreen()+img.get(i,j).getBlue())/3;
                b=(img.get(i,j).getRed()+img.get(i,j).getGreen()+img.get(i,j).getBlue())/3;
                bImg.setRGB(i,j,new Color(r,g,b).getRGB());
            }
        }
        ImageIO.write(bImg, "jpg", new File("./gray.jpg"));

    }

    public static void rotate(ImgMatrix img,boolean sens) throws IOException {
        //Color color;
        //Image.ImgMatrix imgRotated = new Image.ImgMatrix(img.getWidth(),img.getHeight());

        BufferedImage bImg = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
        if(sens) {
            for (int i = 0; i < img.getHeight(); ++i) {
                for (int j = 0; j < img.getWidth(); ++j) {
                    bImg.setRGB(j, img.getHeight() - 1 - i, img.get(i, j).getRGB());
                }
            }
        }else{
            for (int i = 0; i < img.getHeight(); ++i) {
                for (int j = 0; j < img.getWidth(); ++j) {
                    bImg.setRGB(img.getWidth() - 1 - j, i, img.get(i, j).getRGB());
                }
            }
        }
        ImageIO.write(bImg, "jpg", new File("./rotate.jpg"));
    }

    public static void main(String[] args) throws IOException {
        ImgMatrix img = new ImgMatrix("rotate.jpg");

        Filtre.sepia(img);
        Filtre.gray(img);
        Filtre.rotate(img,true);
    }
}
