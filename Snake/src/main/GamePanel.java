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

    @Override
    /**
     * This method allows to draw the snake on the window
     */
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
        Point head = snakeBody.get(0); // On récupère la tête du snake
        head.x += dx; // On déplace la tête horizontalement en ajoutant dx
        head.y += dy; // On déplace la tête verticalement en ajoutant dy

        for (int i = snakeBody.size(); i > 0; i--) {
            Point current = snakeBody.get(i); // on récupère le cube actuel
            Point previous = snakeBody.get(i-1); // on récupère le cube précédent
            current.setLocation(previous.x, previous.y); // Pemet de déplacer le cube actuel à la place du précédent afin que le snake avance
        }
    }
}