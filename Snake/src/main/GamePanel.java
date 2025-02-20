package main;
import javax.swing.JFrame; // Import de Swing

/**
 * This class allows to create a window for the game Snake
 */
public class GamePanel extends JFrame{

    public GamePanel() {
        super("Snake"); // 1 Définir un titre pour la fenêtre
        setSize(500, 400); // 2 Définir une taille (exemple : 500x400)
        // 3 Indiquer quoi faire quand on clique sur la croix (fermer l'application)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); // 4 Afficher la fenêtre
    }

    // Méthode principale (main) qui va lancer la fenêtre
    public static void main(String[] args) {
        new GamePanel();
    }
}