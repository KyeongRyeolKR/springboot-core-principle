package externalread.datasource;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Setter 대신 생성자를 통해 객체를 만드는 것 또한 지원한다!
 * 덕분에 누군가의 실수로 중간에 값을 변경하는 문제가 발생하지 않게 됐다.
 *
 * '@DefaultValue' 를 사용해서 값이 없을 때 기본 값을 지정해 줄 수 있다.
 *
 * 문제 : 그렇다면 누군가 잘못된 설정 값을 넣었을 때, 애플리케이션 로딩 시점에 예외를 발생하게 하는 방법은 없을까?
 * ex) max-connection 은 1 이상이여야 하는데, 누군가 0으로 설정해버렸다면?
 */
@Getter
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        private int maxConnection;
        private Duration timeout;
        private List<String> options = new ArrayList<>();

        public Etc(int maxConnection, Duration timeout, @DefaultValue("DEFAULT") List<String> options) {
            this.maxConnection = maxConnection;
            this.timeout = timeout;
            this.options = options;
        }
    }
}
