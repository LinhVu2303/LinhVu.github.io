package Game.Enemy;

import Game.GameObject;
import Game.Player.Player;
import Game.Setting;
import Game.physic.BoxCollider;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    int damage;

    public EnemyBullet(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
        renderer = new Renderer(image);
        velocity.set(0,5);
        hitBox = new BoxCollider(this, 16,16);
        damage = 1;
    }

    @Override
    public void run(){
        super.run();
        deactiveIfNeeded();
        checkIntersects();
    }

    private void checkIntersects() {
        Player player = GameObject.findIntersects(Player.class,this);
            if (player != null){
                this.deactive();
                player.takeDamage(damage);
            }
        }

    private void deactiveIfNeeded() {
        if(this.position.y > Setting.GAME_HEIGHT + 50){
            this.deactive();
        }
    }
}
