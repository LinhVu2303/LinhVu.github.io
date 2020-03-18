package Game.Enemy;

import Game.GameObject;
import Game.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class  Enemy extends GameObject {

    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png");
        position.set(0, Setting.GAME_HEIGHT - Setting.BACKGROUND_HEIGHT);
        velocity.set(0, 3);
    }

    public void run(){
        super.run();
        changeDiretion();
    }

    private void changeDiretion() {
        if  ( position.x > Setting.BACKGROUND_WIDTH - 28 && velocity.x > 0){
            velocity.set(-velocity.x, velocity.y);
        }
        if ( position.x < 0 && velocity.x <0){
            velocity.set(-velocity.x,  velocity.y);
        }
    }

}
