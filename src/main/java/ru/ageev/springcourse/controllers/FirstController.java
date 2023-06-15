package ru.ageev.springcourse.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model) {
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
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
