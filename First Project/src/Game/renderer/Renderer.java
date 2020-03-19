package Game.renderer;

import Game.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Renderer {
    BufferedImage image;
    ArrayList<BufferedImage> images;
    int currentIndex;
    int frameCount;
    boolean isOnce; // = true
    public Renderer(BufferedImage image){
        this.image = image;
        this.currentIndex =0;
        this.frameCount = 0;
    }

    public Renderer(String folderPath){ // animation
        images = new ArrayList<>();
        File folder = new File(folderPath);
//        String fileNames[] = folder.list();
        List<String> fileNames = Arrays.asList(folder.list());
        fileNames.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        for (int i =0; i < fileNames.size();i++) {
            String fileName = fileNames.get(i);
            if (fileName.toLowerCase().endsWith(".png")) {
                BufferedImage image = SpriteUtils.loadImage(folderPath + "/" + fileName);
                images.add(image);
            }
        }
    }

    public Renderer(String folderPath, boolean isOnce){
        this(folderPath);
        this.isOnce = isOnce;
    }

    public void render(Graphics g, GameObject master) {
        //master >  position
        if (image != null) {
            g.drawImage(image, (int) (master.position.x - master.anchor.x * image.getWidth()),
                    (int) (master.position.y- master.anchor.y * image.getHeight()),
                    null);
        } else if (images != null){
            BufferedImage currentImage = images.get(currentIndex);
            g.drawImage(currentImage, (int) (master.position.x - master.anchor.x * currentImage.getWidth()),
                    (int) (master.position.y - master.anchor.y * currentImage.getHeight()) ,
                    null);

            frameCount++;
            if (frameCount  > 10) {
                currentIndex++;
                if (currentIndex >= images.size()) {
                    if (isOnce) {
                        master.deactive();
                    }
                    currentIndex = 0;
                    frameCount = 0;
                }
            }
        }
    }
}
