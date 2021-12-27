package br.com.bancotoyota.services.sharepoint.docs.config;


import com.fasterxml.classmate.TypeResolver;

import br.com.bancotoyota.services.sharepoint.docs.exception.Erro;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.OperationNameGenerator;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ModelReference;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.Defaults;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.*;
import java.util.stream.Collectors;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@Profile("swagger") // só é usado para comparar o swagger no arquivo com o swagger criado a partir do fonte no teste SwaggerTest
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Value("${server.servlet.contextPath}")
    private String contextPath;

    @Bean
    public Docket swaggerSpringMvcPlugin(ApiInfo apiInfo) {

        TypeResolver typeResolver = new TypeResolver();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("default") // usar nome default para não precisar especificar parametro na URL
                .select()
                .apis(withClassAnnotation(Api.class)) //Selection by RequestHandler
                .build()
                .apiInfo(apiInfo)
                .tags(new Tag("Arquivos",
                        "Arquivos no Sharepoint em Documentos Compartilhados"), new Tag("Pastas","Pasta no Sharepoint em Documentos CompartilhadosArquivos"))
                .host("api-sharepoint-docs-sharepoint.apps.dev.cloud.corp")
                .protocols(new HashSet<>(Arrays.asList("http")))
                .additionalModels(typeResolver.resolve(Erro.class))
                .pathProvider(new DefaultPathProvider() {
                    @Override
                    public String getOperationPath(String operationPath) {
                        // removendo contexto da app de cada operation path
                        if (operationPath.startsWith(contextPath)) {
                            operationPath = operationPath.substring(contextPath.length());
                        }
                        return super.getOperationPath(operationPath);
                    }

                    @Override
                    protected String getDocumentationPath() {
                        return "/v2";
                    }
                });
    }
    
    @Bean
    @Autowired
    public ApiInfo apiInfo(@Value("${maven.build.timestamp}") String buildTimestamp) {
 	   return new ApiInfoBuilder()
 	            .title("API Sharepoint Documentos")
 	            .description("API Sharepoint Documentos")
 	            .termsOfServiceUrl("https://developers.bancotoyota.com.br/help/termos")
 	            .version("1.0.0")
 	            .contact(new Contact("","", "api@bancotoyota.com.br"))
 	            .build();
    }

    /**
     *  Desabilita a geração do operationId
     */
    @Bean
    @Primary
    public OperationNameGenerator operationNameGenerator() {
        return prefix -> null;
    }

    @Bean
    @Primary
    public Defaults appDefaults() {
        return new Defaults() {
            @Override
            public Map<RequestMethod, List<ResponseMessage>> defaultResponseMessages() {
                Map<RequestMethod, List<ResponseMessage>> map = super.defaultResponseMessages();
                Map<RequestMethod, List<ResponseMessage>> newMap = new EnumMap<>(RequestMethod.class);
                ModelReference modelReference = new ModelRef("List", new ModelRef(Erro.class.getSimpleName()));
                map.forEach((key, list) -> {
                    List<ResponseMessage> newList = list.stream()
                            .filter(rm -> rm.getCode() != 401 && rm.getCode() != 404 &&  rm.getCode() != 403 && rm.getCode() != 200 && rm.getCode() != 201)
                            .map(rm ->
                                    new ResponseMessageBuilder()
                                            .code(rm.getCode())
                                            .message(rm.getMessage())
                                            .responseModel(modelReference)
                                            .build()
                            ).collect(Collectors.toList());
                    newMap.put(key, newList);
                    newList.add(new ResponseMessageBuilder()
                            .code(HttpStatus.BAD_REQUEST.value())
                            .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .responseModel(modelReference)
                            .build());
                    newList.add(new ResponseMessageBuilder()
                            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                            .responseModel(modelReference)
                            .build());
                });
                return newMap;
            }
        };
    }
}
