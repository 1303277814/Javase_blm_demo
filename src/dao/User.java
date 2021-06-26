package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * User 用户类 主要实现用户的初始化
 * @author Xiao Zhu
 */
public class User {
        //用户名
        private long id;
        //用户密码
        private String password;
        //个人信息
        private String info;
        //账户余额
        private double balance;
        //订单历史记录
        private ArrayList<String> listHistory = new ArrayList<String>();

        //最近一次点的单
        private Order lastOrder;

        public User(){

        }
        //用来给用户的id和密码初始化
        public User(long id,String password){
            this.id = id;
            this.password = password;
        }

        public User(long id,String password,String info, double balance,ArrayList<String>  listHistory) {
            this.id = id;
            this.password = password;
            this.info = info;
            this.balance = balance;
            this.listHistory = listHistory;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public ArrayList<String> getListHistory() {
            return listHistory;
        }

        public void setListHistory(ArrayList<String> listHistory) {
            this.listHistory = listHistory;
        }

        public Order getLastOrder(){return lastOrder;}

        public void setLastOrder(Order order){ lastOrder = order;  }

        //重写equals判断password是否相等
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return password.equals(user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(password);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", password='" + password + '\'' +
                    ", info='" + info + '\'' +
                    ", balance=" + balance +
//                    ", listHistory=" + Arrays.toString(listHistory) +
                    '}';
        }
    }


