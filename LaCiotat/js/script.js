document.addEventListener('DOMContentLoaded', () => {
    // Cibler la barre de naviguation
    const navBar = document.getElementById('nav-bar');
    let lastScrollY = window.scrollY;

// Fonction pour changer l'apparence de la navbar au scroll
    console.log(window.scrollY);
    window.addEventListener('scroll', () => {
        if (window.scrollY > lastScrollY) {

            gsap.to(navBar, {
                top: "-30vh",
                duration: 0.3,
                ease: "power1.out" // Effet d'animation doux
            });

        } else {
            gsap.to(navBar, {
                top: 0,
                duration: 0.3,
                ease: "power1.out"
            });
        }

        lastScrollY = window.scrollY;

        if (window.scrollY > window.innerHeight - 60) { // innerHeight = hauteur de la fenêtre visible soit 100vh
            navBar.classList.add('scrolled');
        } else {
            navBar.classList.remove('scrolled');
        }
    });
});
console.log("script chargé")
