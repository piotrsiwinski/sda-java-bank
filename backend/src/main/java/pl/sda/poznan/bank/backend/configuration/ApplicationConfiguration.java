package pl.sda.poznan.bank.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import pl.sda.poznan.bank.backend.converter.UserRegistrationVmToUserConverter;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        //register convertes here
        // userRegistrationVM to User Converter
        service.addConverter(new UserRegistrationVmToUserConverter());
        return service;
    }
}
