let score = 0
let choix = null
let taille = 0
let listActuel = []

function choisirPhraseOuMots() {
    do {
        choix = prompt("Veux-tu la liste de phrases (1) ou la liste de mots (2) ?")
        if (choix !== "1" && choix !== "2") {
            window.alert("le choix est incorrect veuillez réessayer")
        }
    } while (choix !== "1" && choix !== "2")
}

function lancerBoucleDeJeu() {
    initialiserListe()

    let motActuel = 1
    let i = 0
    while (i < listActuel.length) {

        let motUtilisateur = prompt("Entrez le mot numéro " + motActuel + " contenu la case du tableau : " + "["+ listActuel +"]")

        switch (motUtilisateur) {
            case listActuel[motActuel-1]:
                while (motUtilisateur !== listActuel[motActuel-1]) {
                    let motUtilisateur = prompt("Entrez le mot numéro " + motActuel + " contenu la case du tableau : " + "["+ listActuel +"]")
                    if (motUtilisateur !== listActuel[motActuel-1]) {
                        window.alert("le mot est incorrect veuillez réessayer")
                    }
                }
                score++
                motActuel++
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


function initialiserListe() {
    switch (choix) {
        case choix = "1":
            listActuel = listeMots
            taille = listeMots.length
            break
        case choix = "2":
            listActuel = listePhrases
            taille = listePhrases.length
            break
        default:
            console.log("La liste actuel a été changée")
    }
    window.alert(taille)
    return taille
}

function afficherResultat(resultat, nbTotalMots) {
    console.log("Le score est de : " + resultat + " sur " + nbTotalMots)
    window.alert("Le score est de : " + resultat + " sur " + nbTotalMots)
    console.log("Fin du jeu")
    window.alert("Fin du jeu")
}


function lancerJeu() {
    choisirPhraseOuMots()
    lancerBoucleDeJeu()
    afficherResultat(score, taille)
}