package Game.Enemy;

import Game.GameObject;
import Game.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject {
    public EnemyBullet(){
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/red.png");
        renderer = new Renderer(image);
        velocity.set(0,5);
    }
}
