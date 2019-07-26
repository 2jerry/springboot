package com.rubypaper;


import com.rubypaper.jdbc.util.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service // 컨테이너가 컴포넌트 스캔을 하도록
public class JDBCConnectionManagerRunner implements ApplicationRunner {

    /* ApplicationRunner를 구현했기 때문에 JDBCConnectionManager 객체가 생성되자마자
    *  컨테이너에 의해서 run() 메소드가 자동으로 실행된다.
    *
    * */
    @Autowired
    private JDBCConnectionManager connectionManager;

    public void run(ApplicationArguments args) throws Exception {
        System.out.println("커넥션 매니저 : "+connectionManager.toString());
    }
}
