package ru.niatomi.service;

import org.json.JSONObject;

/**
 * @author niatomi
 */
public interface CalcService {

    JSONObject solveEquation(int a, int b, int c);

}
