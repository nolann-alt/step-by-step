/*
Déclarez les morceaux de votre playlist
Commençons par faire un inventaire des CD en votre possession.

Déclarez un tableau playlist qui contiendra trois de vos morceaux préférés.

Stockez le nombre de morceaux disponibles dans une variable totalMorceaux.

Ajoutez les morceaux de vos amis
Pour plaire à tout le monde, vous décidez de laisser vos amis choisir deux morceaux supplémentaires pour compléter votre collection.

Ajoutez deux morceaux au tableau playlist de manière à porter le total à cinq morceaux.

Enlevez le dernier morceau de votre playlist
Malheureusement, certains ne sont pas d’accord avec le dernier morceau ajouté. Il va falloir faire du tri ! 😱

Supprimez le dernier morceau ajouté à votre collection.
*/

const playlist = ["duvet", "misted", "Super Trouper"];
const totalMorceau = playlist.length;

playlist.push("Not Allowed", "Papercut");

playlist.pop("Papercut");

let message = "Voici la playlist : [" + playlist + "] avec " + totalMorceau + " morceaux"
console.log(message)