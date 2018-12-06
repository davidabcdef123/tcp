package com.constom.rpc;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

import java.lang.reflect.Proxy;

/**
 * Created by sc on 2018/12/6.
 */
public class RpcClientProxy {


    public <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){

        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new RemoteObjectInvocationHandler(host, port));

    }
}
