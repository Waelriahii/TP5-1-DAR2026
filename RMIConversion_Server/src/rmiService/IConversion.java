package rmiService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/** Interface distante du service de conversion de devise (EUR -> TND). */
public interface IConversion extends Remote {
    double convertirMontant(double mt) throws RemoteException;
}
