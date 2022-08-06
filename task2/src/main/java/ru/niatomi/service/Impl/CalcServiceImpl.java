package ru.niatomi.service.Impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
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
    public JSONObject solveEquation(int a, int b, int c) {
        GetEquationResponse response = getSolve(a, b, c);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("equation", response.getEquation());
        Solve solveClass = (Solve) response.getSolve();
        JSONObject solveJSON = new JSONObject();
        solveJSON.put("D", solveClass.getD());
        if (solveClass.getX1() != null) {
            solveJSON.put("x1", solveClass.getX1());
        }
        if (solveClass.getX2() != null) {
            solveJSON.put("x2", solveClass.getX2());
        }
        String error = response.getError();
        if (error != null) {
            jsonObject.put("error", error);
        }
        jsonObject.put("solve", solveJSON);
        return jsonObject;
    }

    private GetEquationResponse getSolve(int a, int b, int c) {

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
