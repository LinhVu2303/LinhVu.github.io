package Game.Player;

import Game.GameObject;
import Game.GameWindow;
import Game.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {

    ArrayList<PlayerBullet> bullets;


    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position.set(300,500);
        bullets = new ArrayList<>();
    }

    public void render(Graphics g) {
        super.render(g);
        for (int i = 0; i < bullets.size(); i++) {
            PlayerBullet bullet = bullets.get(i);
            bullet.render(g);
        }
    }

    @Override
    public void run() {
        super.run();
        move();
        limit();
        fire();
        bulletsRun();;
    }

    private void limit() {
        if (position.x < 0) {
            position.set(0, position.y);
        }
        if (position.x > Setting.BACKGROUND_WIDTH - image.getWidth()) {
            position.set(Setting.BACKGROUND_WIDTH - image.getWidth(), position.y);
        }
        if (position.y < 0) {
            position.set(position.x, 0);
        }
        if (position.y > Setting.GAME_HEIGHT - image.getHeight()) {
            position.set(position.x, Setting.GAME_HEIGHT - image.getHeight());
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
                PlayerBullet bullet = new PlayerBullet();
                bullet.position.set(position.x, position.y);
                bullet.velocity.setAngel(-Math.PI - i * (1));
                bullets.add(bullet);
            }
            fireCount = 0;
        }
    }

        private void bulletsRun () {
            for (int i = 0; i < bullets.size(); i++) {
                PlayerBullet bullet = bullets.get(i);
                bullet.run();
            }
    }
}