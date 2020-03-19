package Game.Player;

import Game.GameObject;
import Game.renderer.Renderer;

public class PlayerExplosion extends GameObject {
    public PlayerExplosion(){
        this.renderer = new Renderer("assets/images/players/explosions", true);
    }
}
