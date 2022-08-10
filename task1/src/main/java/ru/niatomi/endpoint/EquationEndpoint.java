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
    public GetEquationResponse getSolve(@RequestPayload GetEquationRequest request) throws DiscriminantBelowZeroException {
        GetEquationResponse response = new GetEquationResponse();
        try {
            Map<String, Solve> solveMap = equationService.solveEquation(request.getA(), request.getB(), request.getC());
            response.setEquation(solveMap.keySet().stream().findFirst().get());
            response.setSolve(solveMap.values().stream().findFirst().get());
        } catch (DiscriminantBelowZeroException ex) {
            response.setEquation(ex.getFormula());

            Solve solve = new Solve();
            solve.setD(ex.getD());
            response.setSolve(solve);

            response.setError(ex.getMessage());
        }

        return response;
    }

}
