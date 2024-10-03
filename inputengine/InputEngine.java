package inputengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputEngine implements KeyListener {
    private boolean[] keys = new boolean[256];

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {}

    public boolean isKeyPressed(int keyCode) {
        return keys[keyCode];
    }
}
