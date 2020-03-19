package Game;

import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background  extends GameObject {

    public Background(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        renderer = new Renderer(image);
        position.set(0,Setting.GAME_HEIGHT - Setting.BACKGROUND_HEIGHT);
        velocity.set(0, 10);
        anchor.set(0,0);

    }

    @Override
    public void run(){
        super.run();
        if (position.y > 0){
            position.set(position.x, 0);
        }
    }

    private void move() {
        position.add(0,10);
        if(position.y > 0) {
            position.set(position.x, 0);
        }
    }
}
