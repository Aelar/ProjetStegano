package Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by aelar on 03/10/15.
 */
public final class ImgFusion {


    public static void ImgFusion(ImgMatrix hiding, ImgMatrix toHide) throws IOException {
        hiding.hiddingMask();
        toHide.toHideMask();
        ImgMatrix fusionned;
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

    private static ImgMatrix fusion(ImgMatrix hiding, ImgMatrix toHide){
        int r;
        int g;
        int b;
        ImgMatrix hidded= new ImgMatrix(hiding);
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
        ImgMatrix img1=new ImgMatrix("/home/aelar/IdeaProjects/ProjetStegano/output/production/ProjetSteganog/1.jpg");
        ImgMatrix img2=new ImgMatrix("/home/aelar/IdeaProjects/ProjetStegano/output/production/ProjetSteganog/2.jpg");
        ImgFusion.ImgFusion(img1, img2);
    }

}
