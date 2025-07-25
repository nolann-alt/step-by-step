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

    afficherScore(score, taille)
}



