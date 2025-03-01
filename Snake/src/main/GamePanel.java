package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class allows to create a window for the game Snake
 */
public class GamePanel extends JPanel{

    private ArrayList<Point> snakeBody; // Permet de créer un tableau de point
    private int dx, dy; // Permet de définir la direction du serpent avec dx la direction horizontale et dy la direction verticale

    /**
     * Constructor of the class GamePanel
     */
    public GamePanel() {
        setBackground(new Color(62,  111,  62)); // Définis la couleur de fond de la fenêtre

        snakeBody = new ArrayList<>(); // Permet de créer un nouveau tableau de point
        snakeBody.add(new Point(100, 100)); // Permet d'ajouter un point au tableau de point

        dx = 10; // Permet de définir la direction horizontale du serpent
        dy = 0; // Permet de définir la direction verticale du serpent

        Timer timer = new Timer(100, actionEvent -> moveSnake());
        timer.start();
    }

    /**
     * This method allows to draw the snake on the window
     * @param g the graphic object used for drawing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Permet d'effacer l'écran avant de redessiner

        // Parcours l'arrayList snakeBody ainsi que chacun de ses segment afin de les dessinés
        for (Point segment : snakeBody) {
            g.fillRect(segment.x, segment.y, 20, 20); // Dessine le cube
            g.setColor(Color.white); // Définis la couleur du cube
        }
    }

    /**
     * This method allows to move the snake on the window with the direction dx and dy
     */
    public void moveSnake() {
        Point head = snakeBody.get(0); // récupère la tête actuel
        Point newHead = new Point(head.x + dx, head.y + dy); // fait une nouvelle tête en ajoutant dx et dy
        snakeBody.add(0, newHead); // ajoute la nouvelle tête
        snakeBody.remove(snakeBody.size()-1); // enlève le dernier cube
    }
}