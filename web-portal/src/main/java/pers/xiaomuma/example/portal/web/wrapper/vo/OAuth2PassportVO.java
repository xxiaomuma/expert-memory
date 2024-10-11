package pers.xiaomuma.example.portal.web.wrapper.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2PassportVO {

	private String accessToken;

	private String tokenType;

	private Integer expiresIn;

}
