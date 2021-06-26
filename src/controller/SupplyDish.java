package controller;

import dao.Order;
import dao.User;

public class SupplyDish {

    public static void orderFunc(User user) {
        System.out.println("*****开始加菜*****");
        Order order = user.getLastOrder();
        OrderFunc.repeatOrder(order);

        while(true){
            System.out.println("是否完成加菜");
            System.out.println("[1]是\t[2]否");
            if(HUility.scanNumber(1,2)==1){break;}
            OrderFunc.repeatOrder(order);
        }

//        User user = new User();
//        String[] listHistory = {""};
//        user.setListHistory(listHistory);
        AddressAndCheckout.addressAndCheckout(user,order);

    }


    // public static Checkout(User user ,Order order ){
    //     //double price = ManagerOrder.countOrderPrice(order);
    //     //UserList.deduct(user,price);

    //     //改变订单历史记录
    // }
}
