package ru.niatomi.service.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.niatomi.service.CalcService;
import ru.niatomi.calc.wsdl.GetEquationRequest;
import ru.niatomi.calc.wsdl.GetEquationResponse;
import ru.niatomi.calc.wsdl.Solve;

/**
 * @author niatomi
 */
@Service
public class CalcServiceImpl extends WebServiceGatewaySupport implements CalcService {

    @Value("${wsdl}")
    private String wsdlHost;

    @Override
    public Solve solveEquation(Double a, Double b, Double c) {
        return getResponse(a, b, c).getSolve();
    }

    private GetEquationResponse getResponse(Double a, Double b, Double c) {

        GetEquationRequest request = new GetEquationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        GetEquationResponse response = (GetEquationResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://"+ wsdlHost +":8080/ws", request,
                        new SoapActionCallback(
                                "http://niatomi.ru/EquationSerivce"));

        return response;
    }
}
