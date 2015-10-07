package Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by aelar on 03/10/15.
 */
public final class UnfusionImg {

    public static void UnfusionImg(imgMatrix img) throws IOException {
        imgMatrix more = new imgMatrix(img);
        more.hiddingMask();

        BufferedImage img1 = new BufferedImage(more.getHeight(),more.getWidth(),BufferedImage.TYPE_3BYTE_BGR);

        for(int i=0;i<more.getHeight();++i){
            for (int j=0;j<more.getWidth();++j){
                img1.setRGB(i,j,more.get(i,j).getRGB());
            }
        }

        ImageIO.write(img1,"png",new File("./img1.png"));

        imgMatrix less = new imgMatrix(img);
        less.gettingMask();


        BufferedImage img2 = new BufferedImage(less.getHeight(),less.getWidth(),BufferedImage.TYPE_3BYTE_BGR);



        for(int i=0;i<less.getHeight();++i){
            for (int j=0;j<less.getWidth();++j){
                img2.setRGB(i,j,less.get(i,j).getRGB());
            }
        }
        System.out.println(less.get(33,60).toString());

        ImageIO.write(img2,"png",new File("./img2.png"));

    }

    public static void main(String[] args) throws IOException {
        imgMatrix img = new imgMatrix("./out.png");

        UnfusionImg.UnfusionImg(img);
    }


}
