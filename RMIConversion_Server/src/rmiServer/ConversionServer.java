package rmiServer;

import rmiService.ConversionImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // i. Activer l'annuaire RMIRegistry (port 1099)
            LocateRegistry.createRegistry(1099);
            System.out.println("RMIRegistry démarré sur le port 1099");

            // ii. Créer une instance de ConversionImpl
            ConversionImpl service = new ConversionImpl();

            // iii. Publier la référence dans l'annuaire
            Naming.rebind("rmi://localhost:1099/ConversionService", service);
            System.out.println("Service ConversionService publié, en attente des clients...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
