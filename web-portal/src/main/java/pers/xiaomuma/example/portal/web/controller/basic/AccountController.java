package pers.xiaomuma.example.portal.web.controller.basic;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pers.xiaomuma.example.portal.service.AccountFacadeService;
import pers.xiaomuma.example.portal.web.wrapper.ro.QueryAccountReq;
import pers.xiaomuma.example.portal.web.wrapper.vo.AccountVO;
import pers.xiaomuma.framework.page.PageResult;
import pers.xiaomuma.framework.response.BaseResponse;
import pers.xiaomuma.framework.standard.service.ServiceHelper;
import pers.xiaomuma.framework.standard.service.ServiceResult;

@Api(tags = "用户")
@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountFacadeService accountFacadeService;

    @ApiOperation("用户列表")
    @PostMapping("list")
    public BaseResponse<PageResult<AccountVO>> list(@RequestBody @Validated QueryAccountReq req) {
        ServiceResult<PageResult<AccountVO>> serviceResult = ServiceHelper.processing(() ->
                accountFacadeService.list(req)
        );
        return BaseResponse.response(serviceResult);
    }
}
