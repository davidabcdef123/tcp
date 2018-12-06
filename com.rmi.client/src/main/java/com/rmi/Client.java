package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by sc on 2018/12/6.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        IHelloService helloService= (IHelloService) Naming.lookup("rmi://127.0.0.1/Hello");
        System.out.println(helloService.sayHello("world"));
    }
}
