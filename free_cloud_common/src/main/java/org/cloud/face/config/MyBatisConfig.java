package org.cloud.face.config;

import org.cloud.face.interceptor.SqlStatementInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: MyBatisConfig
 * @description:
 * @author: liulin
 * @create: 2020-06-03 16:12
 * @Version: 1.0
 */
@Configuration
public class MyBatisConfig {

	/**
	 * 配置 sql打印拦截器
	 * application.yml中 pms-config.showsql: true 时生效
	 *
	 * @return SqlStatementInterceptor
	 */
	@Bean
	@ConditionalOnProperty(name = "free_cloud.showsql", havingValue = "true")
	SqlStatementInterceptor sqlStatementInterceptor() {
		return new SqlStatementInterceptor();
	}
}
