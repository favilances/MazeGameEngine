package renderengine;

import java.awt.Graphics;
import main.GameObject;

public class RenderEngine {

    public void render(Graphics g, GameObject object) {
        g.setColor(object.getColor());
        g.fillRect(object.getX(), object.getY(), object.getWidth(), object.getHeight());
    }
}
