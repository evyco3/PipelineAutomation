package org.evy.toolkit.utils;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtils {

    private LoggerUtils(){}



    private static Logger getLogger(Class<?>clazz){
        return LogManager.getLogger(clazz);
    }

    public static void info(Class<?>clazz,String msg){
        getLogger(clazz).info(msg);
        Allure.step(msg);
    }

    public static void warn(Class<?>clazz,String msg){
        getLogger(clazz).warn(msg);
        Allure.step(msg);
    }

    public static void error(Class<?>clazz,String msg,Throwable t){
        getLogger(clazz).error(msg,t);
        Allure.step(msg);
    }


}
