package pers.xiaomuma.example.user.service.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaomuma.example.user.api.UserServiceUrl;
import pers.xiaomuma.example.user.api.wrapper.po.QueryAccountPO;
import pers.xiaomuma.example.user.api.wrapper.to.AccountTO;
import pers.xiaomuma.example.user.service.service.AccountFacadeService;
import pers.xiaomuma.framework.page.PageResult;
import pers.xiaomuma.framework.response.BaseResponse;
import pers.xiaomuma.framework.standard.service.ServiceHelper;
import pers.xiaomuma.framework.standard.service.ServiceResult;

@Api(tags = "用户")
@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountFacadeService accountFacadeService;

    @ApiOperation("用户列表")
    @PostMapping(value = UserServiceUrl.User.GET_LIST)
    public BaseResponse<PageResult<AccountTO>> list(@RequestBody @Validated QueryAccountPO po) {
        ServiceResult<PageResult<AccountTO>> serviceResult = ServiceHelper.processing(() ->
                accountFacadeService.list(po)
        );
        return BaseResponse.response(serviceResult);
    }
}
