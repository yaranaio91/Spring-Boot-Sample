package sample.service;

import org.springframework.stereotype.Service;

@Service
//サービスって宣言してるようなもん
public class HelloService {

	public String hello() {

		return "Hello, Spring DI !!";
	}

}
