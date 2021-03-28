# Preuves

## Je sais décrire le contexte de mon applciation, pour que n'importe qui soit capable de comprendre à quoi elle sert
Voir rapport.pdf

## Je sais concevoir et décrire un diagramme de cas d'utilisation pour mettre en avant les différentes fonctionnalités de mon application
Voir rapport.pdf

## Je sais concevoir un diagramme UML de qualité représentant mon application
Voir Diagram Class.pdf

## Je sais décrire mon diagramme UML en mettant en valeur et en justifiant les éléments essentiels
Voir Diagram Class.pdf

## Je sais utiliser les Intent pour faire communiquer deux activités.
MenuActivity.java instincie un GameActivity à la ligne 77.
GameActivity se lance à la ligne 78, MenuActivity lui se termine à la ligne 79.

## Je sais développer en utilisant le SDK le plus bas possible
Nous sommes descendu à un SDK 11.

## Je sais distinguer mes ressources en utilisant les qualifier
Les images sont dans le dossier "drawable", les layout dans "layout", ...

<!-- ## Je sais modifier le manifeste de l'application en fonction de mes besoins
Le fichier manifest a été modifié pour ajouter des vues, modifier l'orientation et permettre l'utilisation du micro. -->

## Je sais faire des vues xml en utilisant les layouts et composants adéquats
Les LinearLayout sont beaucoup utilisé, un RelativeLayout est aussi utilisé.

## Je sais coder proprement mes activités, en m'assurant qu'elles ne font que relayer les évènements
Aucun évènement est utilisé dans les activités.

## Je sais coder une application en ayant un véritable métier
La classe Skin représente un métier, une entité.

## Je sais parfaitement séparer vue et modèle
Les vues sont dans le package view, les modèles dans le package game.

## Je maîtrise le cycle de vie de mon application
On instantie un GameView dans le *onCreate()*, la théorie voudrait qu'on le mette en pause dans *onPause()* puis on le relance dans *onResume()*.

## Je sais utiliser le findViewById à bon escient
On utilise à multiples reprises cette méthode. Par exemple dans MyViewHolder.java à la ligne 22.

## Je sais gérer les permission dynamiques de mon application
On modifie notre manifest puis on demande la permission d'utilisation dans MenuActivity.java avec *onRequestPermissionResult()*, *requestPermission()* et *checkPermission()*.

## Je sais gérer les permissions dynamiques de mon application
/

## Je sais gérer la persistance légère et profonde de mon application
/

## Je sais afficher une collection de données
/

## Je sais coder mon propre adaptateur
La classe SkinListAdapter est un adaptateur.

## Je maîtrise l'usage des fragments
Les fragments sont utilisés statiquement et dynamiquement dans SkinList.java , Skin.java , DetailSkin.java afin de créer un Master-Detail.

## Je maîtrise l'utilisation de Git
Il y a eu des push réguliers sur Git.

## Je sais développer une application sans utiliser de librairie externe
Aucune bibliothèque externe a été utilisée.

## Je sais utiliser le Micro
L'utilisation du micro est implémentée.