import com.learning.annotation.StrategyServiceComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:17
 **/
@ComponentScan("com.learning")
@SpringBootApplication
@StrategyServiceComponentScan
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
