package com.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by sc on 2018/12/6.
 */
public class Server {

    public static void main(String[] args) throws Exception {
        IHelloService helloService = new HelloServiceImpl();//已经发布了一个远程对象

        LocateRegistry.createRegistry(1099);

        Naming.bind("rmi://127.0.0.1/Hello",helloService);
        System.out.println("服务启动成功");
    }
}
