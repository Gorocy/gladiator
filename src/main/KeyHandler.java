package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, gPressed, itemsPressed, interactPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
//        int code2 = e.getKeyCode();

        if(code == KeyEvent.VK_U){
            interactPressed = true;
        }
        if(code == KeyEvent.VK_I){
            itemsPressed = true;
        }
        if (code == KeyEvent.VK_G) {
            gPressed = true;
        }
        if (code == KeyEvent.VK_S){
            downPressed = true;
        }else if (code == KeyEvent.VK_W) {
            upPressed = true;
        }

        if (code == KeyEvent.VK_A){
            leftPressed = true;
        } else if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_I){
            itemsPressed = false;
        }
        if (code == KeyEvent.VK_G) {
            gPressed = false;
        }
        if(code == KeyEvent.VK_U){
            interactPressed = false;
        }

        if (code == KeyEvent.VK_S){
            downPressed = false;
        } else if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_A){
            leftPressed = false;
        } else if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
