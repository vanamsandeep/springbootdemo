
[spring boot documentation-guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#documentation)

Important topics added here.

# **Using the @SpringBootApplication Annotation**

Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their "application class". A single @SpringBootApplication annotation can be used to enable those three features, that is:

* @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism

* @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)

* @SpringBootConfiguration: enable registration of extra beans in the context or the import of additional configuration classes. An alternative to Spring’s standard @Configuration that aids configuration detection in your integration tests.

## **Using the Gradle Plugin**

The Spring Boot Gradle plugin also includes a bootRun task that can be used to run your application in an exploded form. The bootRun task is added whenever you apply the org.springframework.boot and java plugins and is shown in the following example:

$ gradle bootRun

### **Developer Tools**

Spring Boot includes an additional set of tools that can make the application development experience a little more pleasant. The spring-boot-devtools module can be included in any project to provide additional development-time features. To include devtools support, add the module dependency to your build, as shown in the following listings for Maven and Gradle:

Gradle:
dependencies {
developmentOnly("org.springframework.boot:spring-boot-devtools")
}

# **Lazy Initialization**

SpringApplication allows an application to be initialized lazily. When lazy initialization is enabled, beans are created as they are needed rather than during application startup. As a result, enabling lazy initialization can reduce the time that it takes your application to start. In a web application, enabling lazy initialization will result in many web-related beans not being initialized until an HTTP request is received.

A downside of lazy initialization is that it can delay the discovery of a problem with the application. If a misconfigured bean is initialized lazily, a failure will no longer occur during startup and the problem will only become apparent when the bean is initialized. Care must also be taken to ensure that the JVM has sufficient memory to accommodate all of the application’s beans and not just those that are initialized during startup. For these reasons, lazy initialization is not enabled by default and it is recommended that fine-tuning of the JVM’s heap size is done before enabling lazy initialization.

Lazy initialization can be enabled programmatically using the lazyInitialization method on SpringApplicationBuilder or the setLazyInitialization method on SpringApplication. Alternatively, it can be enabled using the spring.main.lazy-initialization property as shown in the following example:

PropertiesYaml
spring.main.lazy-initialization=true

_**If you want to disable lazy initialization for certain beans while using lazy initialization for the rest of the application, you can explicitly set their lazy attribute to false using the @Lazy(false) annotation.**_

# **Customizing the Banner**

The banner that is printed on start up can be changed by adding a banner.txt file to your classpath or by setting the spring.banner.location property to the location of such a file. If the file has an encoding other than UTF-8, you can set spring.banner.charset.

Inside your banner.txt file, you can use any key available in the Environment as well as any of the following placeholders: