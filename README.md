# TP Spring Boot

* [Objectif du TP](#objectif-du-tp)
* [Explications des fichiers et répertoires](#explication-des-fichiers-et-répertoires)
* [Première partie](#première-partie)

## Objectif du TP

L'objectif du TP est de concevoir une API à partir d'une structure que nous vous fournissons. Ensuite vous allez devoir tester votre API en jouant avec les requêtes HTTP.
L'API sera sur la liste de notre classe, elle contiendra tous les élèves et permettra d'en rajouter/supprimer.

---

## Explication des fichiers et répertoires

| Fichier ou répertoire | Explication |
| ---- | ---- |
| pom.xml | fichier maven pour les dépendances |
| mvnw | exécutable maven pour linux/mac |
| mvnw.cmd | exécutable maven pour windows |
| src | répertoire contenant les sources |
| target | répertoire contenant les compilations et exécutables du projet |

---

## Première partie

### Structure des sources

La classe principale du projet est EleveApplication, vous n'aurez ni à la créer ni à la modifier.  
Les autres classes sont regroupées en 3 packages :
* controller : contient la classe **EleveController**, qui gère les requêtes HTTP entrantes
* service : contient la classe **EleveService**, qui gère la liste des élèves
* model : contient la classe **Eleve**, qui représente chaque Eleve

Dans les sources du projet, seule la récupération de la liste des élèves est implémentée. Dans un premier temps, vous allez tester cela avec une requêtes HTTP avant de commencer à développer de nouvelles fonctionnalités dans l'API. Cette étape de vérification est importante pour partir sur de bonnes bases.

### 1 - Lancer l’application et récupérer la liste de tous les élèves.

***Tips : l’url par défaut de l’API est : http://localhost:8080/eleve***

### 2 - A partir de la méthode getAll() de EleveController et des informations du TP, écrire les méthodes suivantes:

**Attention** : pour chaque nouvelle méthode dans EleveController, vous devrez créer une méthode gérant la liste (accès, ajout, modification, suppression, etc...) dans EleveService. 

* getOne(@PathVariable int index) de type GET
Méthode permettant de récupérer un seul étudiant grâce à son index dans la liste.

* add(@RequestBody Eleve eleve) de type POST
Méthode permettant d’ajouter un élève à la liste.

* delete(@PathVariable int index) de type DELETE
Méthode permettant de supprimer un élève de la liste.

* getDelegue() de type GET
Méthode permettant de récupérer les élèves délégué de la classe.

***Tips :***

Annotation de méthode :

| Annotation | Objectif |
| ---- | ---- |
| @GetMapping | permet à Spring Boot de savoir que votre méthode gère les requêtes HTTP Get |
| @GetMapping(path = "{index}") | identique mais permet de spécifier qu'il y a une variable qui sera passée dans l'URL  ( {index} -> variable index) |

Idem avec @PostMapping, @PutMapping et @DeleteMapping

Annotation de paramètre :

| Annotation | Objectif |
| ---- | ---- |
| @PathVariable | récupère une donnée dans l’url (exemple : /eleve/1 -> 1) |
| @RequestBody | récupère des données JSON du corps (body) de la requête et les transforme en classe (dans notre cas la classe Eleve) |

Méthode exemple avec des annotations :
```java
@GetMapping(path = "{index}")
public Object exemple(@PathVariable int index) {
    ...
}
```

Voici l’exemple d’une requête HTTP utilisant le type GET :

```
GET http://localhost:8080/eleve 
``` 
 
Voici l’exemple d’une requête HTTP utilisant le type POST : (le format et la structure du JSON sont important)

```
POST http://localhost:8080/eleve
Content-type : application/json

{”nom”: “DUPONT”, “prenom”:”Jean”,”delegue”: true}
```

### 3 - Tester les méthodes écrites précédemment avec des requêtes HTTP :

***Tips : afficher la liste entière des élèves pour vérifier si votre requête a fonctionnée***

* Afficher l’élève numéro 10
* Ajouter un nouvel élève
* Supprimer l’élève 14
* Afficher les délégués

---

## Deuxième partie pour allez plus loin (bonus)