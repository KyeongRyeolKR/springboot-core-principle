package externalread.datasource;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

/**
 * 가상의 데이터소스 - DB 접근 X
 */
@Slf4j
public class MyDataSource {

    private String url;
    private String username;
    private String password;
    private int maxConnection; // 최대 연결 수
    private Duration timeout; // 응답 지연 시 타임아웃
    private List<String> options; // 연결 시 사용하는 기타 옵션들

    public MyDataSource(String url, String username, String password, int maxConnection, Duration timeout, List<String> options) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnection = maxConnection;
        this.timeout = timeout;
        this.options = options;
    }

    @PostConstruct
    public void init() {
        log.info("url = {}", url);
        log.info("username = {}", username);
        log.info("password = {}", password);
        log.info("maxConnection = {}", maxConnection);
        log.info("timeout = {}", timeout);
        log.info("options = {}", options);
    }
}
