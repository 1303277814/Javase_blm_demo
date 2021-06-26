package service;


import dao.Dish;
import dao.Menu;

import java.util.ArrayList;

/**
 * @author 阿深
 */

public class MenuList {
    private static ArrayList<Menu> menuList = new ArrayList<Menu>();
    private static int total;

    //菜单和菜品的初始化
    static {
        Menu tempMenu = new Menu("荤菜");
        tempMenu.addDish(new Dish("糖醋里脊",38.8));
        tempMenu.addDish(new Dish("红烧肉",48.8));
        tempMenu.addDish(new Dish("水煮鱼",58.8));
        tempMenu.addDish(new Dish("烧鸡",36.6));
        tempMenu.addDish(new Dish("烤鸭",46.6));
        menuList.add(tempMenu);


        Menu tempMenu2 = new Menu("素菜");
        tempMenu2.addDish(new Dish("烧茄子",28.8));
        tempMenu2.addDish(new Dish("炖白菜",28.8));
        tempMenu2.addDish(new Dish("西红柿炒蛋",28.8));
        tempMenu2.addDish(new Dish("西红柿炒蛋",28.8));
        tempMenu2.addDish(new Dish("西红柿炒蛋",28.8));
        menuList.add(tempMenu2);

        Menu tempMenu3 = new Menu("饮品");
        tempMenu3.addDish(new Dish("康帅夫",1));
        tempMenu3.addDish(new Dish("雪碧",3.5));
        tempMenu3.addDish(new Dish("冰阔落",3.5));
        tempMenu3.addDish(new Dish("飞天茅台",1888));
        menuList.add(tempMenu3);

        Menu tempMenu4 = new Menu("招牌菜");
        tempMenu4.addDish(new Dish("我",1));
        tempMenu4.addDish(new Dish("编",1));
        tempMenu4.addDish(new Dish("不",3.5));
        tempMenu4.addDish(new Dish("出",3.5));
        tempMenu4.addDish(new Dish("来",1888));
        tempMenu4.addDish(new Dish("啊",1888));
        menuList.add(tempMenu4);



        total=menuList.size();

    }

    //method
    public static Menu getMenu(int index){
        if (index>=0 && index<total) {
            return menuList.get(index);
        }
        return null;
    }

    public static int getTotal(){
        return total;
    }

    public static Dish getDish(int menuIndex,int dishIndex){
        return menuList.get(menuIndex).getDish(dishIndex);
    }

    public static ArrayList<Menu> getMenuList(){
        return menuList;
    }

    public static void viewMenu(int index){

    }


}
