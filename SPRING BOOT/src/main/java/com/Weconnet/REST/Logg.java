package com.Weconnet.REST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logg {
   static Logger log =  LoggerFactory.getLogger(Logger.class);
    public static void log(String str){
        log.debug("debug:"+str);
    }
}
