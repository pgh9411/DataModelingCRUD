package cafe.data.datamodeling.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.data.datamodeling.vo.Order;
@Mapper
public interface OrderMapper {
	int orderAdd(Order order);
}
