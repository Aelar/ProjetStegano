package Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by aelar on 03/10/15.
 */
public final class imgFusion {


    public static void ImgFusion(imgMatrix hiding, imgMatrix toHide) throws IOException {
        hiding.hiddingMask();
        toHide.toHideMask();
        imgMatrix fusionned;
        BufferedImage img = new BufferedImage(hiding.getHeight(),hiding.getWidth(),BufferedImage.TYPE_3BYTE_BGR);

        fusionned=fusion(hiding,toHide);
        System.out.println(fusionned.get(0, 0).toString());

        for(int i=0;i<fusionned.getHeight();++i){
            for (int j=0;j<fusionned.getWidth();++j){
                img.setRGB(i,j,fusionned.get(i,j).getRGB());
            }
        }
        ImageIO.write(img,"png",new File("./out.png"));

    }

    private static imgMatrix fusion(imgMatrix hiding, imgMatrix toHide){
        int r;
        int g;
        int b;
        imgMatrix hidded= new imgMatrix(hiding);
        for(int i=0;i<hiding.getHeight();++i){
            for(int j=0;j<hiding.getWidth();++j){
                if(i<toHide.getHeight() && j< toHide.getWidth()){
                    r=hiding.get(i,j).getRed() | toHide.get(i,j).getRed();
                    g=hiding.get(i,j).getGreen() | toHide.get(i,j).getGreen();
                    b=hiding.get(i,j).getBlue() | toHide.get(i,j).getBlue();

                    hidded.set(i,j,new Color(r,g,b));
                }
            }
        }
        return hidded;
    }

    public static void main(String[] args) throws IOException {
        imgMatrix img1=new imgMatrix("/home/aelar/IdeaProjects/ProjetStegano/output/production/ProjetSteganog/1.jpg");
        imgMatrix img2=new imgMatrix("/home/aelar/IdeaProjects/ProjetStegano/output/production/ProjetSteganog/2.jpg");
        imgFusion.ImgFusion(img1,img2);
    }

}
