package Game.Player;

import Game.Enemy.Enemy;
import Game.GameObject;
import Game.Vector2D;
import Game.physic.BoxCollider;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.SortedSet;

public class PlayerBullet  extends GameObject {
    int count;
    int damage;

    public PlayerBullet() {
        renderer = new Renderer("assets/images/sphere-bullets");
        velocity.set(0, -5);
        count = 0;
        hitBox = new BoxCollider(this, 24, 24);
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        //Bullet tim` enemy:
//        count++;
//        if (count > 120) {
//            Enemy enemy = GameObject.find(Enemy.class);
//            if (enemy != null) {
//                Vector2D bulletToEnemy = enemy.position.clone();
//                bulletToEnemy.substract(this.position);
//                bulletToEnemy.setLength(5);
//                this.velocity.set(bulletToEnemy);
//            }
//        }
        checkDeactiveIfNeeded();
        checkIntersects();
    }

    private void checkIntersects() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this);
        if (enemy != null){
            this.deactive();
//            enemy.deactive();
            enemy.takeDamage(damage);
        }
    }

    private void checkDeactiveIfNeeded() {
        if (this.position.y < -30) {
            this.deactive();
        }
    }
}
