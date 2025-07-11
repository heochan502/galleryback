package kr.co.wikibook.gallery.order;


import jakarta.servlet.http.HttpServletRequest;
import kr.co.wikibook.gallery.account.etc.AccountConstants;
import kr.co.wikibook.gallery.common.util.HttpUtils;
import kr.co.wikibook.gallery.order.model.*;
import kr.co.wikibook.gallery.order.model.OrderPostReq;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

   @PostMapping
   public ResponseEntity<?> add( HttpServletRequest httpReq, @RequestBody OrderPostReq req) {
//        int result = orderService.add(req);
        int logginedId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
//        req.setMemberId(memberId);

        int result = orderService.saveOrder(req, logginedId);
//        log.info("req : {}", req);
//        int result = orderService.save(req);
//        return ResponseEntity.ok(result);
        return ResponseEntity.ok(1);
    }

   @GetMapping
    public  ResponseEntity<?> findAllByMemberIdOrderByIdDesc(HttpServletRequest httpReq) {
       int logginedId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
       List<OrderGetRes> result = orderService.findAll(logginedId);
       return ResponseEntity.ok(result);
   }
   @GetMapping("/{orderId}")
    public ResponseEntity<?> findDetail(HttpServletRequest httpReq,  @PathVariable int orderId) {
       int logginedId = (int)HttpUtils.getSessionValue(httpReq, AccountConstants.MEMBER_ID_NAME);
       OrderDetailGetReq req = new OrderDetailGetReq();

       req.setOrderId(orderId);
       req.setMemberId(logginedId);
    OrderDetailGetRes result = orderService.detail(req);
    return ResponseEntity.ok(result);

   }

}
