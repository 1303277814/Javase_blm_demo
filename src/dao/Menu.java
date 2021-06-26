package dao;

import java.util.ArrayList;

/**
 * @author 阿深
 */

public class Menu {

    // ArrayList<Menu> MeatDishes = new ArrayList<>();
    // ArrayList<Menu> VegetableDishes = new ArrayList<>();
    // ArrayList<Menu> DrinkDishes = new ArrayList<>();
    // ArrayList<Menu> SpecialDishes = new ArrayList<>();

    ArrayList<Dish> dishesList = new ArrayList<>();


    //定义菜名
    private String menuName;

    //定义价格
    // public String price;

    //菜单中菜品数量
    private int total=0;


    public Menu() {
    }

    public Menu(String menuName) {
        this.menuName = menuName;
        // this.price = price;
        // this.total = total;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    // public String getPrice() {
    //     return price;
    // }

    // public void setPrice(String price) {

    //     this.price = price;
    // }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }



    //
    public  Dish getDish(int index){
        return dishesList.get(index);
    }


    public ArrayList<Dish> getDishesList(){
        return dishesList;
    }

    public void addDish(Dish dish){
        total++;
        dishesList.add(dish);
    }


}