package kr.co.wikibook.gallery.order;


import kr.co.wikibook.gallery.order.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    int save (OrderItemPostDto dto);
    List<OrderItemPostDto> findAllByOrderId(int orderId);
}
