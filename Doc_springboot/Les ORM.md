# Les ORM en Spring

## 1. Qu'est-ce qu'un ORM ?

L'ORM (Object-Relationnal Mapping) est une technique de programmation qui permet de faire passerelle entre les BDD relationnelles et la POO. Cela permet d'éviter de coder directement en SQL et de gérer les échanges de données.

## 2. Qu'est-ce que Hibernate ?

C'est un framework open source en Java qui facilite la gestion de bases de données dans une application. Il automatise les conversions entre les objets et les données dans les tables relationnelles (c'est ce qu'on appelle un ORM).

## 3. Qu'est-ce que Spring Data JPA, et quel est son rapport avec Hibernate ?

Spring Data JPA est un framework d'accès aux données qui simplifie les interactions avec une BDD depuis une application Spring, en utilisant Java Persistence API (JPA).
La différence principale entre Spring Data JPA et Hibernate est que Hibernate utilise les contrats établis avec JPA (implémentations) et agi comme un JPA Provider, et Spring Data JPA utilise le JPA Provider pour simplifier le travail sur les BDDs (c'est comme un "plugin" de JPA).
Une autre information notable est que Spring Data JPA offre une solution au Domain-Driven Design Repository Pattern (qui permet de séparer la persistence et le system domain).

## 4. Qu'est-ce que JDBC, et quel est son rapport avec Hibernate ?

JDBC (Java DataBase Connectivity) est une API en Java qui permet de communiquer avec les BDDs. Elle nous permet d'écrire des requêtes en SQL par exemple. JPA l'utilise pour communiquer en SQL, depuis ses méthodes orientées en Java (d'où son lien avec Hibernate car Hibernate est un JPA Provider parmi d'autres).
