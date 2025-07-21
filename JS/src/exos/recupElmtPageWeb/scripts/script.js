let score = 0
// let choix = null
let taille = 0
let listActuel = []

// function choisirPhraseOuMots() {
//     do {
//         choix = prompt("Veux-tu la liste de phrases (1) ou la liste de mots (2) ?")
//         if (choix !== "1" && choix !== "2") {
//             window.alert("le choix est incorrect veuillez réessayer")
//         }
//     } while (choix !== "1" && choix !== "2")
// }

function lancerBoucleDeJeu() {
    listActuel = listeMots

    let i = 0
    while (i < listActuel.length) {

        let motUtilisateur = prompt("Entrez le mot numéro " + i+1 + " contenu la case du tableau : " + "["+ listActuel +"]")

        switch (motUtilisateur) {
            case listActuel[i]:
                while (motUtilisateur !== listActuel[i]) {
                    let motUtilisateur = prompt("Entrez le mot numéro " + i+1 + " contenu la case du tableau : " + "["+ listActuel +"]")
                    if (motUtilisateur !== listActuel[i]) {
                        window.alert("le mot est incorrect veuillez réessayer")
                    }
                }
                score++
                i++
                console.log("le mot est correct, le score est de : " + score)
                window.alert("le mot est correct, le score est de : " + score)
                break
            default:
                score--
                console.log("le mot est incorrect veuillez réessayer, le score est de : " + score)
                window.alert("le mot est incorrect veuillez réessayer, le score est de : " + score)
        }
    }
    return score
}


// function initialiserListe() {
//     switch (choix) {
//         case choix = "1":
//             listActuel = listeMots
//             taille = listeMots.length
//             break
//         case choix = "2":
//             listActuel = listePhrases
//             taille = listePhrases.length
//             break
//         default:
//             console.log("La liste actuel a été changée")
//     }
//     return taille
// }

function afficherResultat(resultat, nbTotalMots) {
    let zoneScore = document.querySelector(".zoneScore")
    let afficherResult = resultat + " / " + nbTotalMots
    zoneScore.innerHTML = `
    <p>${afficherResult}</p>
    `
}


function lancerJeu() {
    lancerBoucleDeJeu()
    afficherResultat(score, taille)
}