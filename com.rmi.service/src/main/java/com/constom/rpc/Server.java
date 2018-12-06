package com.constom.rpc;

/**
 * Created by sc on 2018/12/6.
 */
public class Server {

    public static void main(String[] args) {
        IHello hello= new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(hello,8888);

    }
}
