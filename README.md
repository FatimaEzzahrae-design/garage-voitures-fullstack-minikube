Système de Gestion de Garage Automobile avec Recommandation IA
 1. Présentation du projet

Ce projet est une application full-stack de gestion de voitures pour un garage automobile, intégrant un module de recommandation intelligente basé sur des règles métier (IA métier).

L’application permet de :

Gérer un catalogue de véhicules
Consulter la liste des voitures disponibles
Ajouter de nouveaux véhicules
Obtenir des recommandations personnalisées selon un budget et un usage

Le système repose sur une architecture moderne distribuée utilisant Spring Boot, React, MariaDB et Docker.

 2. Objectifs du projet

Les principaux objectifs sont :

Concevoir une architecture client / serveur
Implémenter une API REST avec Spring Boot
Développer une interface utilisateur avec React
Intégrer une base de données relationnelle (MariaDB)
Conteneuriser l’ensemble de l’application avec Docker
Implémenter un module de recommandation intelligent basé sur des règles métier
 3. Module d’Intelligence (IA métier)

Le système de recommandation ne repose pas sur une bibliothèque d’IA externe, mais sur une logique métier avancée de scoring.

- Entrées :
Budget de l’utilisateur
Type d’usage (ville, famille)
- Logique de calcul :

Chaque véhicule est évalué selon :

Adéquation du prix avec le budget
Pertinence par rapport à l’usage
Critères techniques du véhicule (marque, modèle, année)
- Sortie :

Une liste de véhicules classés avec un score de pertinence

 Exemple de résultat :
{
  "voiture": {
    "marque": "Toyota",
    "modele": "Corolla",
    "prix": 95000
  },
  "score": 89.5
}

 4. Architecture du système

L’application suit une architecture en trois couches :

Interface utilisateur (React)
API REST (Spring Boot)
Logique métier + IA
Base de données (MariaDB)

 5. Architecture de déploiement (Docker)

L’application est entièrement conteneurisée :

frontend : React + Nginx
backend : Spring Boot
database : MariaDB
network : réseau Docker dédié

 6. Instructions d’exécution du projet
 1. Cloner le projet
git clone https://github.com/VOTRE_COMPTE/garage-voitures-fullstack.git
cd garage-voitures-fullstack
 2. Lancer l’application avec Docker Compose
docker-compose up --build

 7. Accès à l’application
Composant	            URL
Interface utilisateur	http://localhost:3000
API Backend         	http://localhost:8081
Recommandation IA	    http://localhost:8081/api/ai/recommend?budget=100000&usage=ville

 8. Technologies utilisées
- Backend
Java 17
Spring Boot 3
Spring Data JPA
Hibernate
REST API
- Frontend
React.js
Axios
HTML / CSS
- Base de données
MariaDB
- DevOps
Docker
Docker Compose
Nginx
 9. Configuration de la base de données
spring.datasource.url=jdbc:mariadb://mariadb:3306/nom_db
spring.datasource.username=root
spring.datasource.password=1234
 10. Structure du projet
backend/
frontend/
docker-compose.yml
README.md