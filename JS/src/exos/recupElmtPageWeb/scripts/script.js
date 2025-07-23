/** le score du joueur */
let score = 0
/** la taille de la liste actuelle */
let taille = listeMots.length

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
    afficherProposition(listeMots[i].valueOf())
    valider.addEventListener("click", () => {
        if (listeMots[i+1] === undefined) {
            if (listeMots[i] === inputEcriture.value) {
                score++
            } else {
                if (score > 0) {
                    score--
                }
            }
            afficherScore(score, taille)
            afficherProposition("le jeu est fini !")
            inputEcriture.value = ""
            valider.disabled = true
        } else {
            if (listeMots[i] === inputEcriture.value) {
                score++
            } else {
                if (score > 0) {
                    score--
                }
            }
            console.log(`le message est : ${inputEcriture.value}`)
            console.log(`le mot numéro ${i+2} est : ${listeMots[i+1]}`)
            afficherProposition(listeMots[i+1])
            i++
            afficherScore(score, taille)
            inputEcriture.value = ""
        }
    })

    afficherScore(score, taille)
}