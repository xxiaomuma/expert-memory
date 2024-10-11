package pers.xiaomuma.example.auth.service.service.biz;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pers.xiaomuma.example.auth.service.constant.DataSourceNames;
import pers.xiaomuma.example.auth.service.constant.Status;
import pers.xiaomuma.example.auth.service.crud.modules.client.domain.AccountExternal;
import pers.xiaomuma.example.auth.service.crud.modules.client.service.IAccountExternalService;
import pers.xiaomuma.example.auth.service.model.PasswordUserConnection;
import pers.xiaomuma.example.auth.service.model.SmsUserConnection;
import pers.xiaomuma.framework.support.database.annotation.DataSource;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountExternalBizService {

    private final Logger logger = LoggerFactory.getLogger(AccountExternalBizService.class);
    private final IAccountExternalService accountExternalService;

    @DataSource(DataSourceNames.EXAMPLE_CLIENT_READ)
    public SmsUserConnection loadUserByMobile(String mobile) {
        AccountExternal account = accountExternalService.findAccountByMobile(mobile);
        if (Objects.isNull(account)) {
            return null;
        }
        Status status = Status.of(account.getStatus());
        return  new SmsUserConnection(account.getId(), account.getUsername(), account.getPassword(), status.isEnable());
    }

    @DataSource(DataSourceNames.EXAMPLE_CLIENT_READ)
    public PasswordUserConnection loadUserByUsername(String username) {
        AccountExternal account = accountExternalService.findAccountByUsername(username);
        if (Objects.isNull(account)) {
            return null;
        }
        Status status = Status.of(account.getStatus());
        return  new PasswordUserConnection(account.getId(), account.getUsername(), account.getPassword(), status.isEnable());
    }

}
