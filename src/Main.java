import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Convert convert = new Convert();

        String imagePath = "/Users/artem/Pictures/cat/IMG_20200717_194505_resized_20220428_120816929.jpg";
        BufferedImage image = ImageIO.read(new File(imagePath));
        Image scaledImage = image.getScaledInstance(1000, 700, BufferedImage.SCALE_SMOOTH);
        BufferedImage bwImg = new BufferedImage(1000, 700, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);
        WritableRaster bwRaster = bwImg.getRaster();


        String[][] text = new String[700][1000];
        for (int o = 0; o < 700; o++) {
            for (int j = 0; j < 1000; j++) {
                int color = bwRaster.getPixel(j, o, new int[3])[0];
                char c = convert.sort(color);
                String s = Character.toString(c);
                text[o][j] = s;

            }
        }
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 1000; j++) {
                System.out.print(text[i][j]);
            }
            System.out.println();
        }
    }
}

