document.addEventListener('DOMContentLoaded', () => {
    // Cibler la barre de naviguation
    const navBar = document.getElementById('nav-bar');
    const localisation = document.querySelector('.localisation');
    let lastScrollY = window.scrollY;

// Fonction pour changer l'apparence de la navbar au scroll
    console.log(window.scrollY);
    window.addEventListener('scroll', () => {
        const topLocalisation = localisation.offsetTop;

        if (window.scrollY < topLocalisation - 60) {
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
        } else  {

            if (window.scrollY < topLocalisation) {
                gsap.to(navBar, {
                    top: "-30vh",
                    duration: 0.3,
                    ease: "power1.out" // Effet d'animation doux
                });

            } else {
                gsap.to(navBar, {
                    top: "0",
                    duration: 0.3,
                    ease: "power1.out"
                });
            }
        }

        if (window.scrollY > window.innerHeight - 60) { // innerHeight = hauteur de la fenêtre visible soit 100vh
            navBar.classList.add('scrolled');
        } else {
            navBar.classList.remove('scrolled');
        }

        lastScrollY = window.scrollY;

    });
});
console.log("script chargé")
