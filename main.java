import core.GameObject;
import core.GameWorld;
import ai.EnemyAI;
import inputengine.InputEngine;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel implements Runnable {
    private GameWorld world = new GameWorld();
    private InputEngine inputEngine = new InputEngine();
    private EnemyAI enemyAI;

    public Main() {
        // Oyuncu ve düşman nesnelerini oluştur
        GameObject player = new GameObject(100, 100, 1);  // Oyuncu nesnesi
        GameObject enemy = new GameObject(400, 300, 1);   // Düşman nesnesi

        // Oyuncu ve düşmanı dünyaya ekle
        world.addObject(player);
        world.addObject(enemy);

        // Düşman yapay zekasını oluştur (düşman, oyuncuyu 0.5 hızında takip edecek)
        enemyAI = new EnemyAI(enemy, player, 0.5);

        JFrame frame = new JFrame("Maze Game Engine");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(inputEngine);
        frame.setVisible(true);

        new Thread(this).start();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void run() {
        long lastTime = System.nanoTime();
        while (true) {
            long currentTime = System.nanoTime();
            double deltaTime = (currentTime - lastTime) / 1e9;
            lastTime = currentTime;

            updateGame(deltaTime);
            repaint();
            try {
                Thread.sleep(16);  // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame(double deltaTime) {
        enemyAI.update();
        world.update(deltaTime);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.render(g);
    }
}
