package core;

import java.awt.Graphics;
import java.util.ArrayList;
import physicsengine.PhysicsEngine;

public class GameWorld {
    private ArrayList<GameObject> objects = new ArrayList<>();
    private PhysicsEngine physicsEngine = new PhysicsEngine();

    public void addObject(GameObject obj) {
        objects.add(obj);
    }

    public void update(double deltaTime) {
        for (GameObject obj : objects) {
            physicsEngine.applyGravity(obj);
            obj.update(deltaTime);
        }

        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                physicsEngine.resolveCollision(objects.get(i), objects.get(j));
            }
        }
    }

    public void render(Graphics g) {
        for (GameObject obj : objects) {
            obj.render(g);
        }
    }
}
