package dao;

/**
 * @author Qiao
 */

public class Dish {
    private double price;
    private String dishName;

    /**
     * 菜品
     * @param name 菜品名
     * @param price 菜品价格
     */
    public Dish(String name, double price){
        this.dishName=name;
        this.price=price;
    }

    //得到菜品名
    public String getDishName(){
        return dishName;
    }

    //得到菜品价格
    public double getPrice(){
        return price;
    }

}
