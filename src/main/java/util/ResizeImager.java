package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ResizeImager {

    //Уменьшить картинку в указанное количество раз
    public static BufferedImage resize(File picture, int count) {

        BufferedImage resized = null;
        BufferedImage image;
        try {
            image = ImageIO.read(picture);
            int newHeight = image.getHeight()/count;
            int newWidth = image.getWidth()/count;
            Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resized;
    }

    //Уменьшить картинку в указанное количество раз
    public static BufferedImage resize(File picture, int newHeight, int newWidth) {

        BufferedImage resized = null;
        BufferedImage image;
        try {
            image = ImageIO.read(picture);
            Image tmp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resized;
    }

    public static byte[] toByteArrayAutoClosable(BufferedImage image) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", out);
            return out.toByteArray();
        }
    }

}
