package kr.co.wikibook.gallery.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartDeleteReq {
//    @JsonIgnore
    private Integer memberId;
    private Integer itemId;

}
