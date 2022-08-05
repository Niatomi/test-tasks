package ru.niatomi.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.niatomi.equationserivce.GetEquationRequest;
import ru.niatomi.equationserivce.GetEquationResponse;
import ru.niatomi.equationserivce.Solve;
import ru.niatomi.exceptions.DiscriminantBelowZeroException;
import ru.niatomi.service.EquationService;
import ru.niatomi.service.Impl.EquationServiceImpl;

import java.util.Map;

/**
 * @author niatomi
 */
@Endpoint
@AllArgsConstructor
public class EquationEndpoint {

    private static final String NAMESPACE_URI = "http://niatomi.ru/EquationSerivce";

    private final EquationService equationService = new EquationServiceImpl();

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEquationRequest")
    @ResponsePayload
    public GetEquationResponse getCountry(@RequestPayload GetEquationRequest request) {
        GetEquationResponse response = new GetEquationResponse();
        try {
            Solve solve = equationService.solveEquation(request.getA(), request.getB(), request.getC());
            response.setEquation(equationService.equationConcater(request.getA(), request.getB(), request.getC()));
            response.setSolve(solve);
        } catch (DiscriminantBelowZeroException ex) {
            Solve solve = new Solve();
            response.setEquation(equationService.equationConcater(request.getA(), request.getB(), request.getC()));
            response.setSolve(solve);
            response.setError(ex.getMessage());
        }
        return response;
    }

}
