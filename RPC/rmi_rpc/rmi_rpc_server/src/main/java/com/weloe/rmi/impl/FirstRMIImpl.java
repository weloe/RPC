package com.weloe.rmi.impl;

import com.weloe.rmi.api.FirstInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//实现远程服务接口，所有的远程服务实现，必须是Remote接口直接或间接实现类
//RMI强制要求所有的方法必须抛出RemoteException，包括构造方法
public class FirstRMIImpl extends UnicastRemoteObject implements FirstInterface {

    public FirstRMIImpl() throws RemoteException{
        super();
    }

    @Override
    public String first(String name) throws RemoteException {
        System.out.println("客户端请求参数是："+name);
        return "nihao,"+name;
    }
}
