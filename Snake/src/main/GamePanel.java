package main;

import modele.Food;
import modele.Snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class allows to create a window for the game Snake
 */
public class GamePanel extends JPanel  implements KeyListener{

    /** The snake */
    private Snake snake; // Permet de créer un nouveau tableau de point pour le serpent (snake)
    private Food apple;
    /** The size of the segment */
    private final int segmentSize = 20;
    /** The game over */
    private boolean gameOver = false;

    /**
     * Constructor of the class GamePanel
     */
    public GamePanel() {
        setBackground(new Color(62,  111,  62)); // Définis la couleur de fond de la fenêtre

        snake = new Snake(segmentSize); // Permet de créer un nouveau tableau de point
        apple = new Food(segmentSize, snake); // Permet de créer une nouvelle pomme

        // Configure un Timer pour déplacer le serpent toutes les 100 ms
        Timer timer = new Timer(100, actionEvent -> {

            // si le snake touche un bord d'une fenêtre, on met fin au jeu
            if (snake.move(getWidth(),  getHeight(), segmentSize, apple))  {
                this.gameOver = true;
                ((Timer) actionEvent.getSource()).stop();
            }

            // Si le snake se touche lui-même on met fin au jeu
            if (snake.isCollidingWithItself())  {
                this.gameOver = true;
                ((Timer) actionEvent.getSource()).stop();
            }

            repaint(); // Redessine le panneau
        });
        timer.start();

        this.addKeyListener(this);  // Enregistre GamePanel comme écouteur de clavier
        this.setFocusable(true); // Permet au panneau de capter les événements clavier
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
        Toolkit.getDefaultToolkit().sync(); // Assure la synchro sur certains OS

        apple.draw(g);
        if (apple.isEaten()) {
            apple.generateFood();
        }

        if (gameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));

            String message = "Game Over";

            // Calcule la position du message pour le centrer
            FontMetrics metrics = g.getFontMetrics(); // Permet de récupérer les métriques de la police de caractère
            int x = (getWidth() - metrics.stringWidth(message)) / 2;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

            g.drawString(message, x, y);

        }

    }

    /**
     * This method allows to change the direction of the snake
     * @param event the key that has been pressed
     */
    @Override
    public void keyPressed(KeyEvent event)  {
        if(KeyEvent.VK_UP == event.getKeyCode())  {
            snake.changeDirection(0, -segmentSize);

        }else if (KeyEvent.VK_DOWN == event.getKeyCode()) {
            snake.changeDirection(0, segmentSize);

        } else if (KeyEvent.VK_RIGHT == event.getKeyCode()) {
            snake.changeDirection(segmentSize, 0);

        } else if (KeyEvent.VK_LEFT == event.getKeyCode()){
            snake.changeDirection(-segmentSize, 0);
        }
    }

    /**
     * This method allows to change the direction of the snake
     * @param event the key that has been released
     */
    @Override
    public void keyReleased(KeyEvent event)  {}

    /**
     * This method allows to change the direction of the snake
     * @param event the key that has been typed
     */
    @Override
    public void keyTyped(KeyEvent event)  {}


}