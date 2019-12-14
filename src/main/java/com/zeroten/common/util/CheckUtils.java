package com.zeroten.common.util;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import sun.font.TrueTypeFont;

public class CheckUtils {

    public static boolean isAnyEmpty(String...strings){
        boolean flag = true;
            if(strings == null) {
                 flag = false ;
            }

            if(strings.length == 0){
                 flag = false;
            }

            for (int i = 0 ; i < strings.length ; i++){
                if(strings[i] == ""){
                    flag = false;
                    break;
                }
            }
            return flag;
    }

    public static  boolean isEmpty(Object[] arr){
        boolean flag = true;
        if(arr == null) {
            flag = false ;
        }

        if(arr.length == 0){
            flag = false;
        }
        return flag;
    }

    public  static boolean equals(String s1,String s2){

        boolean flag = true;
        if(s1 == "" || s2 == "")
            flag= false;

        if(s1.length() != s2.length())
            flag = false;

        int len = s1.length();
        int i = 0 ;
        while (len-- !=0){
            if(s1.charAt(i) != s2.charAt(i)){
                flag = false;
                break;
            }
            i++;
        }
        return flag;
    }

}
