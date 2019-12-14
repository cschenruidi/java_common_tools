package com.zeroten.common.util;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import sun.font.TrueTypeFont;

public class CheckUtils {

    /*
    查看String【】中是有空
     */
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


    /*
    判断数组是否为空
     */
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

    /*
    判断两个数值是否相等
     */
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


    /*
    判断两个integer是否相等
     */
    public static boolean equalsInt(Integer n1,Integer n2){
        if(n1 == n2)
          return true;


        if(n1 != null || n2 != null) {

            if (n1.intValue() == n2.intValue()) {
                return true;
            }
        }
        return false;
    }
}
