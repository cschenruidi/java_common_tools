package com.zeroten.common.util;

public class CheckUtils {

    public static boolean isAnyEmpty(String...strings){
            if(strings == null)
                return false;

            if(strings.length == 0)
                return false;
            for (int i = 0 ; i < strings.length ; i++){
                if(strings[i] == null){
                    return false;
                }
            }
            return true;
    }
}
