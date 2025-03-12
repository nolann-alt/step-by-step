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

    /**
     * Constructor of the class Food
     * @param appleSize the size of the apple
     * @param snake the snake
     */
    public Food(int appleSize, Snake snake) {
        this.appleSize = appleSize;
        this.snake = snake;

        generateFood();
    }

    /**
     * This method allows to generate the food on the window
     */
    public void generateFood() {
        boolean validPosition = true;
        int maxAttempts = 1000;
        int attempts = 0;
        int newX;
        int newY;

        do {
            newY = (int) (Math.random() * 30) * 20;
            newX = (int) (Math.random() * 30) * 20;

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

    /**
     * This method allows to check if the food is eaten
     * @return true if the food is eaten, false otherwise
     */
    public boolean isEaten() {
        boolean eaten = false;

        Point head = snake.getSnakeHead();
        if (head.x == x && head.y == y) {
            eaten = true;
        }
        return eaten;
    }

    /**
     * This method allows to get the x position of the food
     * @return the x position of the food
     */
    public int getX() {
        return x;
    }

    /**
     * This method allows to get the y position of the food
     * @return the y position of the food
     */
    public int getY() {
        return y;
    }
}


