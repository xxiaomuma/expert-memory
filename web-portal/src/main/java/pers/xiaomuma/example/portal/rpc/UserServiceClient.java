package pers.xiaomuma.example.portal.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import pers.xiaomuma.example.user.api.UserServiceUrl;
import pers.xiaomuma.example.user.api.client.IUserServiceClient;



@FeignClient(UserServiceUrl.SERVICE_NAME)
public interface UserServiceClient extends IUserServiceClient {
}
