package pers.xiaomuma.example.portal.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.xiaomuma.example.portal.converter.AccountConverter;
import pers.xiaomuma.example.portal.converter.rpc.AccountRpcConverter;
import pers.xiaomuma.example.portal.rpc.delegated.UserServiceOutClient;
import pers.xiaomuma.example.portal.web.wrapper.ro.QueryAccountReq;
import pers.xiaomuma.example.portal.web.wrapper.vo.AccountVO;
import pers.xiaomuma.example.user.api.wrapper.po.QueryAccountPO;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;
import pers.xiaomuma.framework.page.PageResult;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountFacadeService {

    private final UserServiceOutClient userServiceOutClient;
    private final AccountConverter accountConverter;
    private final AccountRpcConverter accountRpcConverter;

    public PageResult<AccountVO> list(QueryAccountReq req) {
        QueryAccountPO accountPO = accountRpcConverter.converter(req);
        PageResult<AccountTO> pageResult = userServiceOutClient.list(accountPO);
        List<AccountTO> accountItems =  pageResult.getRecords();
        return new PageResult<>(pageResult, accountConverter.convert2VO(accountItems));
    }
}
