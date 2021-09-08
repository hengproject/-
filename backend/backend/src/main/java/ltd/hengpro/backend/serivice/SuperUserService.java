package ltd.hengpro.backend.serivice;

import ltd.hengpro.backend.dto.SuperUserInfoDto;
import ltd.hengpro.backend.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SuperUserService {
    List<SuperUserInfoDto> superUserGetUserList(Pageable pageable) throws Exception;
    void loginOrLogout(UserDto userDto, boolean login);
}
