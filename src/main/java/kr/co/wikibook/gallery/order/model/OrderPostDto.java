package kr.co.wikibook.gallery.order.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
@ToString
@Builder
public class OrderPostDto {

    private int orderId;
    private int memberId;
    private String name;
    private String address;
    private String payment;
    private String cardNumber;
    private long amount ; // 총구매 가격

}
