package pers.xiaomuma.example.user.service.converter;


import org.mapstruct.Mapper;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;
import pers.xiaomuma.example.user.service.crud.domain.Account;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountConverter {

    AccountTO domain2VO(Account account);

    List<AccountTO> domain2VO(List<Account> accounts);
}
