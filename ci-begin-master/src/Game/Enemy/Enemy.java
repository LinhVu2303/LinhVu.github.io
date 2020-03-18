package Game.Enemy;

import Game.GameObject;
import Game.Setting;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Enemy extends GameObject {
    int fireCount;

    public Enemy(){
        renderer = new Renderer("assets/images/enemies/level0/black");
        position.set(0, Setting.GAME_HEIGHT - Setting.BACKGROUND_HEIGHT);
        velocity.set(0, 3);
        fireCount = 0;
    }

    public void run(){
        super.run();
        changeDiretion();
        fire();
    }

    private void fire() {
        fireCount++;
        if (fireCount > 120){
            EnemyBullet bullet = new EnemyBullet();
            bullet.position.set(this.position); // dat vi tri dan tai vi tri eneny
            fireCount = 0;
        }
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
