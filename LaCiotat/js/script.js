document.addEventListener('DOMContentLoaded', () => {
    // Cibler la barre de naviguation
    const navBar = document.getElementById('nav-bar');

// Fonction pour changer l'apparence de la navbar au scroll
    console.log(window.scrollY);
    window.addEventListener('scroll', () => {
        if (window.scrollY > window.innerHeight) { // innerHeight = hauteur de la fenêtre visible soit 100vh
            navBar.classList.add('scrolled');
        }else {
            navBar.classList.remove('scrolled');
        }
    });
});
console.log("script chargé")
