package kr.co.wikibook.gallery.order.model;
import java.util.ArrayList;
import  java.util.List;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
//@Setter
@ToString
public class OrderPostReq {
//    private int memberId;
    private String name;
    private String address;
    private String payment;
    private String cardNumber;
    private List<Integer> itemIds ;

}
