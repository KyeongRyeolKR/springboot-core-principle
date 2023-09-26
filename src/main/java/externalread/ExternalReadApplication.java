package externalread;

import externalread.config.MyDataSourceConfigV1;
import externalread.config.MyDataSourceEnvConfig;
import externalread.config.MyDataSourceValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceEnvConfig.class)
//@Import(MyDataSourceValueConfig.class)
@Import(MyDataSourceConfigV1.class)
@SpringBootApplication(scanBasePackages = "externalread.datasource")
// @EnableConfigurationProperties 를 사용할 필요 없이 알아서 @ConfigurationProperties 를 스캔하는 옵션
@ConfigurationPropertiesScan
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }
}
