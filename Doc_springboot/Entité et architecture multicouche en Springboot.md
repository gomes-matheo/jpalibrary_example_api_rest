## Qu'est-ce qu'une entité ?

Une entité est une instanciation de classe persistante ; C'est à dire qu'elle peut être sauvegardée (sérialisée) et/ou chargée depuis la mémoire de la machine, notamment via une base de données. Elle est signalée par l'annotation ```@Entity```. Elle utilise JPA (Java Persistance API).

## Comment Spring Boot met-il en place une architecture multicouche ?

Une architecture à multicouches est un modèle d'architecture servant à séparer les tâches et fonctions d'une application. Cela permet d'organiser, de rendre modulaire et donc de faciliter le maintien, et préparer l'évolution de l'application.
Springboot met cela en place de la manière suivante :
- La couche **Controller** ```@RestController``` (pour un contrôleur REST, pour gérer les requêtes API uniquement) ou ```@Controller``` (pour déclarer une classe comme un contrôleur, servant à gérer les requêtes et renvoyer des vues, par exemple une page HTML), qui s'occupe de recevoir et rediriger les requêtes, mais aussi de répondre au client. Elle communique uniquement avec la couche **Service**
- La couche **Service** ```@Service``` qui contient la logique métier (elle traite/modifie les données, et les redirige si besoin vers le **Repository**)
- La couche **Repository** ```@Repository```, la couche la plus basse du modèle, elle est responsable de l'accès aux données et de leur stockage, communiquant la plupart du temps avec une base de données. Il se charge des opérations **C**reate **R**ead **U**pdate **D**elete (**CRUD**).
![](Pasted%20image%2020260420143013.png)