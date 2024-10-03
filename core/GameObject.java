package core;

import java.awt.*;
import animations.Animation;

public class GameObject {
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration;
    private double mass;
    private Animation animation;
    private Rectangle bounds;

    public GameObject(double x, double y, double mass) {
        this.position = new Vector2D(x, y);
        this.velocity = new Vector2D(0, 0);
        this.acceleration = new Vector2D(0, 0);
        this.mass = mass;
        this.bounds = new Rectangle((int)x, (int)y, 50, 50);
    }

    public Vector2D getPosition() {
        return position;
    }

    public void applyForce(Vector2D force) {
        Vector2D f = force.multiply(1 / mass);
        acceleration = acceleration.add(f);
    }

    public void update(double deltaTime) {
        velocity = velocity.add(acceleration.multiply(deltaTime));
        position = position.add(velocity.multiply(deltaTime));
        bounds.setLocation((int)position.x, (int)position.y);
        acceleration.set(0, 0);
    }

    public void render(Graphics g) {
        if (animation != null) {
            animation.render(g, (int)position.x, (int)position.y);
        } else {
            g.setColor(Color.RED);
            g.fillRect((int)position.x, (int)position.y, bounds.width, bounds.height);
        }
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
