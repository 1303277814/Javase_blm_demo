import controller.UserLogin;

/**
 * 程序入口
 * @author Xiao Yu
 */

public class main {
    public static void main(String[] args) {
        try {
            UserLogin ul = new UserLogin();
            ul.login();
        }catch (Exception e){
            System.out.println("出错啦~~~~");
        }

    }
}