package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by sc on 2018/12/6.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {

    public HelloServiceImpl() throws RemoteException {
        //注释掉的区别？？？
        super();
    }

    @Override
    public String sayHello(String msg) throws RemoteException {
        return "hello "+msg;
    }
}
