package ru.ageev.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class CalculatorController {

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model) {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String stringResult;

        String action = request.getParameter("action");

        switch (action) {
            case "multiplication" -> stringResult = String.valueOf(a * b);
            case "addition" -> stringResult = String.valueOf(a + b);
            case "subtraction" -> stringResult = String.valueOf(a - b);
            case "division" -> stringResult = String.valueOf(a / b);

            default -> stringResult = "this action not exist";
        }

        model.addAttribute("result", "result a & b = " + stringResult);

        return "first/calculator";
    }
}
