package br.com.sis.configs;

import org.springframework.context.annotation.ComponentScan;

import br.com.sis.controllers.ItemController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackageClasses=ItemController.class)
public class SwaggerConfiguration {

}
