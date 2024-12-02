# Application de gestion des contrats d'assurance

Cette application permet de gérer facilement les contrats d'assurance automobile, habitation et santé. Elle vise à simplifier le processus pour les clients, de l'inscription à la gestion de leurs contrats, tout en offrant des devis personnalisés et en permettant la souscription en ligne.

## Contexte du projet
Dans une compagnie d'assurance fictive, une équipe de développement a été chargée de créer une application destinée à simplifier la gestion des contrats d'assurance. L'objectif est d'offrir une expérience utilisateur fluide pour gérer les assurances automobile, habitation et santé en ligne, tout en réduisant les coûts administratifs.

## Fonctionnalités
1. **Inscription et Connexion** : Créer un compte avec des informations personnelles (nom, adresse, email, numéro de téléphone).
2. **Obtenir des Devis d'Assurance** : Demander des devis personnalisés pour l'assurance automobile, habitation et santé en fonction de critères spécifiques.
3. **Souscription à des Contrats** : Souscrire à un contrat d'assurance après avoir accepté un devis et fourni les documents nécessaires.
4. **Gestion des Contrats** : Modifier ou résilier les contrats d'assurance via l'application.

## Règles de Calcul des Devis
### 1. **Assurance Automobile** :
   - Calcul basé sur l'âge du conducteur, le type de véhicule, l'utilisation du véhicule, et l'historique de conduite.

### 2. **Assurance Habitation** :
   - Calcul basé sur la valeur du bien, le type de logement, la localisation, et la présence d'un système de sécurité.

### 3. **Assurance Santé** :
   - Calcul basé sur l'âge, l'état de santé, et le type de couverture.

## Technologies utilisées
- **Spring Core**
- **Spring Web**
- **JSP**
- **JPA**
- **JUnit / Mockito**

## Utilisation de JIRA
Ce projet utilise JIRA pour la gestion des tickets. Chaque fonctionnalité ou tâche est associée à une clé de ticket sous le format `LFS-(numéro du ticket)`. Exemple : `LFS-123`.

## Installation et exécution
1. Clonez le projet :
   ```bash
   git clone https://github.com/votre-utilisateur/gestion-assurance.git
   cd gestion-assurance
    ```
2. Configurez les dépendances dans pom.xml :
 ```bash
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>5.3.10</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.3.10</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jpa</artifactId>
        <version>2.5.3</version>
    </dependency>
</dependencies>
 ```
3. Compilez et lancez l'application :
 ```bash
mvn clean install
mvn spring-boot:run
 ```
