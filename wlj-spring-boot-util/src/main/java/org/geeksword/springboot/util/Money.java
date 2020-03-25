package org.geeksword.springboot.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal yuan;

    private BigDecimal fen;

    private static final BigDecimal ltis = BigDecimal.valueOf(100);

    private Money(BigDecimal yuan, BigDecimal fen) {
        this.yuan = yuan;
        this.fen = fen;
    }

    private Money(long yuan, long fen) {
        this.yuan = BigDecimal.valueOf(yuan);
        this.fen = BigDecimal.valueOf(fen);
    }

    public static Money ofYuan(long yuan) {
        return new Money(yuan, ltis.longValue() * yuan);
    }

    public static Money ofYuan(double yuan) {
        return new Money(BigDecimal.valueOf(yuan), BigDecimal.valueOf(yuan).setScale(2,RoundingMode.HALF_UP).multiply(ltis));
    }

    public static Money ofFen(long fen) {
        BigDecimal yuan = BigDecimal.valueOf(fen).divide(ltis, RoundingMode.HALF_UP);
        return new Money(yuan, BigDecimal.valueOf(fen));
    }

    public static Money ofFen(double fen) {
        return new Money(BigDecimal.valueOf(fen).setScale(2, RoundingMode.HALF_UP).multiply(ltis), BigDecimal.valueOf(fen).setScale(0, RoundingMode.HALF_UP));
    }

    public static Money ofFen(BigDecimal fen) {
        return new Money(fen.setScale(2, RoundingMode.HALF_UP).divide(ltis, RoundingMode.HALF_UP), fen.setScale(0, RoundingMode.HALF_UP));
    }

    public static Money ofYuan(BigDecimal yuan) {
        return new Money(yuan, yuan.divide(ltis, RoundingMode.HALF_UP));
    }

    public double getYuanDouble() {
        return yuan.doubleValue();
    }

    public long getFenLong() {
        return fen.longValue();
    }

    public long getYuanLong() {
        return yuan.setScale(0, RoundingMode.HALF_UP).longValue();
    }

    public BigDecimal getYuan() {
        return yuan;
    }

    public BigDecimal getFen() {
        return fen;
    }
}
