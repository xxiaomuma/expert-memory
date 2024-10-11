package pers.xiaomuma.example.auth.service.service.biz;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.xiaomuma.example.auth.service.constant.DataSourceNames;
import pers.xiaomuma.example.auth.service.crud.modules.auth.domain.OauthClientDetails;
import pers.xiaomuma.example.auth.service.crud.modules.auth.service.IOauthClientDetailsService;
import pers.xiaomuma.framework.support.database.annotation.DataSource;


@Service
@RequiredArgsConstructor
public class OauthClientDetailsBizService {

    private final IOauthClientDetailsService oauthClientDetailsService;

    @DataSource(DataSourceNames.EXAMPLE_AUTH_READ)
    public OauthClientDetails loadClientByClientId(String clientId) {
        return oauthClientDetailsService.loadClientByClientId(clientId);
    }
}
