package com.constom.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sc on 2018/12/6.
 */
public class RemoteObjectInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteObjectInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装请求
        RpcRequest request=new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        TCPTransport tcpTransport = new TCPTransport(host,port);
        return tcpTransport.send(request);
    }
}
