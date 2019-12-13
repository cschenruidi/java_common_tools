import com.zeroten.common.util.CheckUtils;
import org.junit.Test;

public class Test2 {
    @Test
    public void sum(){

        if(CheckUtils.isAnyEmpty("disdds","","hdishdi")){
            System.out.println("null");
        }else{
            System.out.println("on null");
        }
    }

}
