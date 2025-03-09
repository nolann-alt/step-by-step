package modele;

import java.awt.*;
import java.rmi.ServerError;
import java.util.ArrayList;

/**
 *
 */
public class Food{

    private int x;
    private int y;
    private Snake snake;
    private final int appleSize;

    public Food(int appleSize, Snake snake) {
        this.appleSize = appleSize;
        this.snake = snake;

        generateFood();
    }

    public void generateFood() {
        boolean validPosition = true;
        int maxAttempts = 1000;
        int attempts = 0;
        int newX;
        int newY;

        do {
            newY = (int) (Math.random() * 60) * 20;
            newX = (int) (Math.random() * 60) * 20;

            // Verifie si  la nourriture est sur le serpent
            for (Point segment : snake.getSnakeBody()) {
                if (newX == segment.x && newY == segment.y) {
                    validPosition = false;
                }
            }

            // Verifie si la nourriture n'est pas à la position précédente
            if (newX == x && newY == y) {
                validPosition = false;
            }

            attempts++;

        } while(!validPosition && attempts < maxAttempts);

        if (validPosition) {
            this.x = newX;
            this.y = newY;

        } else {
            System.err.println("Imposssible de generer une pomme, la grille est pleine ?");
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, appleSize, appleSize);
    }

    public boolean isEaten() {
        boolean eaten = false;

        Point head = snake.getSnakeHead();
        if (head.x == x && head.y == y) {
            eaten = true;
        }
        return eaten;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


