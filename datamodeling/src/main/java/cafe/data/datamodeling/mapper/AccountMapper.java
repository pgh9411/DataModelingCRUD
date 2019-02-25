package cafe.data.datamodeling.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.data.datamodeling.vo.Account;
@Mapper
public interface AccountMapper {
	//계좌번호 등록
	int accountAdd(Account account);
}
