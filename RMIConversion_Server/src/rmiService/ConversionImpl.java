package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** Implémentation du service distant de conversion. */
public class ConversionImpl extends UnicastRemoteObject implements IConversion {
    private static final double TAUX_EUR_TND = 3.4; // 1 EUR = 3.4 TND (taux fixe pour le TP)

    public ConversionImpl() throws RemoteException {
        super();
    }

    @Override
    public double convertirMontant(double mt) throws RemoteException {
        System.out.println("Requête reçue : conversion de " + mt + " EUR");
        return mt * TAUX_EUR_TND;
    }
}
