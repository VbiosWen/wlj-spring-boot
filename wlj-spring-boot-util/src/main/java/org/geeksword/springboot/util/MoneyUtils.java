package org.geeksword.springboot.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyUtils {

    /**
     * 分级相加
     *
     * @param fen1
     * @param fen2
     * @return
     */
    public static Money addFen(long fen1, long fen2) {
        Money money1 = Money.ofFen(fen1);
        Money money2 = Money.ofFen(fen2);
        BigDecimal fen = money1.getFen().add(money2.getFen());
        return Money.ofFen(fen);
    }

    public static Money addYuan(double yuan1, double yuan2) {
        Money money1 = Money.ofYuan(yuan1);
        Money money2 = Money.ofYuan(yuan2);
        BigDecimal yuan = money1.getYuan().add(money2.getYuan());
        return Money.ofYuan(yuan);
    }

    public static Money addFen(double fen1, double fen2) {
        Money money1 = Money.ofFen(fen1);
        Money money2 = Money.ofFen(fen2);
        BigDecimal fen = money1.getFen().add(money2.getFen());
        return Money.ofFen(fen);
    }

    public static Money addYuanFen(double yuan, long fen) {
        Money money1 = Money.ofYuan(yuan);
        Money money2 = Money.ofFen(fen);
        BigDecimal add = money1.getFen().add(money2.getFen());
        return Money.ofFen(add);
    }

    public static Money addYuanFen(long yuan, long fen) {
        Money money1 = Money.ofYuan(yuan);
        Money money2 = Money.ofFen(fen);
        BigDecimal add = money1.getFen().add(money2.getFen());
        return Money.ofFen(add);
    }

    public static Money addYuanFen(double yuan, double fen) {
        Money money1 = Money.ofYuan(yuan);
        Money money2 = Money.ofFen(fen);
        BigDecimal add = money1.getFen().add(money2.getFen());
        return Money.ofFen(add);
    }

    public static Money subYuan(long yuan1, long yuan2) {
        Money money1 = Money.ofYuan(yuan1);
        Money money2 = Money.ofFen(yuan2);
        BigDecimal subtract = money1.getFen().subtract(money2.getFen());
        return Money.ofFen(subtract);
    }

    public static Money subFen(long fen1, long fen2) {
        Money money1 = Money.ofFen(fen1);
        Money money2 = Money.ofFen(fen2);
        BigDecimal subtract = money1.getFen().subtract(money2.getFen());
        return Money.ofFen(subtract);
    }

    public static Money subYuanFen(long yuan, long fen) {
        Money money = Money.ofYuan(yuan);
        Money money1 = Money.ofFen(fen);
        BigDecimal subtract = money.getFen().subtract(money1.getFen());
        return Money.ofFen(subtract);
    }

    public static Money subYuanFen(double yuan, long fen) {
        Money money1 = Money.ofYuan(yuan);
        Money money2 = Money.ofFen(fen);
        BigDecimal subtract = money1.getFen().subtract(money2.getFen());
        return Money.ofFen(subtract);
    }

    public static Money subYuanFen(double yuan, double fen) {
        Money money1 = Money.ofYuan(yuan);
        Money money2 = Money.ofFen(fen);
        BigDecimal subtract = money1.getFen().subtract(money2.getFen());
        return Money.ofFen(subtract);
    }

    public static Money multiYuan(long yuan, int quantity) {
        Money money1 = Money.ofYuan(yuan);
        BigDecimal multiply = money1.getFen().multiply(BigDecimal.valueOf(quantity));
        return Money.ofFen(multiply);
    }

    public static Money multiYuan(double yuan, int quantity) {
        Money money1 = Money.ofYuan(yuan);
        BigDecimal multiply = money1.getFen().multiply(BigDecimal.valueOf(quantity));
        return Money.ofFen(multiply);
    }

    public static Money multiFen(long fen, int quantity) {
        Money money1 = Money.ofFen(fen);
        BigDecimal multiply = money1.getFen().multiply(BigDecimal.valueOf(quantity));
        return Money.ofFen(multiply);
    }

    public static Money multiFen(double fen, int quantity) {
        Money money1 = Money.ofFen(fen);
        BigDecimal multiply = money1.getFen().multiply(BigDecimal.valueOf(quantity));
        return Money.ofFen(multiply);
    }

    public static Money divideYuan(long yuan, int quantity) {
        Money money1 = Money.ofYuan(yuan);
        BigDecimal divide = money1.getFen().setScale(0, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(quantity), RoundingMode.HALF_UP);
        return Money.ofFen(divide);
    }

    public static Money divideYuan(double yuan, int quantity) {
        Money money = Money.ofYuan(yuan);
        BigDecimal divide = money.getFen().setScale(0, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(quantity), RoundingMode.HALF_UP);
        return Money.ofFen(divide);
    }

    public static Money divideFen(long fen, int quantity) {
        Money money1 = Money.ofFen(fen);
        BigDecimal divide = money1.getFen().setScale(0, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(quantity), RoundingMode.HALF_UP);
        return Money.ofFen(divide);
    }
}
