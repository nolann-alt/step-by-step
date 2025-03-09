package modele;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class allows to manage the movement of the snake on the window
 */
public class Snake {

    /** The body of the snake */
    private final ArrayList<Point> snakeBody;
    /** The direction of the snake */
    private int dx, dy;

    /**
     * Constructor of the class Snake
     */
    public Snake(int segmentSize){

        snakeBody = new ArrayList<>(); // Permet de créer un nouveau tableau de point
        snakeBody.add(new Point(100, 100));

        dx = segmentSize; // Permet de définir la direction horizontale du serpent
        dy = 0; // Permet de définir la direction verticale du serpent
    }

    /**
     * This method allows to move the snake on the window with the direction dx and dy and the keyListener
     */
    public boolean move(int windowWidth, int windowHeight,  int segmentSize, Food apple) {
        boolean out = false;
        
        Point head = snakeBody.get(0); // Récupère la tête actuelle
        Point newHead = new Point(head.x + dx, head.y + dy); // Calcule la nouvelle tête
        snakeBody.add(0, newHead); // Ajoute la nouvelle tête
        snakeBody.remove(snakeBody.size() - 1); // Supprime le dernier segment

        if (apple.isEaten()) {
            System.out.println(apple.isEaten());
            Point lastSegment = snakeBody.get(snakeBody.size() - 1);
            Point  newSegment = new Point(lastSegment.x - dx, lastSegment.y - dy);
            snakeBody.add(newSegment);
        }

        //  Verfie que la tête du serpent ne touche pas un bord de la fenêtre
        if (newHead.x < 0) {
            out = true;
        } else if (newHead.x + segmentSize > windowHeight) {
            out = true;
        } else if (newHead.y < 0) {
            out = true;
        } else if (newHead.y + segmentSize > windowWidth) {
            out = true;
        }
        return out;
    }

    /**
     * This method allows to change the direction of the snake
     * @param newDx the new direction of the snake on the x-axis
     * @param newDy the new direction of the snake on the y-axis
     */
    public void changeDirection(int newDx, int newDy) {
        if (dx != 0  && newDx != -dx || dy != 0 && newDy != -dy) {
            this.dx = newDx;
            this.dy = newDy;
        }
    }

    public boolean isCollidingWithItself() {
        boolean touch = false;
        Point head = snakeBody.get(0);

        for (int i = 1; i < snakeBody.size(); i++) {
            Point segment = snakeBody.get(i);

            if (segment.x == head.x && segment.y == head.y) {
                touch = true;
            }
        }
        return touch;
    }

    /**
     * This method allows to get the body of the snake
     * @return the body of the snake
     */
    public ArrayList<Point> getSnakeBody () {
        return new ArrayList<>(this.snakeBody);
    }

    public Point getSnakeHead () {
        return new Point(snakeBody.get(0));
    }

}