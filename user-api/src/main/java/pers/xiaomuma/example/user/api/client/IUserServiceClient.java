package pers.xiaomuma.example.user.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pers.xiaomuma.example.user.api.UserServiceUrl;
import pers.xiaomuma.example.user.api.wrapper.po.QueryAccountPO;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;
import pers.xiaomuma.framework.page.PageResult;
import pers.xiaomuma.framework.response.BaseResponse;


@FeignClient(UserServiceUrl.SERVICE_NAME)
public interface IUserServiceClient {

    @PostMapping(UserServiceUrl.User.GET_LIST)
    BaseResponse<PageResult<AccountTO>> list(@RequestBody @Validated QueryAccountPO po);
}
