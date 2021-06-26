package service;

import dao.Dish;
import dao.Order;
import dao.User;

import java.util.ArrayList;


/**
 * @author ZWZ
 * @version 1.1
 * @date 2021/6/8 20:11
 */
public class ManageOrder {
//    int amount = 0;
//    private Order order;
//    private Dish dish;
//    private MenuList menuList;
//    private ArrayList<Dish> dishorder = new ArrayList<>();

//    public void setDish(Dish dish) {
//        this.dish = dish;
//    }
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//    public void setMenuList(MenuList menuList) {
//        this.menuList = menuList;
//    }


    //向订单中添加菜品
    public static void addDish(Order order,Dish dish) {
        order.getDishesList().add(dish);
    }

//    @Override
//    //在订单中减少菜品
//    public void delDishes(Order order, int index) {

//    }

    //将已完成的订单添加到订单信息
    public static void addListHistory(User user, Order order) {
        String listHistory = "\n----------订单" + (user.getListHistory().size()+1) + "---------------\n";
        ArrayList<Dish> dishList = order.getDishesList();
        for (Dish dish : dishList) {
            listHistory += dish.getDishName() + "\t\t" + dish.getPrice() + "元\n";
        }
        listHistory += "总计:"+order.getAmount()+"元\n"+order.getAddress()+"\n\n";

        user.getListHistory().add(listHistory);

        //将用户最后使用的账单设置为当前账单，便于实现加菜
        user.setLastOrder(order);

    }

    //更新用户最后一条历史订单，在加菜完成后使用
    public static void renewListHistory(User user, Order order){
        String listHistory = "\n----------订单" + (user.getListHistory().size()) + "---------------\n";
        ArrayList<Dish> dishList = order.getDishesList();
        for (Dish dish : dishList) {
            listHistory += dish.getDishName() + "\t\t" + dish.getPrice() + "元\n";
        }
        listHistory += "总计:"+order.getAmount()+"元\n"+order.getAddress()+"\n";

        user.getListHistory().set(user.getListHistory().size()-1,listHistory);
    }

    //输入是否外卖
    public static boolean inputIsTakeOut(Order order,boolean isTakeOut) {
        order.setIsTakeOut(isTakeOut);
        return order.getIsTakeOut();
    }

    //输入外卖地址或堂食的座位
    public static String inputAddress(Order order, String address) {
        order.setAddress(address);
        return order.getAddress();
    }

    //计算订单总价
    public static double countOrderPrice(Order order) {
//        //每加一道菜调用一次
//        amount+=dish.getPrice();
//        return amount;
        return order.getAmount();
    }
}

