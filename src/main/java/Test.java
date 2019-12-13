import org.omg.Messaging.SyncScopeHelper;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIB;

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

        /**
         * String操作
         * 长度：采用的是utf-16的编码
         * 一个是代码单元一个是代码点
         */
        String s14 = "he？";
        /**
         *代码单元：
         * utf - 16：0041
         * utf - 8 ：41
         */

        System.out.println(s14.length());
        //代码点个数

        System.out.println(s14.codePointCount(0,s14.length()));
        /**
         * String在拼接中会出现大量的对象
         * Buffer安全是通过syn锁 ，buffer和bulider都是继承抽象的bulider
         * 底层都是通过char数组（9）之前，9之后是byte数组
         * StringBuffer和StringBulider默认初始的容量是16
         * 能评估先评估字符串的大小（setLength）避免扩容
         * 扩容是，删除原来数组，创建新的数组，arraycopy
         */
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append("world");
        sb.append("!");
        System.out.println(sb);//helloworld!
        System.out.println(sb.toString()); //helloworld!

        StringBuilder sb1 = new StringBuilder();
        sb1.append("hello");
        sb1.append("world");
        sb1.append("!");
        System.out.println(sb1);//helloworld!
        System.out.println(sb1.toString());//hellowprld!

        System.out.println(sb1.length()); //11
        sb1.setLength(sb1.length()-1);
        System.out.println(sb1.toString());

        /**
         * jvm的智能优化
         */
        String s15 = "hello" + "," + "world";
         String s16 = "hello,world";
         System.out.println(s15 == s16);//优化后在同一位置true

        String s17 = "hello";
        String s18 = s17 + "world";

        StringBuilder sb3 = new StringBuilder();
        sb3.append(s17);
        sb.append("world");

        System.out.println(sb3.toString() == s18);//优化后不在同一个位置

        

         
                
    }
}
