🌍 Application de Gestion d’Agence de Voyage
🧭 Contexte du projet

Ce projet consiste à développer une application Spring Boot permettant de gérer une agence de voyage.
L’application offre des fonctionnalités complètes de gestion des clients, voyages, réservations et paiements, avec une architecture claire basée sur les couches Model – Repository – Service – Controller.
L’objectif est de concevoir un mini-système métier cohérent intégrant des relations entre entités, la validation des données et l’exposition d’API REST testables via Postman.
🧩Technologies utilisées

Java 17

Spring Boot (Web, Data JPA, Validation)

MySQL comme base de données

Postman pour les tests d’API

Maven pour la gestion de dépendances
Architecture du projet: 
src/
├─ main/java/com/ela/projet/
│  ├─ model/         # Entités JPA (Client, Voyage, Réservation, Paiement)
│  ├─ repository/    # Interfaces JPARepository
│  ├─ service/       # Logique métier
│  ├─ controller/    # API REST
│  └─ ProjetApplication.java
├─ resources/
│  ├─ application.properties  # Configuration de la base de données
└─ test/
🧠 Modélisation des entités
1️⃣ Client

id (Long)

nom (String)

email (String)

Relation : OneToMany avec Réservation

2️⃣ Voyage

id (Long)

destination (String)

prixParPersonne (BigDecimal)

Relation : OneToMany avec Réservation

3️⃣ Réservation

id (Long)

dateReservation (LocalDate)

montantTotal (BigDecimal)

statut (Enum : EN_ATTENTE, CONFIRMEE, ANNULEE)

Relation : ManyToOne avec Client et Voyage

Relation : OneToOne avec Paiement

4️⃣ Paiement

id (Long)

montant (BigDecimal)

datePaiement (LocalDate)

statut (Enum : EN_ATTENTE, PAYE, ECHOUE)

Relation : OneToOne avec Réservation
⚙️ Endpoints API REST:
| Méthode  | Endpoint            | Description                    |
| -------- | ------------------- | ------------------------------ |
| `POST`   | `/api/clients`      | Ajouter un client              |
| `GET`    | `/api/clients`      | Lister les clients             |
| `GET`    | `/api/clients/{id}` | Consulter un client spécifique |
| `PUT`    | `/api/clients/{id}` | Modifier un client             |
| `DELETE` | `/api/clients/{id}` | Supprimer un client            |
Body JSON (POST):
{
  "nom": "Ela Chagour",
  "email": "ela@example.com"
}
✈️ Voyage:
| Méthode  | Endpoint            | Description         |
| -------- | ------------------- | ------------------- |
| `POST`   | `/api/voyages`      | Ajouter un voyage   |
| `GET`    | `/api/voyages`      | Lister les voyages  |
| `GET`    | `/api/voyages/{id}` | Consulter un voyage |
| `PUT`    | `/api/voyages/{id}` | Modifier un voyage  |
| `DELETE` | `/api/voyages/{id}` | Supprimer un voyage |
Body JSON (POST):
{
  "destination": "Tunis",
  "prixParPersonne": 1600.50
}
📅 Réservation:
| Méthode  | Endpoint                 | Description               |
| -------- | ------------------------ | ------------------------- |
| `POST`   | `/api/reservations`      | Créer une réservation     |
| `GET`    | `/api/reservations`      | Lister les réservations   |
| `PUT`    | `/api/reservations/{id}` | Modifier une réservation  |
| `DELETE` | `/api/reservations/{id}` | Supprimer une réservation |
Body JSON (POST):
{
  "dateReservation": "2025-11-07",
  "montantTotal": 3200.00,
  "statut": "EN_ATTENTE",
  "client": { "id": 1 },
  "voyage": { "id": 1 }
}
💳 Paiement:
| Méthode | Endpoint              | Description           |
| ------- | --------------------- | --------------------- |
| `POST`  | `/api/paiements`      | Effectuer un paiement |
| `GET`   | `/api/paiements`      | Lister les paiements  |
| `GET`   | `/api/paiements/{id}` | Consulter un paiement |
Body JSON (POST):
{
  "montant": 3200.00,
  "datePaiement": "2025-11-07",
  "statut": "PAYE",
  "reservation": { "id": 1 }
}
Validation et gestion des erreurs

@NotBlank → empêche les champs vides (nom, destination)

@Email → valide la syntaxe de l’adresse e-mail

@Positive → garantit que le prix est supérieur à 0

Gestion d’exceptions personnalisées :

Client non trouvé

Voyage inexistant

Montant invalide

-Tests Postman

Des tests ont été réalisés sur Postman pour valider le bon fonctionnement des endpoints :

Ajout et suppression d’un client

Création d’un voyage

Réservation d’un voyage

Paiement associé à la réservation
-Instructions d’exécution
Cloner le dépôt : git clone https://github.com/votre-utilisateur/agence-voyage.git
Importer le projet dans votre IDE (Spring Tools, IntelliJ, ou VS Code).

Configurer la base de données dans src/main/resources/application.properties :
spring.datasource.url=jdbc:mysql://localhost:3306/web_clinique
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
-Tester les endpoints sur Postman à l’adresse:
http://localhost:8080/api/
🎯 Conclusion

Ce mini-projet démontre la mise en œuvre d’une application Spring Boot complète, avec gestion des entités liées, validation des données et tests d’API REST.
Il met en pratique les bonnes pratiques du développement backend moderne et l’architecture MVC.
