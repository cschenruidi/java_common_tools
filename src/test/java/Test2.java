import com.zeroten.common.util.CheckUtils;
import org.junit.Test;

public class Test2 {
    @Test
    public void sum(){

        if(CheckUtils.isAnyEmpty("disdds","hiih","hdishdi")){
            System.out.println("no null");
        }else{
            System.out.println(" null");
        }
    }

    @Test
    public void Test(){
        Object[] obj = {"hsidhis",1,5.4};
        if(CheckUtils.isEmpty(obj)){
            System.out.println("on null");
        }else{
            System.out.println(" null");
        }
    }

    @Test
    public void Test1(){

        String s1 = "hell0";
        String s2 = "hell0";

        if(CheckUtils.equals(s1,s2)){
            System.out.println("same");
        }else {
            System.out.println("not same");
        }
    }

}
