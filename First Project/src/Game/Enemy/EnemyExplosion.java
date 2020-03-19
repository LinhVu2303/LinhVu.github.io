package Game.Enemy;

import Game.GameObject;
import Game.renderer.Renderer;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion(){
        this.renderer = new Renderer("assets/images/enemies/explosion-big", true);
    }
}
