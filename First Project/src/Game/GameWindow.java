package Game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isIsFirePress1;

    public GameWindow() {
        // bat su kien bam phim
        KeyAdapter keyHandler = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_F){
                    isIsFirePress1 = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    isDownPress = false;
                }
                if ( e. getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_F){
                    isIsFirePress1 = false;
                }
            }
        };
        addKeyListener(keyHandler);
    }
}
