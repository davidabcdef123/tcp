package com.constom.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by sc on 2018/12/6.
 * Processor处理器
 */

public class ProcessorHandler implements Runnable{

    private Socket socket;
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        //处理请求
        ObjectInputStream inputStream=null;
        try {
            //获取客户端的输入流
            inputStream=new ObjectInputStream(socket.getInputStream());
            //反序列化远程传输的对象RpcRequest
            RpcRequest request=(RpcRequest) inputStream.readObject();
            Object result=invoke(request); //通过反射去调用本地的方法

            //通过输出流讲结果输出给客户端
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest request)throws Exception {
        Object[] args=request.getParameters();
        Class[] clazzs = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            clazzs[i] = args[i].getClass();
        }
        Method method=service.getClass().getMethod(request.getMethodName(),clazzs);
        return method.invoke(service,args);
    }
}
