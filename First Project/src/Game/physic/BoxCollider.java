package Game.physic;

import Game.GameObject;
import Game.Vector2D;

import java.util.Vector;

public class BoxCollider {
    public Vector2D position;
    public Vector2D anchor;
    public int width;
    public int height;

    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.anchor = master.anchor;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return this.position.y - this.anchor.y * this.height;
    }

    public double bot() {
        return this.top() + this.height;
    }

    public double left() {
        return this.position.x - this.anchor.x * this.width;
    }

    public double right() {
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other) {
        return other.right() >= this.left()
                && other.left() <= this.right()
                && other.top() <= this.bot()
                && other.bot() >= this.top();
    }
}