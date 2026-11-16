# TP5 – Activité 5-1 : Service de conversion de devise (Java RMI)

**Matière :** Développement d'applications réparties – LSI3 – 2026/2027
**Étudiant :** Prénom NOM

## Objectif
Concevoir un service distant RMI qui convertit un montant en euros vers le dinar tunisien (taux fixe : 1 EUR = 3.4 TND).

## Structure
```
RMIConversion_Server/src
├── rmiService/  IConversion.java, ConversionImpl.java
└── rmiServer/   ConversionServer.java
RMIConversion_Client/src
└── rmiClient/   ConversionClient.java
conversionClient.jar    (contient uniquement IConversion)
```

## Fonctionnement
- `IConversion` : interface distante (`extends Remote`) avec `double convertirMontant(double mt) throws RemoteException`.
- `ConversionImpl` : implémentation (`extends UnicastRemoteObject`).
- `ConversionServer` : démarre le RMIRegistry (port 1099), crée `ConversionImpl` et la publie sous le nom `ConversionService`.
- `ConversionClient` : fait le `lookup` de l'objet distant et appelle `convertirMontant(500)`.
- `conversionClient.jar` : exporté depuis le serveur (interface seule), ajouté au classpath du projet client.

## Exécution
1. Lancer `rmiServer.ConversionServer`.
2. Lancer `rmiClient.ConversionClient`.

![Serveur](screenshots/serveur.png)
![Client](screenshots/client.png)

## Synthèse
Le client invoque `convertirMontant(500)` sur l'objet distant comme sur un objet local et obtient `500 EUR = 1700.0 TND`. Le serveur affiche chaque requête reçue. Le cycle de vie du service est respecté : définition de l'interface, implémentation, enregistrement dans l'annuaire, puis invocation par le client via le stub. Le client ne connaît que l'interface (jar), jamais l'implémentation.
