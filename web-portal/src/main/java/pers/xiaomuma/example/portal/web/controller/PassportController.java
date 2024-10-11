package pers.xiaomuma.example.portal.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.xiaomuma.example.portal.service.biz.PassportBizService;
import pers.xiaomuma.example.portal.web.wrapper.ro.LoginPasswordReq;
import pers.xiaomuma.example.portal.web.wrapper.ro.LoginSmsReq;
import pers.xiaomuma.example.portal.web.wrapper.vo.OAuth2PassportVO;
import pers.xiaomuma.framework.response.BaseResponse;
import pers.xiaomuma.framework.standard.service.ServiceHelper;
import pers.xiaomuma.framework.standard.service.ServiceResult;


@Api(tags = "授权")
@RestController
@RequestMapping("passport")
@RequiredArgsConstructor
public class PassportController {

    private final PassportBizService passportBizService;

    @ApiOperation("用户名登录")
    @PostMapping("/password")
    public BaseResponse<OAuth2PassportVO> passwordLogin(@RequestBody @Validated LoginPasswordReq req) {
        ServiceResult<OAuth2PassportVO> serviceResult = ServiceHelper.processing(() ->
            passportBizService.passwordLogin(req.getUsername(), req.getPassword())
        );
        return BaseResponse.response(serviceResult);
    }

    @ApiOperation("短信登录")
    @PostMapping("/sms")
    public BaseResponse<OAuth2PassportVO> smsLogin(@RequestBody @Validated LoginSmsReq req) {
        ServiceResult<OAuth2PassportVO> serviceResult = ServiceHelper.processing(() ->
            passportBizService.smsLogin(req.getMobile(), req.getCode())
        );
        return BaseResponse.response(serviceResult);
    }

}
