package com.constom.rpc;

/**
 * Created by sc on 2018/12/6.
 */
public class Client {

    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy=new RpcClientProxy();
        IHello hello = rpcClientProxy.clientProxy(IHello.class,"localhost",8888);
        System.out.println(hello.sayHello("wolrd"));
    }
}
