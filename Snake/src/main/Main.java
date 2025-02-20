package main;

import modele.Snake;

import javax.swing.*;

/**
 * This class allow to start the snake game
 */
public class Main {

    // Méthode principale (main) qui va lancer la fenêtre
    public static void main(String[] args) {
        JFrame window = new JFrame("Snake"); // Pemet de crée une nouvelle fenêtre
        window.setSize(1200, 1200); // Taille de la fenêtre
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permet de fermer la fenêtre et terminer l'execution en même temps
        window.setResizable(false);
        window.setLocationRelativeTo(null); // Centre la fenêtre

        GamePanel panel = new GamePanel(); // Permet de faire un nouveau panneau graphique sur lequel on peut dessiner avec la class GamePanel
        window.add(panel); // Ajoute le panneau graphique à la fenêtre

        window.setVisible(true);
    }
}