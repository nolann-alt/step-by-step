package modele;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class allows to manage the movement of the snake on the window
 */
public class Snake {

    /** The body of the snake */
    private ArrayList<Point> snakeBody;
    /** The direction of the snake */
    private int dx, dy;
    /** The size of the segment */
    private final int segmentSize = 20;

    /**
     * Constructor of the class Snake
     */
    public Snake(){

        snakeBody = new ArrayList<>(); // Permet de créer un nouveau tableau de point
        snakeBody.add(new Point(100, 100));

        dx = 10; // Permet de définir la direction horizontale du serpent
        dy = 0; // Permet de définir la direction verticale du serpent
    }

    /**
     * This method allows to move the snake on the window with the direction dx and dy and the keyListener
     */
    public void move() {
        Point head = snakeBody.get(0); // Récupère la tête actuelle
        Point newHead = new Point(head.x + dx, head.y + dy); // Calcule la nouvelle tête
        snakeBody.add(0, newHead); // Ajoute la nouvelle tête
        snakeBody.remove(snakeBody.size() - 1); // Supprime le dernier segment
    }

    public void changeDirection() {

    }

    public ArrayList<Point> getSnakeBody () {
        return this.snakeBody;
    }

}