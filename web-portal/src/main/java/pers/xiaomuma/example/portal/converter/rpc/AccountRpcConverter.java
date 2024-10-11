package pers.xiaomuma.example.portal.converter.rpc;


import org.mapstruct.Mapper;
import pers.xiaomuma.example.portal.web.wrapper.ro.QueryAccountReq;
import pers.xiaomuma.example.user.api.wrapper.po.QueryAccountPO;

@Mapper(componentModel = "spring")
public interface AccountRpcConverter {

    QueryAccountPO converter(QueryAccountReq req);
}
