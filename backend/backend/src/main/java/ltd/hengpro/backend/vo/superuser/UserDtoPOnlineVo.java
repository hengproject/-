package ltd.hengpro.backend.vo.superuser;

import lombok.Data;
import ltd.hengpro.backend.dto.UserDto;

@Data
public class UserDtoPOnlineVo {
    UserDto userDto;
    Boolean online;

}
