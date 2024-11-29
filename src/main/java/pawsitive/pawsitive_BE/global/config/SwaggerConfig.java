package pawsitive.pawsitive_BE.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pawsitiveAPI() {
        // Info 객체 생성
        Info info = new Info()
                .title("Pawsitive API")
                .description("Pawsitive API 명세서")
                .version("1.0.0")
                .contact(new Contact()
                        .name("API Support")
                        .url("http://www.example.com")
                        .email("support@example.com"));

        return new OpenAPI()
                .addServersItem(new Server().url("http://localhost:8080")) // 실제 서버 URL로 변경
                .info(info); // API 정보 설정
    }
}
