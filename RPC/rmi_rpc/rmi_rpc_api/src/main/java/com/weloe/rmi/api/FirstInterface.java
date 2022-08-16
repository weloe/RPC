package com.weloe.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FirstInterface extends Remote {
    //RMI
    String first(String me) throws RemoteException;
}
