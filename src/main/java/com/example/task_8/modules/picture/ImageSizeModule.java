package com.example.task_8.modules.picture;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageSizeModule extends AbstractPictureModule {
    @Override
    public String getFunctionDescription() {
        return "Returns size of the image.";
    }

    @Override
    public void function(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            System.out.printf("Image Size (WxH): %dx%d px", image.getWidth(), image.getHeight());
        } catch (IOException e) {
            System.out.println("Could not open the file " + file.getName());
        }
    }
}
