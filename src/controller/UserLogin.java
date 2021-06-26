package controller;

import dao.User;
import service.UserList;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Scanner;

/**
 * 登录主界面
 * @author 小当家 Xiao Yu
 *
 */
public class UserLogin {
    ManageAccount a = new ManageAccount();
    //系统界面
    void System_interface(){
        System.out.println("\t\t****系统界面****");
        System.out.println("\t\t1、管理账户");
        System.out.println("\t\t2、点    菜");
        System.out.println("\t\t3、退    出");
        System.out.println("************************************");
    }

    //管理用户界面 xiaoyu改动一
    void accountMenu(){
        a.Show();
    }
    //订单查询界面 xiaoyu改动二
    void Order_interface(){
        a.Order_interface();
    }
    //钱包界面 xiaoyu改动三
    void Wallet_list(){
        a.Money();
    }

    //管理用户界面
//    void accountMenu(){
//        System.out.println("\t\t****管理账户界面****");
//        System.out.println("\t\t1、钱包");
//        System.out.println("\t\t2、订单查询");
//        System.out.println("\t\t3、用户查询");
//        System.out.println("\t\t4、返回上一级");
//        System.out.println("************************************");
//    }
    //订单查询界面
//    void Order_interface(){
//        System.out.println("\t\t****订单信息界面****");
//        System.out.println("\t\t1、订单消费金额");
//        System.out.println("\t\t2、订单历史");
//        System.out.println("\t\t3、返回上一级");
//        System.out.println("************************************");
//    }
    //钱包界面
//    void Wallet_list(){
//        System.out.println("\t\t****钱包界面****");
//        System.out.println("\t\t1、充值");
//        System.out.println("\t\t2、查询余额");
//        System.out.println("\t\t3、返回上一级");
//        System.out.println("************************************");
//    }


    //菜单列表
    void Menu_list(){
        System.out.println("\t\t****显示菜单界面****");
        System.out.println("\t\t1、菜名:价格$");
        System.out.println("\t\t2、点菜");
        System.out.println("\t\t3、返回上一级");
        System.out.println("************************************");
    }

    public static void login() {
        System.out.println("*****欢迎来到饱了吗点餐系统*****");
        System.out.println("*********请先登录********");
        UserList user1 = new UserList();
        User u1 = new User();
        user1.checkIdentity(123,"456");//调用方法查看id和密码是否一致
        UserLogin ot = new UserLogin();
        Scanner scanner = new Scanner(System.in);
        //system(系统界面选择),option(账户界面选择)
        // wallet(钱包界面选择),order(菜单界面选择)
        // money:初始化为0,order_selection(订单查询界面选择)
        int system=0,option=0,account=0,wallet=0,order=0,order_selection=0,money=0;
        switch (system){
            case 0:do{
                ot.System_interface();
                System.out.print("请选择，输入数字或按3退出");
                option = scanner.nextInt();
                switch (option){
                    case 1:do {
                        ot.accountMenu();//显示管理账户界面
                        System.out.print("请选择，输入数字或按4返回上一级");
                        account = scanner.nextInt();
                        switch (account){
                            case 1:do {
                                ot.Wallet_list();//显示钱包界面
                                System.out.print("请选择，输入数字或按3返回上一级");
                                wallet = scanner.nextInt();
                                switch (wallet){
                                    case 1:
                                        System.out.println("1、充值");
                                        System.out.print("请输入充值金额:");
                                        double x = scanner.nextDouble();
                                        user1.recharge(u1,x);
                                        break;
                                    case 2:
                                        System.out.println("2、查询余额");

                                        //格式化，为了输出两位小数
                                        DecimalFormat df   = new DecimalFormat("######0.00");
                                        System.out.println("当前余额:"+ df.format(u1.getBalance()) + "元");
                                        break;
                                }
                            }while (wallet!=3);
                                break;

                            case 2://do {
//                                ot.Order_interface();//显示订单查询界面
//                                System.out.print("请选择，输入数字或按3返回上一级");
//                                order_selection = scanner.nextInt();
//                                switch (order_selection){
//                                    case 1:
//                                        System.out.println("1、订单消费金额");
//                                        System.out.print("请输入消费金额:");
//                                        double y = scanner.nextDouble();
//                                        user1.deduct(u1,y);
//                                        break;
//                                    case 2:
//                                        System.out.println("2、订单历史");
//                                        UserList.printListHistory(u1);
//                                        break;
//                                }
//                            }while (order_selection!=3);

                                UserList.printListHistory(u1);


                                break;
                            case 3:
                                System.out.println("3、用户查询");
                                user1.getUser(0);
                                break;
                        }
                    }while (account!=4);
                        break;
                    case 2: //do {
                        System.out.println("*****订单查询*****");
                        OrderFunc.orderFunc(u1);
//                        ot.Menu_list();//显示菜单界面
//                        System.out.print("请选择，输入数字或按3返回上一级");
//                        order = scanner.nextInt();
//                        switch (order){
//                            case 1:
//                                System.out.println("1、菜名:价格$");
//                                break;
//                            case 2:
//                                System.out.println("2、点菜");
//                                break;
//                        }
//                    }while (order!=3);
                        break;
                    case 3:
                        System.out.println("用餐愉快，欢迎下次光临！！！");
                        break;
                }
            }while (option!=3);
                break;
        }
    }
//    UserList u1 = new UserList();
//    private Scanner sc = new Scanner(System.in);
//    //获取用户数据"库"
//    private UserList UL = new UserList();
//    //private Collection<User> UList = UL.getUser();
//
//    public static void main(String[] args) {
//        UserLogin userlogin =new UserLogin();
//        userlogin.show();
//    }
//
//    public void show(){
//        System.out.println("=========欢迎使用饱了吗点餐系统=======\n");
//        System.out.println("====用户登录====");
//        System.out.print("账户：");
//        long id = sc.nextLong();
//        System.out.println("密码：");
//        String password = sc.nextLine();
//
//        if(u1.checkIdentity(1,"2")){
//            System.out.println("登录成功！");
//            System.out.println("======功能选择======");
//            System.out.println("1.点菜");
//            System.out.println("2.管理账户");
//            System.out.print("请输入：");
//            int option = sc.nextInt();
//            switch(option){
//                case 1:
//                    System.out.println("======本店菜单======");
//                    System.out.println("1.菜单1");
//                    System.out.println("2.菜单2");
//                    System.out.print("请选择：");
//                    int menuSelect = sc.nextInt();
//                    //new MenuList().viewMenu(menuSelect);//显示菜单;
//                    break;
//                case 2:
//                    System.out.println("======管理账户======");
//                    System.out.println("1.钱包");
//                    System.out.println("2.订单");
//                    System.out.print("请选择：");
//                    int userSelect = sc.nextInt();
//                    User user1 = new User();
//
//                    if(userSelect == 1){
//                        System.out.println("=====钱包=====");
//
//                        System.out.println("余额：" + user1.getBalance());
//
//
//                    }else if(userSelect ==2){
//                        System.out.println("=====订单详情=====");
//                        System.out.println("");
//                        System.out.println(user1.getListHistory());
//                    }
//                    break;
//            }
//        }else{
//            System.out.println("输入错误，请重新输入！");
//            show();
//        }
//
//    }

//    public boolean checkIdentity(long id, String pwd){
//        for(User user :UList){
//            if(id == user.getId() && pwd.equals(user.getPassword())){
//                return true;
//            }
//        }
//        return false;
//    }
}
