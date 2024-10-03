package physicsengine;

import core.GameObject;
import core.Vector2D;

public class PhysicsEngine {
    private Vector2D gravity = new Vector2D(0, 9.8);

    public void applyGravity(GameObject obj) {
        obj.applyForce(gravity);
    }

    public boolean detectCollision(GameObject obj1, GameObject obj2) {
        return obj1.getBounds().intersects(obj2.getBounds());
    }

    public void resolveCollision(GameObject obj1, GameObject obj2) {
        if (detectCollision(obj1, obj2)) {
            obj1.applyForce(new Vector2D(0, -50));
        }
    }
}
