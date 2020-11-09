import com.aa.User;

public class HelloWorld {
    public static void main(String[] args) {
        SayHelloWorld();
    }


    /*
    * This is say Hello World
    * */
    static void SayHelloWorld()
    {
        System.out.println("Helle World !!!");

        User a = new User();
        a.IsAdmin = true;
    }

}
/**
 *
 */
//CMD 执行以下指令 可以得到输出 Hello World
//java -cp CreateProjectDemo.jar HelloWorld
