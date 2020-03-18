package org.geeksword.springboot.util;

import java.math.BigDecimal;

public class MoneyUtils {


    public static Money addFen(long fen1,long fen2){
        Money money1 = Money.ofFen(fen1);
        Money money2 = Money.ofFen(fen2);
        BigDecimal fen = money1.getFen().add(money2.getFen());
        return Money.ofFen(fen);
    }

    public static Money addYuan(double yuan1,double yuan2){
        Money money1 = Money.ofYuan(yuan1);
        Money money2 = Money.ofYuan(yuan2);
        BigDecimal yuan = money1.getYuan().add(money2.getYuan());
        return Money.ofYuan(yuan);
    }

    public static Money addFen(double fen1,double fen2){
        Money money1 = Money.ofFen(fen1);
        Money money2 = Money.ofFen(fen2);
        BigDecimal fen = money1.getFen().add(money2.getFen());
        return Money.ofFen(fen);
    }


    public static void main(String[] args){
        Money money = addFen(143.2, 123.3);
        System.out.println(money.getYuanDouble());
        System.out.println(money.getYuanLong());
        System.out.println(money.getFenLong());
    }
}
