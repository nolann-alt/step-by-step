/*
Déclarez le nouveau ticket de cinéma
Un ticket de cinéma a plusieurs propriétés : un nom de film, un prix, un numéro de salle.

Déclarez un objet ticket avec les propriétés suivantes :

nomFilm ;

prix ;

numeroSalle.

Déclarez une variable nom avec votre nom.

Affichez les informations sur la borne
Affichez un message sur la borne : “Bonjour NOM, votre film NOMDEFILM est en salle NUMERODELASALLE”.

Créez une variable texteAffichage qui contient cette phrase, avec NOM, NOMDEFILM et NUMERODELASALLE remplacés par leur vraie valeur.

Vérifiez le résultat avec un console.log.
*/

const ticket = {
    nomFilm: "Cars",
    prix: 6,
    numeroSalle: 2
}

let nom = "lescop";

let texteAffichage = "Bonjour " + nom + ", votre film " + ticket.nomFilm + " est en salle " + ticket.numeroSalle;
console.log(texteAffichage);

