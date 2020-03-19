package Game.Enemy;

import Game.GameObject;
import Game.Setting;
import Game.physic.BoxCollider;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Enemy extends GameObject {
    int fireCount;
    int hp;

    public Enemy(){
        renderer = new Renderer("assets/images/enemies/level0/black");
        position.set(0, Setting.GAME_HEIGHT - Setting.BACKGROUND_HEIGHT);
        velocity.set(0, 3);
        fireCount = 0;
        hitBox = new BoxCollider(this, 32,32);
        hp = 10;
    }

    static Font font = new Font("Verdana", Font.BOLD, 20);
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(hp + "",(int) position.x, (int)position.y);
    }

    public void run(){
        super.run();
        changeDiretion();
        fire();
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (this.position.y > Setting.GAME_HEIGHT + 50){
            this.deactive();
        }
    }

    private void fire() {
        fireCount++;
        if (fireCount > 120){
//            EnemyBullet bullet = new EnemyBullet();
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
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

    public void takeDamage(int damage){
        hp -=  damage;
        if (hp <=0){
            hp = 0;
            this.deactive();
        }
    }

    @Override
    public void reset(){
        super.reset(); //active = true
        hp = 10;
    }

    @Override
    public void deactive() {
        super.deactive(); // active = false
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(position);
    }
}
