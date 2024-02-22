package api.AllFunctions.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    private Contact contato(){
        return new Contact(
            "Heitor Pavanelli",//meu nome
            "http://meusite:8080",//url
            "heitorhernandes@hotmail.com"//meu email
        );
    }

    private ApiInfoBuilder infosApi(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Documentação API - Restful API");
        apiInfoBuilder.description("API com funções basicas utilizando Springboot restful");
        apiInfoBuilder.version("1.1");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Heitor Pavanelli");
        apiInfoBuilder.licenseUrl("http://Heitor.Pavanelli.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalhesAPI(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("api.AllFunctions.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infosApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }

}
