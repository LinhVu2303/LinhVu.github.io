package Game;

import Game.Enemy.Enemy;
import Game.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    Player player;
    Background background;
    ArrayList<Enemy> enemies;

    public GamePanel() {
        background = new Background();
        player = new Player();
        enemies = new ArrayList<>();
    }

    public void gameLoop() {
        long lastLoop = 0;
        long delay = 1000 / 60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastLoop > delay) {
                runAll(); // logic game
                renderAll(); // render anh cua game
                lastLoop = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint(); // goi lai ham paint()
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active){
                object.render(g);
            }
        }
    }

    private void runAll() {
        for (int i = 0; i < GameObject.objects.size() ; i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.run();
            }
        }
        summon();
    }


    int summonCount;
    int wayCount;
    int enemyCount;
    Random random = new Random();
    int xEnemy = 100 + random.nextInt(200);
    private void summon() {
        wayCount++;
        if (wayCount > 120) {
            summonCount++;
            if (summonCount > 20) {
//                Enemy enemy = new Enemy();
                Enemy enemy = GameObject.recycle(Enemy.class);
                enemy.position.set(xEnemy, -100);
                enemy.velocity.setAngel(Math.PI/9);
                enemies.add(enemy);
                summonCount = 0;
                enemyCount++;
                if (enemyCount > 10){
                    wayCount = 0;
                    enemyCount = 0;
                    xEnemy = random.nextInt(100 + random.nextInt(200));
                }
            }
        }
    }
}

