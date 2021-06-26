package controller;

import dao.Dish;
import dao.Menu;
import dao.Order;
import dao.User;
import service.ManageOrder;
import service.MenuList;


/**
 * @author rain
 */
public class OrderFunc {
    public static void orderFunc(User user) {

    Order order =new Order();
    repeatOrder(order);

        while(true){
            System.out.println("是否完成点餐");
            System.out.println("[1]是\t[2]否");
            if(HUility.scanNumber(1,2)==1){break;}
            OrderFunc.repeatOrder(order);
        }

//        User user = new User();
//        String[] listHistory = {""};
//        user.setListHistory(listHistory);
        AddressAndCheckout.addressAndCheckout(user,order);

    }
    public static void repeatOrder(Order order){
        Menu menu = OrderFunc.selectMenu();
        if (menu == null){
            //Todo 返回上一级
        }else {
            Dish dish = OrderFunc.selectDish(menu);
            if (dish == null){
                repeatOrder(order);
            }else{
                // 将dish加入order
                ManageOrder.addDish(order,dish);
            }
        }
    }

//    public static void showOder(){
//        System.out.println("------------------------");
//        System.out.println("请选择您要选择的菜");
//        //MenuList.getMenu();
//        //MenuListHomePage.allDishes();
//    }

    public static Menu selectMenu(){
        int i=1;
        System.out.println("------------------------");
        System.out.println("欢迎进入点菜系统");
        for (Menu menu : MenuList.getMenuList()){
            System.out.println(i+"."+menu.getMenuName());
            i++;
        }
        System.out.println("0.返回\n");
        System.out.print("请输入0-"+MenuList.getTotal()+"选择菜单:");
        int select =HUility.scanNumber(0,MenuList.getTotal());
        if (select == 0) {
            return null;
        }
        System.out.println(MenuList.getMenuList().size());
        return MenuList.getMenu(select-1);
    }

    public static Dish selectDish(Menu menu){
        int i=1;
        System.out.println("------------------------");
        System.out.println(menu.getMenuName());
        for (Dish dish : menu.getDishesList()){
            System.out.println(i+"."+dish.getDishName()+"\t\t\t"+dish.getPrice()+"元");
            i++;
        }
        System.out.println("0.返回\n");
        System.out.print("请输入0-"+menu.getTotal()+"选择你要点的菜:");
        int select =HUility.scanNumber(0,menu.getTotal());
        if (select == 0) {
            return null;
        }
        return menu.getDish(select-1);
    }
}
