package controller;

import dao.Order;
import dao.User;
import service.ManageOrder;
import service.UserList;

import java.util.Scanner;

/**
 * @author 清晨
 * 这个类是为了实现输入地址和结账功能
 * 类中的全部方法都为静态
 */

public class AddressAndCheckout {
    
    
    //这个是组装起来时b1调用b2的接口  2021年6月26日 15:26:38这有啥用
    public static void addressAndCheckout(User user,Order order){
        if (user.getLastOrder()!=order) {
            scanAddress(order);
        }
        checkout(user,order);
    }

    //输入地址，并将地址储存在订单中
    public static void scanAddress(Order order){
        System.out.println("------------------------------------------");
        System.out.println("请输入1-2选择用餐类型：");
        System.out.println("1.外卖");
        System.out.println("2.堂食");
        
        String address=""; 
        int select = HUility.scanNumber(1,2);
        switch (select){
            case 1:
                System.out.println("请输入你的外卖配送地址：");
                address = "订单类型：外卖\n外卖地址：" + HUility.scanString(50);
                ManageOrder.inputIsTakeOut(order,false);
                break;
            case 2:
                System.out.println("请输入你的堂食座位号：");
                System.out.println("----------------------------------------");
                System.out.println("|    □ □      □ □      □ □      □ □    |");
                System.out.println("|   A1 A2    B1 B2    C1 C2    D1 D2   |");
                System.out.println("|    □ □      □ □      □ □      □ □    |");
                System.out.println("|   A3 A4    B3 B4    C3 C4    D3 D4   |");
                System.out.println("----------------------------------------");
                address = "订单类型：堂食\n堂食座位号：" + HUility.scanSeatNumber('D',4);
                ManageOrder.inputIsTakeOut(order,true);
                break;
        }
        ManageOrder.inputAddress(order,address);

    }

    //为user结算order订单
    public static void checkout(User user, Order order){
        double price = ManageOrder.countOrderPrice(order);

        if (UserList.deduct(user,price)){ //判断付款是否成功
            if (user.getLastOrder()==order){
                ManageOrder.renewListHistory(user,order);
            }else{
                ManageOrder.addListHistory(user,order);
            }


            //打印结算的订单信息
            System.out.print(user.getListHistory().get(user.getListHistory().size() - 1));

            //输入是否加菜
            System.out.println("是否需要对 订单"+user.getListHistory().size()+" 加菜");
            System.out.println("1.是");
            System.out.println("2.否");
            switch (HUility.scanNumber(1,2)){
                case 1:
                    //Todo 加菜
                    SupplyDish.orderFunc(user);
                    break;
                case 2:
                    //do nothing
            }


        }else{
            System.out.println("余额不足，请充值");
            System.out.println("1.充值");
            System.out.println("2.取消订单");
            switch (HUility.scanNumber(1,2)){
                case 1:
                    System.out.print("请输入充值金额:");
                    Scanner scanner = new Scanner(System.in);
                    double money = scanner.nextDouble();
                    UserList.recharge(user,money);

                    checkout(user,order);

                    break;
                case 2:

            }
        }


    }

}