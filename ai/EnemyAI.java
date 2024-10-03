package ai;

import core.GameObject;
import core.Vector2D;

public class EnemyAI {
    private GameObject enemy;
    private GameObject player;
    private double speed;

    public EnemyAI(GameObject enemy, GameObject player, double speed) {
        this.enemy = enemy;
        this.player = player;
        this.speed = speed;
    }

    public void update() {
        Vector2D enemyPosition = enemy.getPosition();
        Vector2D playerPosition = player.getPosition();

        // Düşmanın oyuncuya olan yönünü hesaplar
        Vector2D directionToPlayer = new Vector2D(
                playerPosition.x - enemyPosition.x,
                playerPosition.y - enemyPosition.y
        ).normalize();

        // Düşmana oyuncuya doğru hareket ettirecek kuvvet uygular
        Vector2D movement = directionToPlayer.multiply(speed);
        enemy.applyForce(movement);
    }
}
