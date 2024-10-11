package pers.xiaomuma.example.user.service.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pers.xiaomuma.example.user.api.wrapper.po.QueryAccountPO;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;
import pers.xiaomuma.example.user.service.converter.AccountConverter;
import pers.xiaomuma.example.user.service.crud.domain.Account;
import pers.xiaomuma.example.user.service.crud.param.QueryAccountParam;
import pers.xiaomuma.example.user.service.crud.service.IAccountService;
import pers.xiaomuma.framework.exception.AppBizException;
import pers.xiaomuma.framework.page.PageResult;
import pers.xiaomuma.framework.support.database.utils.PageUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountFacadeService {

    private final IAccountService accountService;
    private final AccountConverter accountConverter;

    public PageResult<AccountTO> list(QueryAccountPO po) {
        QueryAccountParam param = QueryAccountParam.builder()
                .status(po.getStatus())
                .pageNum(po.getPageNum())
                .pageSize(po.getPageSize())
                .build();
        IPage<Account> page = accountService.findNormalAccountList(param);
        if (PageUtils.isEmpty(page)) {
            return PageResult.emptyPage();
        }
        List<AccountTO> accountVOS = accountConverter.domain2VO(page.getRecords());
        return new PageResult<>(page.getPages(), page.getSize(), page.getTotal(), accountVOS);
    }

}
