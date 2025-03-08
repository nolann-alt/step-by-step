package main;

import modele.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * This class allows to create a window for the game Snake
 */
public class GamePanel extends JPanel  implements KeyListener{

    /** The snake */
    private Snake snake; // Permet de créer un nouveau tableau de point pour le serpent (snake)

    /**
     * Constructor of the class GamePanel
     */
    public GamePanel() {
        setBackground(new Color(62,  111,  62)); // Définis la couleur de fond de la fenêtre

        snake = new Snake(); // Permet de créer un nouveau tableau de point

        // Configure un Timer pour déplacer le serpent toutes les 100 ms
        Timer timer = new Timer(100, actionEvent -> {
            snake.move(); // Déplace le serpent
            repaint(); // Redessine le panneau
        });
        timer.start();

        this.addKeyListener(this);  // Enregistre GamePanel comme écouteur de clavier
        this.setFocusable(true);    // Permet au panneau de capter les événements clavier

    }

    /**
     * This method allows to draw the snake on the window
     * @param g the graphic object used for drawing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Permet d'effacer l'écran avant de redessiner

        // Parcours l'arrayList snakeBody ainsi que chacun de ses segment afin de les dessinés
        for (Point segment : snake.getSnakeBody()) {
            g.setColor(Color.white); // Définis la couleur du cube
            g.fillRect(segment.x, segment.y, 20, 20); // Dessine le cube

        }
    }

    @Override
    public void keyPressed(KeyEvent event)  {
        if(KeyEvent.VK_UP == event.getKeyCode())  {
            snake.setDirection()
        }
    }

    @Override
    public void keyReleased(KeyEvent event)  {}

    @Override
    public void keyTyped(KeyEvent event)  {}


}