package dao;

import java.util.ArrayList;

/**
 * @author Qiao
 */

public class Order {
    private ArrayList<Dish> dishesList = new ArrayList<>();
    private int  total;//所点菜品总数
    private double amount=0;//所点菜品总价
    private boolean isTakeOuT;//是否外卖，true为选择外卖
    private String address;//外卖地址或堂食座位号

    //得到菜品
    public Dish getDish(int index){
        return dishesList.get(index);
    }

    //得到所点菜品的数目
    public int getTotal(){
        total = dishesList.size();
        return total;
    }

    //得到所点菜品总价
    public double getAmount(){
        amount = 0;
        for (int i = 0; i< dishesList.size(); i++){
            amount+= dishesList.get(i).getPrice();
        }
        return amount;
    }

    //返回是否外卖或堂食情况
    public boolean getIsTakeOut(){
        return isTakeOuT;
    }

    //选择是否外卖或堂食
    public void setIsTakeOut(boolean isTakeOuT){
        this.isTakeOuT=isTakeOuT;
    }

    //得到地址
    public String getAddress(){
        return address;
    }

    //输入地址
    public void setAddress(String address){
        this.address=address;
    }


    //获取dishesList
    public  ArrayList<Dish> getDishesList(){
        return dishesList;
    }
    
}
