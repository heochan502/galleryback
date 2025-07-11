package kr.co.wikibook.gallery.order;


import kr.co.wikibook.gallery.item.*;
import kr.co.wikibook.gallery.item.ItemMapper;
import kr.co.wikibook.gallery.item.model.ItemGetRes;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
  private final OrderMapper orderMapper;
  private final OrderItemMapper orderItemMapper;
  private final ItemMapper itemMapper;

 // 아래 save중 둘중하나라도 제대로안되면 둘다 실행 안된다
  @Transactional
  public int saveOrder (OrderPostReq req, int logginedId) {
      //상품 정보를 db에서 가져온다
      log.info("itemList={}", req);
      List<ItemGetRes> itemList = itemMapper.findAllByIdIn(req.getItemIds());
//      log.info("itemList={}", itemList.toArray());
      int amount =0;
    for (ItemGetRes item : itemList) {
        amount += item.getPrice()- ((item.getPrice()*item.getDiscountPer())/100);
    }
    log.info("itemList={}", amount);
//      OrderPostDto dto2 = new OrderPostDto();

//      OrderPostDto dto = new OrderPostDto( logginedId,req.getName(), req.getAddress(), req.getPayment(), req.getCardNumber(), amount);
      OrderPostDto dto = OrderPostDto.builder()
              .memberId(logginedId)
              .name(req.getName())
              .address(req.getAddress())
              .payment(req.getPayment())
              .cardNumber(req.getCardNumber())
              .amount(amount)
              .build();

      //데이터 insert  하면서 autoincrement 한값을 반환하는경우가 있다

      log.info("before dto={}", dto);
      // order에 입력하는거
      int result= orderMapper.save(dto);
      log.info("after dto={}", dto);
      OrderItemPostDto itemDto = new OrderItemPostDto(dto.getOrderId(), req.getItemIds());
        // order item에 입력하는거
      int resultDetail = orderItemMapper.save(itemDto);
      return 1;

  }
}
