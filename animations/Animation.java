package animations;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {
    private BufferedImage[] frames;
    private int currentFrame;
    private long lastFrameTime;
    private long frameDelay;

    public Animation(BufferedImage[] frames, long frameDelay) {
        this.frames = frames;
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.lastFrameTime = System.currentTimeMillis();
    }

    public void update() {
        if (System.currentTimeMillis() - lastFrameTime >= frameDelay) {
            currentFrame = (currentFrame + 1) % frames.length;
            lastFrameTime = System.currentTimeMillis();
        }
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(frames[currentFrame], x, y, null);
    }
}
