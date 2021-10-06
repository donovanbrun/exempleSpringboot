# TP Spring Boot

* [Objectif du TP](#objectif-du-tp)
* [Explications des fichiers et répertoires](#explication-des-fichiers-et-répertoires)
* [Première partie](#première-partie)
* [Deuxième partie bonus](#deuxième-partie-pour-allez-plus-loin-(bonus))

## Objectif du TP

L'objectif du TP est de concevoir une API à partir d'une structure que nous vous fournissons. Ensuite vous allez devoir tester votre API en jouant avec les requêtes HTTP.
L'API sera sur la liste de notre classe, elle contiendra tous les élèves et permettra d'en rajouter/supprimer.  
Il n'y a pas de base de données pour la première partie du TP. Les données sont stockées en dur, il suffit de relancer l'API pour tout réinitialiser (vous pouvez donc tout casser).

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

Pour envoyer la requête, vous pouvez tout simplement utiliser un navigateur web, ou [Postman](https://www.postman.com/downloads/) qui vous sera utile pour la suite du TP.

***Tips : l’url par défaut de l’API est : http://localhost:8080/eleve***

### 2 - A partir de la méthode getAll() de EleveController et des informations du TP, écrire les méthodes suivantes:

**Attention** : pour chaque nouvelle méthode dans EleveController, vous devrez créer une méthode gérant la liste (accès, ajout, modification, suppression, etc...) dans EleveService. 

### a) getOne(@PathVariable int index) de type GET. ###
Méthode permettant de récupérer un seul étudiant grâce à son index dans la liste.

Pour tester : afficher l’élève numéro 10

### b) add(@RequestBody Eleve eleve) de type POST. ###
Méthode permettant d’ajouter un élève à la liste.

Pour tester : ajouter un nouvel élève
(afficher la liste entière des élèves pour vérifier si votre requête a fonctionnée)

### c) delete(@PathVariable int index) de type DELETE. ###
Méthode permettant de supprimer un élève de la liste.

Pour tester : supprimer l’élève 14
(afficher la liste entière des élèves pour vérifier si votre requête a fonctionnée)

### d) getDelegue() de type GET. ###
Méthode permettant de récupérer les élèves délégué de la classe.

Pour tester : afficher les délégués

### ***Tips :*** ###

#### Annotation de méthode : ####

| Annotation | Objectif |
| ---- | ---- |
| @GetMapping | permet à Spring Boot de savoir que votre méthode gère les requêtes HTTP Get |
| @GetMapping(path = "{index}") | identique mais permet de spécifier qu'il y a une variable qui sera passée dans l'URL  ( {index} -> variable index) |

Idem avec @PostMapping, @PutMapping et @DeleteMapping

#### Annotation de paramètre : ####

| Annotation | Objectif |
| ---- | ---- |
| @PathVariable | récupère une donnée dans l’url (exemple : /eleve/1 -> 1) |
| @RequestBody | récupère des données JSON du corps (body) de la requête et les transforme en classe (dans notre cas la classe Eleve) |

#### Méthode exemple avec des annotations : ####
URL : http://localhost:8080/path/{index}
```java
@GetMapping(path = "{index}")
public Object exemple(@PathVariable int index) {
    ...
}
```

#### Exemple d’une requête HTTP utilisant le type GET : ####

```
GET http://localhost:8080/eleve 
``` 

#### Exemple d’une requête HTTP de type POST : ####
(Le format et la structure du JSON sont importants)

```
POST http://localhost:8080/eleve
Content-type : application/json

{”nom”: “DUPONT”, “prenom”:”Jean”,”delegue”: true}
```

---

## Deuxième partie pour allez plus loin (bonus)

Cette partie est moins guidée, alors n'hésitez pas à chercher par vous même.
L'objectif est d'avoir une vraie persistance des données grâce à une base de données, nous avons choisi MongoDB mais si vous voulez vous pouvez utiliser une autre base de données.

Voici les étapes pour réussir cette partie :
* Mettre la dépendance MongoDB dans le pom.xml
* Recharger le projet maven pour inclure la nouvelle dépendance
* Configurer l'accès à la base de données dans le fichier src/main/resources/application.properties
* Créer le package Repository dans les sources puis l'interface EleveRepository en l'héritant de MongoRepository<Serie, Long> (cette héritage fait tout, pas besoin de rajouter des méthodes dans l'interface)
* Modifier EleveService pour qu'elle fasse appel à EleveRepository et n'utilise plus de liste
* Tester, bonne chance

### ***Tips :*** ###

#### Pour configurer la bdd : ####
```
spring.data.mongodb.database=eleves
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
```

#### Dépendance à mettre dans le pom.xml dans ```<dependencies>``` : ####
```xml
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-mongodb</artifactId>
    <version>3.2.1</version>
</dependency>
```