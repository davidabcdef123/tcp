package com.constom.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sc on 2018/12/6.
 */
public class RpcServer {

    private static final ExecutorService EXECUTOR_SERVICE= Executors.newCachedThreadPool();

    public void publisher(Object object,int port){
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket=serverSocket.accept();//监听服务
                EXECUTOR_SERVICE.execute(new ProcessorHandler(socket,object));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //todo 关闭流


    }
}
