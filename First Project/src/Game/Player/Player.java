package Game.Player;

import Game.Enemy.Enemy;
import Game.GameObject;
import Game.GameWindow;
import Game.Setting;
import Game.physic.BoxCollider;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    int hp;

    public Player() {
        renderer = new Renderer("assets/images/players/straight");
        position.set(300,500);
        hitBox =new BoxCollider(this, 30,45);
        hp = 100;
    }

    static Font font = new Font("Time New Roman",Font.BOLD,20);
    @Override
    public void render(Graphics g){
        super.render(g);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString(hp + "",(int) position.x, (int)position.y);
    }

    @Override
    public void run() {
        super.run();
        move();
        limit();
        fire();

    }

    @Override
    public void deactive() {
        super.deactive();
        PlayerExplosion explosion = GameObject.recycle(PlayerExplosion.class);
        explosion.position.set(position);
    }

    public void takeDamage(int damage) {
        hp -= 5* damage;
        if(hp <= 0){
            hp = 0;
            this.deactive();
        }
    }

    private void limit() {
        if (position.x < 0) {
            position.set(0, position.y);
        }
        if (position.x > Setting.BACKGROUND_WIDTH - Setting.PLAYER_WIDTH) {
            position.set(Setting.BACKGROUND_WIDTH -Setting.PLAYER_WIDTH, position.y);
        }
        if (position.y < 0) {
            position.set(position.x, 0);
        }
        if (position.y > Setting.GAME_HEIGHT - Setting.PLAYER_HEIGHT) {
            position.set(position.x, Setting.GAME_HEIGHT - Setting.PLAYER_HEIGHT);
        }
    }

    private void move() {
        int speed = 3;
        int vx = 0;
        int vy = 0;
        if (GameWindow.isUpPress) {
            vy -= speed;
        }
        if (GameWindow.isDownPress) {
            vy += speed;
        }
        if (GameWindow.isLeftPress) {
            vx -= speed;
        }
        if (GameWindow.isRightPress) {
            vx += speed;
        }
        velocity.set(vx, vy);
        velocity.setLength(speed);
    }

    int fireCount;

    private void fire() {
        fireCount++;
        if (GameWindow.isFirePress && fireCount > 15) {
            for (int i = 0; i < 100; i++) {
//                PlayerBullet bullet = new PlayerBullet();
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                bullet.position.set(position.x, position.y);
                bullet.velocity.setAngel(-Math.PI - i * (1));
            }
            fireCount = 0;
        }
    }
}