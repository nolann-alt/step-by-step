/** le score du joueur */
let score = 0
/** The actual list */
let listeProposition = listeMots;
/** la taille de la liste actuelle */
let taille = listeProposition.length

/**
 * Affiche le résultat du jeu dans la zone de score.
 * @param resultat Le score obtenu par le joueur.
 * @param nbTotalMots Le nombre total de mots ou phrases dans la liste.
 */
function afficherScore(resultat, nbTotalMots) {
    let zoneScore = document.querySelector(".zoneScore")
    let afficherResult = resultat + " / " + nbTotalMots
    zoneScore.innerHTML = `
    <p>${afficherResult}</p>
    `
}

/**
 * This finction allow to display an email.
 * @param nom the name of the user
 * @param email the email of the user
 * @param score the score of the user
 */
function afficherEmail(nom, email, score) {
    let mailto = `mailto:${email}?subject=Partage du score Azertype&body=Salut, je suis ${nom} et je viens de réaliser le score ${score} sur le site d'Azertype !`
    location.href = mailto
}

/**
 * This function allow to display the word she has in parameter
 * @param mot the word in parameter
 */
function afficherProposition(mot) {
    let divZoneProposition = document.querySelector(".zoneProposition")
    divZoneProposition.innerHTML = `${mot}`
}

/**
 * lance le jeu en lançant la boucle de jeu et en affichant le résultat.
 */
function lancerJeu() {
    let i = 0

    let inputEcriture = document.querySelector(".zoneSaisie #inputEcriture")
    let valider = document.querySelector(".zoneSaisie #btnValiderMot")
    let btnRadios = document.querySelectorAll("input[type=radio]");

    afficherProposition(listeProposition[i])

    function validerRep() {
        if (listeProposition[i + 1] === undefined) {
            if (listeProposition[i] === inputEcriture.value) {
                score++
            } else {
                if (score > 0) {
                    score--
                }
            }
            afficherScore(score, taille)
            afficherProposition("le jeu est fini !")
            inputEcriture.disabled = true;
            for (let h = 0; h < btnRadios.length; h++) {
                btnRadios[h].disabled = true;
            }
            valider.disabled = true
        } else {
            if (listeProposition[i] === inputEcriture.value) {
                score++
            } else {
                if (score > 0) {
                    score--
                }
            }
            console.log(`le message est : ${inputEcriture.value}`)
            console.log(`le mot numéro ${i + 2} est : ${listeProposition[i + 1]}`)
            afficherProposition(listeProposition[i + 1])
            i++
            afficherScore(score, taille)
            inputEcriture.value = ""
        }
    }

    inputEcriture.addEventListener('keyup', (e) => {
        if (e.code === "Enter") {
            validerRep();
        }
    });

    valider.addEventListener("click", () => {
        validerRep();
    })

    for (let j = 0; j < btnRadios.length; j++) {
        btnRadios[j].addEventListener("change", () => {
            console.log(btnRadios[i].value)
            if (btnRadios[j].value === "1") {
                listeProposition = listeMots;
                taille = listeMots.length;
                afficherScore(score, taille)
                afficherProposition(listeProposition[i]);
                console.log(listeProposition);
            } else {
                listeProposition = listePhrases;
                taille = listePhrases.length;
                console.log("la taille ! " + taille)
                afficherScore(score, taille)
                afficherProposition(listeProposition[i]);
                console.log(listeProposition);
            }
        });
    }
    const openBtn = document.getElementById("openPopup");
    const popup = document.getElementById("popupForm");
    const form = document.querySelector(".partageContainer .partagePopup form");

    // Au chargemement de la page
    popup.style.display = "none";

    openBtn.onclick = () => {
        popup.style.display = "block";
    }

    form.addEventListener("submit", (event) => {
        event.preventDefault();
        let nom = document.getElementById("nom");
        let email = document.getElementById("email");
        console.log(nom.value);
        console.log(email.value);

        let monScore = `${score} / ${taille}`;

        afficherEmail(nom.value, email.value, monScore);

        popup.style.display = "none";
    });


    afficherScore(score, taille)
}



