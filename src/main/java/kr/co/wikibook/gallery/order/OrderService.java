package kr.co.wikibook.gallery.order;


import kr.co.wikibook.gallery.item.*;
import kr.co.wikibook.gallery.item.model.ItemGetRes;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
  private final OrderMapper orderMapper;
  private final ItemMapper itemMapper;



  public int saveOrder (OrderPostReq req) {
      //상품 정보를 db에서 가져온다
//      ItemGetRes items = itemMapper.findAllByIdIn(req.getItemIds());

      return 1;
    }
}
