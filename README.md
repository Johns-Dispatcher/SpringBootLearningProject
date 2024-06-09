## SpringBootLearningProject

---

学习SpringBoot相关技术

### 参考视频

https://www.bilibili.com/video/BV1Km4y1k7bn/

### 构建环境

- `JDK : 17`
- `Maven : 3.9.6`
- `SpringBoot : 3.2.6`

### 各模块说明
#### [jdk-new-feature-test](jdk-new-feature-test) | 测试JDK新特性
- 测试Record相关使用
- 测试Switch相关新特性
- 测试文本块定义
- 测试var声明变量方式
- 测试sealed密闭类

#### [springboot-case-001](springboot-case-001) | 使用脚手架环境创建项目

#### [springboot-case-002](springboot-case-002) | 使用IDEA快速搭建项目

#### [springboot-case-003-single-module](springboot-case-003-single-module) | SpringBoot单模块目录结构

#### [springboot-case-004-muti](springboot-case-004-muti) | SpringBoot多模块目录结构

#### [springboot-case-005](springboot-case-005) | SpringBoot初始使用

#### [springboot-case-006](springboot-case-006) | SpringBoot默认配置文件使用

- 配置 `application.properties` 文件
- 配置 `application.yml` 文件
- 了解 `YAML` 语法
- 测试环境对象
- 测试多配置文件的使用
- 测试多环境配置文件的使用
- 配置文件注入至Bean对象的属性

#### [springboot-case-008-aop](springboot-case-008-aop) | SpringBoot Aop相关使用
- 与Spring框架的AOP使用方法一致

#### [springboot-case-009-jdbc](springboot-case-009-jdbc) | SpringBoot 连接数据库

- 使用JDBC模板类完成

#### [springboot-case-010-mybatis](springboot-case-010-mybatis) | SpringBoot 集成MyBatis框架使用

- 使用 `MyBatis` 注解式开发方式完成数据库CRUD
- 测试ResultMap结果映射
- 使用注解完成 `MyBatis` 的高级映射
- 连接池的基础配置

#### [springboot-case-011-transcation](springboot-case-011-transcation) | SpringBoot 启用事务管理

- 启用方式和 `Spring` 框架一致
- 使用 `@Transactional` 注解

#### [springboot-case-012-web](springboot-case-012-web) | SpringBoot 快速搭建Web项目

- 使用 `SpringBoot` 快速搭建Web项目（SpringMVC）
- 视图技术采用 `Thymeleaf`
- 使用 `SpringMVC` 接收处理请求
- 响应 `JSON` 格式数据
- 使用 `JSR-303` 提供注解进行数据验证

#### [springboot-case-013](springboot-case-013) | SpringBoot 配置Servlet、Filter等

- 在SpringBoot中使用 `ServletRegistrationBean` 配置Servlet对象
- 在SpringBoot中使用 `FilterRegistrationBean` 配置过滤器类

#### [springboot-case-014-webconfig](springboot-case-014-webconfig) | SpringBoot 配置 SpringMVC 相关配置

- 通过 `WebMvcConfigurer` 接口完成相关配置
- 配置拦截器 `Interceptor`
- 配置 `Formatter` 完成数据的格式化转换

#### [springboot-case-015-file](springboot-case-015-file) | SpringBoot 完成文件上传并回显信息

- 通过 `MultipartFile` 对象完成上传文件的读取与写入
- 通过配置资源处理器的方式完成上传后的文件回显

#### [springboot-case-016-exception](springboot-case-016-exception) | 进行Web相关的异常处理

- 使用异常处理器

#### [springboot-case-017-problem-detail](springboot-case-017-problem-detail) | 使用 ProblemDetail 进行异常处理

- 直接返回 `ProblemDetail` 对象进行异常处理
- 返回 `ErrorResponseException` 对象，在其中夹带 `ProblemDetail` 对象完成异常处理

#### [springboot-case-018](springboot-case-018) | 使用 HttpExchange 完成远程访问

- 使用 `@HttpExchange` 相关注解进行远程访问请求设置
- 配置请求接口的代理对象，通过 `WebClient` 和 `HttpServiceProxyFactory` 创建代理对象
- 通过对 `HttpConfig` 对象和 `WebClient` 对象设置完成自定义的远程访问设置