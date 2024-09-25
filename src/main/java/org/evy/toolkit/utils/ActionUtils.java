package org.evy.toolkit.utils;

import java.util.concurrent.Callable;

public final class ActionUtils {


    private ActionUtils(){}


    public <T>T performAction(Class<?>clazz, Callable<T>callable,String successMsg,String errorMsg){
        T result;
        try {
            result=callable.call();
            LoggerUtils.info(clazz,successMsg);
        }
        catch (Exception e){
            LoggerUtils.error(clazz,errorMsg,e);
            throw new RuntimeException(errorMsg,e);
        }
        return result;
    }
}
