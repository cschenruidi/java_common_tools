import org.omg.Messaging.SyncScopeHelper;

public class Test {
    public static void main(String[] args) {

        //在jvm字符串常量池中
        String s = "";
        //在字符串常量池中
        String s1 = "hello";
        //在堆中
        String s2 = new String("hello");
        //在java6之后引入intern（）方法去重复（字符串常量池和堆中）
        String s3 = s2.intern();
        System.out.println(s3);//hello

        //假如不重复
        String s5 = "hel";
        String s4 = s5.intern();
        System.out.println(s4);//hel

        String s6 = "hellohello";
        String s7 = "worldworld";
        String s8 = "hellohelloworldworld";
        String s9 = new String("hellohelloworldworld");
        System.out.println(s8 == s9);//false
        System.out.println(s8.equals(s9));//true

        String s10 = s6 + s7;
        System.out.println(s10 == s9);//false

        /**
         * s11的操作是最后返回一个引用
         */
        String s11 = s6 + "worldworld";
        System.out.println(s11 == s8);//false
        System.out.println(s11 == s9);//false

        /**
         * 为了节约空间s12和s13指向同一个内存地址
         */
        String s12 = "hello.";
        String s13 = "hello.";
        System.out.println(s12 == s13);//true


    }
}
