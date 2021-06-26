package controller;

import java.util.*;

/**
 * 工具类
 * @author 清晨
 */

public class HUility {
    private  static Scanner scanner = new Scanner(System.in);
    
    /**
     * 从键盘上输入 1-end 的数字
     * @param start 为输入数字的最小值，最小为0
     * @param end 为输入数字的最大值，最小为1最大为9
     * @return 类型为int
     */
    public static int scanNumber(int start,int end){
        String read = readKeyboard(1);
        String number;
        for(int i=start;i<=end;i++){
            number =i+"";
            if (number.equals(read)){
                return read.charAt(0) - 48;
            }  
        }
        System.out.println("输入字符非法，请输入"+ start +"-"+end+"的数字");
        return scanNumber(start,end);
    }

    /**
     * 从键盘中输入字符串
     * @param limit 为输入字符串的最大长度
     * @return 
     */
    public static String scanString(int limit){
        return readKeyboard(limit);
    }

    /**
     * 从键盘中输入座位号，座位号的格式为 字母+数字 ，例如：A1
     * @param climit 座位号中的字母部分，从A开始，从climit结束
     * @param ilimit 座位号中的数字部分，从1开始，从ilimit结束
     * @return 
     */
    public static String scanSeatNumber(char climit ,int ilimit){
        String read = readKeyboard(2);
        char first = read.charAt(0);
        for (char c='A';c<=climit;c++){
            if (first == c || first == (c+32)){
                char second =read.charAt(1);
                for (int i=1;i<=ilimit;i++){
                    if ((second-48)==i){
                        return (""+c+i);
                    }
                }
            }
        }
        System.out.println("输入非法，请重新输入座位号(示例：A1)");
        return scanSeatNumber(climit, ilimit);
    }

    private static String readKeyboard(int limit){
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
