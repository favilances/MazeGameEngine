package physicsengine;

import core.GameObject;
import core.Vector2D;
import java.awt.Rectangle;

public class Collision {

    public static boolean detectCollision(GameObject obj1, GameObject obj2) {
        Rectangle bounds1 = obj1.getBounds();
        Rectangle bounds2 = obj2.getBounds();
        return bounds1.intersects(bounds2);
    }

    public static void resolveCollision(GameObject obj1, GameObject obj2) {
        if (detectCollision(obj1, obj2)) {
            Vector2D collisionNormal = new Vector2D(
                    obj2.getBounds().getCenterX() - obj1.getBounds().getCenterX(),
                    obj2.getBounds().getCenterY() - obj1.getBounds().getCenterY()
            ).normalize();

            obj1.applyForce(collisionNormal.multiply(-50));
            obj2.applyForce(collisionNormal.multiply(50));
        }
    }
}
