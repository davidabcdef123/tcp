package com.constom.rpc;

import java.io.Serializable;

/**
 * Created by sc on 2018/12/6.
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = -7774575197026835487L;


    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
