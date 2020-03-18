package Game.Player;

import Game.Enemy.Enemy;
import Game.GameObject;
import Game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.SortedSet;

public class PlayerBullet  extends GameObject {
    int count;

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/sphere-bullets/2.png");
//        position = new Vector2D();
//        velocity = new Vector2D(0, -5);
        velocity.set(0,-5);
        count = 0;
    }

    @Override
    public void run() {
        super.run();
        count++;
        if(count > 120){
            Enemy enemy = GameObject.find(Enemy.class);
            if (enemy != null){
                Vector2D bulletToEnemy = enemy.position.clone();
                bulletToEnemy.substract(this.position);
                bulletToEnemy.setLength(5);
                this.velocity.set(bulletToEnemy);
            }
        }

    }

    //    public void render(Graphics g){
//        g.drawImage(image, (int) position.x, (int) position.y, null);
//    }

//    public void run(){
//        position.add(velocity.x,velocity.y);
//    }
}
