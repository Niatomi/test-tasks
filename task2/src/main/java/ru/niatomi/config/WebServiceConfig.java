package ru.niatomi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.niatomi.service.Impl.CalcServiceImpl;

/**
 * @author niatomi
 */
@Configuration
public class WebServiceConfig {

    @Value("${wsdl}")
    private String wsdlHost;

    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("ru.niatomi.calc.wsdl");
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(
                "http://"+ wsdlHost +":8080"+ wsdlHost +"/ws/equation.wsdl");
        System.out.println(wsdlHost);
        return webServiceTemplate;
    }

    @Bean
    @Primary
    public CalcServiceImpl CalcControllerImpl(Jaxb2Marshaller marshaller) {
        CalcServiceImpl service = new CalcServiceImpl();
        service.setDefaultUri("http://"+ wsdlHost +":8080/ws");
        service.setMarshaller(marshaller);
        service.setUnmarshaller(marshaller);
        return service;
    }

}
