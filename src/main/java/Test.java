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

        System.out.println(s14.codePointCount(0, s14.length()));
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
        sb1.setLength(sb1.length() - 1);
        System.out.println(sb1.toString());//helloworld
        sb1.setLength(sb1.length() + 10);
        System.out.println(sb1);//helloworld

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

        /**
         * 最快的
         */
        long time = System.currentTimeMillis();
        StringBuilder sb4 = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb4.append(i);
        }
        System.out.println(System.currentTimeMillis() - time);


        /*
        去掉空格不使用trim方法
         */
        String s19 = " hdihsi sdjsod ";
        String s20 = s19.trim();
        System.out.println(s20);//hdihsi sdjsod只能去掉首尾空格

        String s21 = " helo shidhs hdis hi ";
        String s22 = s21.replace(" ", "");
        System.out.println(s22);//heloshidhshdishi去掉首尾和中间的空格

        System.out.println(trimAll(s22));

        /*
        字符串反转
        格式规范的快捷键ctrl+alt+l
         */
        String s23 = "--123 321 ,0 ";
        System.out.println(reverse(s23));
        StringBuilder sb6 = new StringBuilder();
        sb6.append(s23);
        System.out.println(sb6.reverse().toString());

    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (int i = array.length-1 ; i >= 0; i--){
          sb.append(array[i]);
        }
        return sb.toString();
    }

    private static String trimAll(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' ') {
                continue;
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }
}
