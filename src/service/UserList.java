package service;

import dao.User;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Xiao Tian
 */
public class UserList {
    User u1 = new User(123, "456");
    Scanner input = new Scanner(System.in);
    //数据域
    private User[] users = {u1};//创建名为users的User类型数组用来存储用户
    private int total;//用户总数

    public UserList() {
    }

    public UserList(int total) {//UserList的构造器
        this.total = total;
        for (int i = 0; i < total; i++) {
            users[i] = new User();
        }
    }

    //方法
    public int getUser(int index) {//从队列中获取指定用户
        for (int i = 0; i < total; i++) {
            if (users[i].getId() == users[index].getId()) {
                System.out.println(users[i]);
            } else {
                System.out.println("无此用户");
            }
        }
        return 0;
    }

    public User checkIdentity(long id, String password) {
        System.out.print("请输入id:");
        Scanner scanner = new Scanner(System.in);
        Long LoginId = scanner.nextLong();
        System.out.print("请输入密码:");
        String LoginPassword = scanner.next();
        if (LoginId == u1.getId() && LoginPassword.equals(u1.getPassword())) {
            System.out.println("登录成功，欢迎使用饱了吗点餐系统");
        } else {
            System.out.println("登录失败,请重新登录！");
            System.out.println("===============================");
            this.checkIdentity(1, "2");
        }
        return u1;
    }


    public static void recharge(User u1, double money) {//为某一用户充值
        if (money > 0 && money < 9999) {
            u1.setBalance(money + u1.getBalance());

            //格式化，为了输出两位小数
            DecimalFormat df = new DecimalFormat("######0.00");
            System.out.println("充值成功:" + money + "元\n" + "当前余额:" + df.format(u1.getBalance()) + "元");
        } else {
            System.out.print("充值金额有误，请重新输入：");
        }
    }

    public static boolean deduct(User u1, double money) {//为某一用户扣款
        if (u1.getBalance() < money) {
            return false;
        } else {
            u1.setBalance(u1.getBalance() - money);
            System.out.println("扣款成功:" + money + " " + "当前余额:" + u1.getBalance());
            return true;
        }

    }

    public void changeInfo(User u1, String info) {//更改用户信息
        u1.setInfo(info);
    }

    public static void printListHistory(User user) {
        if (user.getListHistory().size() == 0) {
            System.out.println("当前无历史订单");
        } else {
            for (String listHistory : user.getListHistory()) {
                System.out.println(listHistory);
            }
        }
    }
}
