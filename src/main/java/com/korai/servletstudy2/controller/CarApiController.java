package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.model.Car;
import com.korai.servletstudy2.service.CarService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/api/car")
public class CarApiController extends HttpServlet {
    private CarService carService;


    private void setCorsHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    private ObjectMapper om;

    @Override
    public void init(ServletConfig config) throws ServletException {
        carService = CarService.getInstance();
        om = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carService.getCar();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(om.writeValueAsString(cars));
        setCorsHeaders(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        setCorsHeaders(resp);

        Car car;
        try {
            car = om.readValue(req.getInputStream(), Car.class);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 요청 데이터입니다.");
            return;

        }

        System.out.println(car);
        carService.regist(car);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
        setCorsHeaders(resp);
    }
}