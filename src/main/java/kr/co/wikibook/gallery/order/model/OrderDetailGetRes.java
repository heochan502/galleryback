package kr.co.wikibook.gallery.order.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDetailGetRes {
    private int id;
    private String name;
    private String address;
    private String payment;
    private Long amount;
    private String created;
    private List<OrderDetailDto> items;

}
