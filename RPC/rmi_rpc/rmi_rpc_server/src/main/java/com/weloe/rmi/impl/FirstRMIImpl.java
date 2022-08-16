package com.weloe.rmi.impl;

import com.weloe.rmi.api.FirstInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class FirstRMIImpl extends UnicastRemoteObject implements FirstInterface, Remote {
    protected FirstRMIImpl() throws RemoteException {
    }

    protected FirstRMIImpl(int port) throws RemoteException {
        super(port);
    }

    protected FirstRMIImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String first(String me) throws RemoteException {
        return null;
    }
}
