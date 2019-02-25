package cafe.data.datamodeling.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.data.datamodeling.vo.Agency;
import cafe.data.datamodeling.vo.User;
@Mapper
public interface UserMapper {
	//01.로그인 기능
	User login(User user);
	
	//02. 회원가입 기능(추가)
	int userAdd(User user);
	//03. agencyCode 이용해서 agencyName,agencyUser값 받아오기
	Agency agencyCode(String user);
}
