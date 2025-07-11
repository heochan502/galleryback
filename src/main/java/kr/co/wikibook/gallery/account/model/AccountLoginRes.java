package kr.co.wikibook.gallery.account.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountLoginRes {
    private int id;
    @JsonIgnore // 출력안됨
    private String loginPw;
}
