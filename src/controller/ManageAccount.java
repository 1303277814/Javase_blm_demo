package controller;

import dao.User;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author Xiao Yu
 */
public class ManageAccount {
//    //获取所有的用户列表
//    UserList ul = new UserList();
//    //Collection<User> UiList = ul.getUser(3);
//
//    //根据id查找整条记录
//    public User selectUser(String id){
//        User u = new User();
//        for (User user : UiList) {
//            if (id.equals(user.getId())) {
//                u.setBalance(user.getBalance());
//                u.setId(user.getId());
//                u.setListHistory(user.getListHistory());
//                return u;
//            }
//        }
//        return u;
//    }

//垃圾代码毁我青春
    //感觉做得一般呀，有问题记得@我~~


    public static void Show() {
        Scanner sc = new Scanner(System.in);
//        User u = selectUser(id);
            User u = new User();
            UserLogin x = new UserLogin();
            System.out.println("====================================================");
            System.out.println("欢迎用户" + u.getId());
            System.out.println("\t\t****管理账户界面****");
            System.out.println("\t\t1、钱包");
            System.out.println("\t\t2、订单查询");
            System.out.println("\t\t3、用户查询");
            System.out.println("\t\t4、返回上一级");
            System.out.println("************************************");
//            int NUM = sc.nextInt();
//            switch (NUM) {
//                case 1:
//                    System.out.println("你的余额：" + u.getBalance());
//                case 2:
//                    System.out.println("点菜记录：" + u.getListHistory());
//                case 3:
////                    System.out.println("充值，这里应该跳转，技术官大人加方法就行啦");
//                    x.Wallet_list();
//                case 4:
////                    System.out.println("个人信息查询，这里应该跳转，技术官大人加方法就行啦");
//
//                default:
//                    break;
//            }
    }
    public static void Money(){
        System.out.println("\t\t****钱包界面****");
        System.out.println("\t\t1、充值");
        System.out.println("\t\t3、查询余额");
        System.out.println("\t\t3、返回上一级");
        System.out.println("************************************");
    }
    public static void Order_interface(){
        System.out.println("\t\t****订单信息界面****");
        System.out.println("\t\t1、订单消费金额");
        System.out.println("\t\t2、订单历史");
        System.out.println("\t\t3、返回上一级");
        System.out.println("************************************");
    }
}
