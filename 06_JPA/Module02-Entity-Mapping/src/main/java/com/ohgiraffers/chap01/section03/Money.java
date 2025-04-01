package com.ohgiraffers.chap01.section03;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.util.Objects;

// VO 객체?
@Embeddable // 값 객체 (값으로만 이루어짐). setter를 지원하지 않음.
public class Money {

    // precision 숫자의 자릿수, scale는 소숫점 자릿수
    @Column(name = "price_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "price_currency", length = 10)
    private String currency;

    protected Money() {
    }

    public Money(BigDecimal amount, String currency) {
        if(amount == null || currency == null || currency.isBlank()) { // isBlank는 null이거나 띄어쓰기를 포함하거나
            throw new IllegalArgumentException("금액과 통화 정보는 필수입니다.");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    // 불변성을 유지할 수 있음. (생성자와 add 메서드 이외에는 값을 바꿀 수 없음)
    public Money add(Money other) {
        if(!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("통화가 같지 않습니다." + this.currency + " vs " + other.currency);
        }
        // vo의 일반적인 타입
        return new Money(this.amount.add(other.amount), this.currency);
    }

    @Override
    public boolean equals(Object o) { // 보통 문자열이 같은지 비교할때 많이 쓰고 클래스간의 비교에도 씀
        if (this == o) return true; // 주소값을 비교함
        if (!(o instanceof Money)) return false; // o의 타입이 Money랑 같은지 비교
        Money money = (Money) o; // 같으면 형변환
        // compareTo는 크면 1 같으면 0 작으면 -1  
        return amount.compareTo(money.amount) == 0 && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency); // 동일한 값을 가지면 동일한 hash를 반환함
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
