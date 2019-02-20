package cafe.data.datamodeling.mapper;

import org.apache.ibatis.annotations.Mapper;

import cafe.data.datamodeling.vo.User;
@Mapper
public interface UserMapper {
	//01.로그인 기능
	User login(User user);
		
}
