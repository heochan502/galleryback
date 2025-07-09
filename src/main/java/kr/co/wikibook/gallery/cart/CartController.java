package kr.co.wikibook.gallery.cart;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.account.etc.AccountConstants;
import kr.co.wikibook.gallery.cart.model.*;
import kr.co.wikibook.gallery.cart.model.CartPostReq;
import kr.co.wikibook.gallery.common.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;
    @PostMapping
    public ResponseEntity<?> save(HttpServletRequest httpReq, @RequestBody CartPostReq req) {
        log.info("req: {}", req);
        // 아래가 유저 아이디 가져오는 값
        int logginedMemberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        req.setMemberId(logginedMemberId);
        int result = cartService.save(req);
        return ResponseEntity.ok(result);
    }


    @GetMapping
    public  ResponseEntity<?> findAll(HttpServletRequest httpReq) {
        int memberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
        List<CartGetRes> result = cartService.findAll(memberId);
        return  ResponseEntity.ok(result);
    }
    @DeleteMapping
    // RequestParam은 객체 못가져옴
    public  ResponseEntity<?> delete(HttpServletRequest httpReq, @ModelAttribute CartDeleteReq req) {
        int memberId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
//        req.setMemberId(memberId);
        CartDeleteReq data = new CartDeleteReq(memberId, req.getItemId() );
        int result = cartService.remove(data);
        return  ResponseEntity.ok(result);
    }
}









