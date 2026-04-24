package conifg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @Author: Lee
 * @Description: TODO
 * @DateTime: 2026/4/22 下午5:10
 **/
public class JacksonConfig {
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return JsonMapper.builder()
                // 设置日期格式
                .defaultDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                // 设置时区
                .defaultTimeZone(TimeZone.getTimeZone("GMT+8"))
                // 相当于 configure(SerializationFeature.INDENT_OUTPUT, true)
                .enable(SerializationFeature.INDENT_OUTPUT)
                // 相当于忽略未知属性
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();

    }
}
