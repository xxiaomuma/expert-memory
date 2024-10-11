package pers.xiaomuma.example.portal.converter;


import org.mapstruct.Mapper;
import pers.xiaomuma.example.portal.web.wrapper.vo.AccountVO;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountConverter {

    AccountVO convert2VO(AccountTO accountTO);

    List<AccountVO> convert2VO(List<AccountTO> accountTOS);
}
