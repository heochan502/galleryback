package kr.co.wikibook.gallery.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@Setter
@ToString
public class OrderPostDto {

    private int memberId;
    private String name;
    private String address;
    private String payment;
    private int cardNumber;
    private long amount ;
}
