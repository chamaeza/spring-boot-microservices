MICROSERVICES COMPLETS - IntelliJ IDEA / Windows / Java 21
============================================================
Contenu : customer-service, inventory-service, discovery-service, config-service,
gatewey-service (orthographe du dossier source), billing-service, config-repo.

SOURCE : code adapte du ZIP micro-services-app-main(2).zip fourni precedemment.
Les captures du document Doc1(1).docx montrent surtout customer, inventory, gateway et discovery.
Le projet conserve les autres services presents dans le ZIP source.

VERSIONS : Java 21, Spring Boot 3.5.16, Spring Cloud 2025.0.3.

OUVRIR DANS INTELLIJ : File > Open > selectionner ce dossier racine.
Attendre la synchronisation Maven. Chaque service a son propre pom.xml.

DEMARRAGE : lancer DEMARRAGE_WINDOWS.bat ou executer les applications
une a une dans cet ordre : discovery (8761), config (9999), customer (8081),
inventory (8082), gateway (8888), billing (8083).

TESTS : http://localhost:8761 ; http://localhost:8081/customers ;
http://localhost:8082/products ; http://localhost:8888/customers

DEPENDANCES : les dependances Maven sont declarees dans les pom.xml.
Elles ne sont PAS embarquees dans cette archive. Maven les telecharge
sur Internet a la premiere ouverture (cache ensuite dans %USERPROFILE%\.m2).
Les Maven Wrappers sont inclus. Java 21 doit etre installe sur le PC.

Ce projet n'a pas ete compile ni demarre dans cet environnement.
Si une dependance n'est pas disponible, relevez la premiere ligne [ERROR] Maven.
