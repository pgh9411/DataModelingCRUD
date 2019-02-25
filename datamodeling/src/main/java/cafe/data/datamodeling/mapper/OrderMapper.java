package cafe.data.datamodeling.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.data.datamodeling.vo.Account;
import cafe.data.datamodeling.vo.Order;
@Mapper
public interface OrderMapper {
	//1. 주문등록기능
	int orderAdd(Order order);
	//2. userId 이용해서 계좌번호 값 받아오기
	

	
}
