package ru.niatomi.service;

import org.json.JSONObject;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.niatomi.calc.wsdl.GetEquationResponse;

/**
 * @author niatomi
 */
public interface CalcService {

    JSONObject solveEquation(int a, int b, int c);

}
