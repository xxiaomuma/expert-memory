package pers.xiaomuma.example.portal.rpc.delegated;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import pers.xiaomuma.example.portal.rpc.UserServiceClient;
import pers.xiaomuma.example.user.api.wrapper.po.QueryAccountPO;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;
import pers.xiaomuma.framework.exception.AppBizException;
import pers.xiaomuma.framework.page.PageResult;
import pers.xiaomuma.framework.response.BaseResponse;
import pers.xiaomuma.framework.standard.service.RpcServiceHelper;

@Service
@RequiredArgsConstructor
public class UserServiceOutClient {

    private final Logger logger = LoggerFactory.getLogger(UserServiceOutClient.class);
    private final UserServiceClient userServiceClient;

    public PageResult<AccountTO> list(@RequestBody @Validated QueryAccountPO param) {
        BaseResponse<PageResult<AccountTO>> response = RpcServiceHelper.call("用户查询列表", param, userServiceClient::list);
        if (!response.isSuccess()) {
            throw new AppBizException(String.format("获取用户信息失败:%s", response.getMessage()));
        }
        return response.getData();
    }


}
