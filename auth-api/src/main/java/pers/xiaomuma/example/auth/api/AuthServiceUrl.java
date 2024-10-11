package pers.xiaomuma.example.auth.api;


public interface AuthServiceUrl {

	String SERVICE_NAME = "auth-service";

	interface Auth {
		String GET_TOKEN = "/oauth/token";
		String CHECK_TOKEN_URL = "/oauth/check_token";
	}

}
