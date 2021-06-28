# framework-demo-mybatis
## mybatis 설정방법

1. pom.xml에 디펜던시를 추가한다.
```
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.2.0</version>
		</dependency>
		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter-test</artifactId>
		    <version>2.2.0</version>
		    <scope>test</scope>
		</dependency>
```

2. application.yml에 데이터소스 설정을 추가한다.
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres?currentSchema=x2commerce
    driver-class-name: org.postgresql.Driver
    username: dbuser
    password: dbuserpass
    hikari:
      maximum-pool-size: 5
      minimum-idle: 5
      connection-timeout: 30000
      validation-timeout: 5000
      max-lifetime: 1800000
      idle-timeout: 300000
```

3. application.yml에 mybatis 설정을 추가한다.
```
mybatis:
  type-aliases-package: kr.co.ensmart.frameworkdemo.**.dto
  mapper-locations: classpath:mapper/**/*.xml
  configuration:
    map-underscore-to-camel-case: true
    default-fetch-size: 100
    default-statement-timeout: 30
```

4. application.yml에 쿼리 로거 설정을 추가한다.
```
logging:
  level:
    kr.co.ensmart.frameworkdemo.app.dao: debug
```

5. 설정파일에 @MapperScan 어노테이션을 추가하여 mapper interface java 파일의 베이스 패키지를 지정한다.
```
@SpringBootApplication
@MapperScan(basePackages = "kr.co.ensmart.frameworkdemo.app.dao")
public class FrameworkDemoMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkDemoMybatisApplication.class, args);
	}

}
```

6. Mapper  자바 interface 와 mybatis mapper xml 파일을 작성한다.
```
public interface SampleMapper {
	List<Sample> selectAllSampleList();
	
	Sample selectSampleById(Integer id);

}
```

```
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="kr.co.ensmart.frameworkdemo.app.dao.sample.SampleMapper">
	<select id="selectAllSampleList" resultType="sample">
		/* TestMapper.selectAllTestList */
		select
			id,
			name,
			description,
			sys_reg_dtime,
			sys_regr_id,
			sys_mod_dtime,
			sys_modr_id
		from sample
	</select>

	<select id="selectSampleById" parameterType="int" resultType="sample">
		/* TestMapper.selectSampleById */
		select
			id,
			name,
			description,
			sys_reg_dtime,
			sys_regr_id,
			sys_mod_dtime,
			sys_modr_id
		from sample
		where id = #{id}
	</select>
</mapper>
```





