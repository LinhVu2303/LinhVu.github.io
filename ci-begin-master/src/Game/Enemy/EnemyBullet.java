package Game.Enemy;

import Game.GameObject;
import Game.Setting;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
        renderer = new Renderer(image);
        velocity.set(0,5);
    }

    @Override
    public void run(){
        super.run();
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y > Setting.GAME_HEIGHT + 50){
            this.deactive();
        }
    }
}
