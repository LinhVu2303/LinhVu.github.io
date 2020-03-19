package Game;

public class Rectangle {
    public Vector2D position;
    public int width;
    public int height;

    public Rectangle(Vector2D position, int width, int height){
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public double top(){
        return this.position.y;
    }
    public double bot(){
        return this.top() + this.height;
    }
    public double left(){
        return this.position.x;
    }
    public double right(){
        return this.left() + this.width;
    }

    public boolean intersects(Rectangle other){
        return other.right() >=  this.left()  && other.left() <= this.right()
                && other.top() <= this.bot() && other.bot() >= this.top();
    }

//    public static void main(String[] args) {
//        Rectangle r1 = new Rectangle(new Vector2D(1,1), 3,3);
//        Rectangle r2 = new Rectangle(new Vector2D(2,2), 3,3);
//        Rectangle r3 = new Rectangle(new Vector2D(4.5,4.5), 3,3);
//        System.out.println(r1.intersects(r2) + " " + true);
//        System.out.println(r2.intersects(r3) + " " + true);
//        System.out.println(r1.intersects(r3) + " " + false);
//    }
}
