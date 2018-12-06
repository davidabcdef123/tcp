package com.constom.rpc;

import com.rmi.IHelloService;

import java.rmi.RemoteException;

/**
 * Created by sc on 2018/12/6.
 */
public class HelloServiceImpl implements IHello {

    @Override
    public String sayHello(String msg) {
        return "hello" + msg;
    }


}
