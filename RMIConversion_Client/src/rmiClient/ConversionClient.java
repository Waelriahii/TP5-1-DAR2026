package rmiClient;

import rmiService.IConversion;

import java.rmi.Naming;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            // ii. Chercher la référence de l'objet distant dans l'annuaire
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/ConversionService");

            // iii. Invoquer la méthode distante
            double resultat = stub.convertirMontant(500);
            System.out.println("500 EUR = " + resultat + " TND");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
