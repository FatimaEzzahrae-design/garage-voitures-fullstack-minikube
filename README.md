Système de Gestion de Garage Automobile avec Recommandation IA

1. Présentation du projet

Ce projet est une application full-stack de gestion de voitures pour un garage automobile, intégrant un module de recommandation intelligente basé sur des règles métier (IA métier).

L’application permet de :

• Gérer un catalogue de véhicules 

• Consulter la liste des voitures disponibles 

• Ajouter et supprimer des véhicules 

• Obtenir des recommandations personnalisées selon un budget et un usage 

Le système repose sur une architecture moderne distribuée utilisant : React, Spring Boot, MariaDB, Docker & Kubernetes (Minikube)

2. Objectifs du projet
   
Les principaux objectifs sont :

• Concevoir une architecture client / serveur 

• Implémenter une API REST avec Spring Boot 

• Développer une interface utilisateur avec React 

• Intégrer une base de données relationnelle (MariaDB) 

• Conteneuriser et déployer l’application avec Docker & Kubernetes 

• Implémenter un module de recommandation intelligent basé sur des règles métier 

3. Module d’Intelligence (IA métier)
   
Le système de recommandation ne repose pas sur une bibliothèque d’IA externe, mais sur une logique métier avancée de scoring.

• Entrées :

• Budget de l’utilisateur 

• Type d’usage (ville, famille) 

• Logique de calcul :

Chaque véhicule est évalué selon :

• Adéquation du prix avec le budget 

• Pertinence par rapport à l’usage 

Un score est calculé pour chaque voiture afin de classer les résultats.

• Sortie :

Une liste de véhicules triés par pertinence.

• Exemple de résultat :

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

• Interface utilisateur (React) 

• API REST (Spring Boot) 

• Logique métier + module IA 

• Base de données (MariaDB) 

5. Architecture de déploiement (Kubernetes)
    
L’application est entièrement déployée sur Kubernetes (Minikube) :

• frontend : React + Nginx 

• backend : Spring Boot 

• database : MariaDB 

• services exposés via NodePort 

6. Instructions d’exécution du projet
    
1. Cloner le projet
   
git clone https://github.com/FatimaEzzahrae-design/garage-voitures-fullstack-minikube.git

cd garage-voitures-fullstack

2. Lancer avec Kubernetes
   
kubectl apply -f k8s/

3. Vérifier les pods
   
kubectl get pods

4. Vérifier les services
   
kubectl get svc

5. Accès à l’application
    
Composant               URL

Interface utilisateur     http://localhost:30080

API Backend               http://localhost:8081

Recommandation IA         http://localhost:8081/api/ai/recommend?budget=100000&usage=ville

7. Technologies utilisées
    
Backend

• Java 17 

• Spring Boot 3 

• Spring Data JPA 

• REST API 

Frontend

• React.js 

• Axios 

• HTML / CSS 

Base de données

• MariaDB 

DevOps

• Docker 

• Kubernetes (Minikube) 

• Nginx 

8. Configuration de la base de données
    
spring.datasource.url=jdbc:mariadb://mariadb:3306/garage_db

spring.datasource.username=root

spring.datasource.password=1234

15. Structure du projet
    
backend/

frontend/

k8s/

docker-compose.yml

README.md

