package com.example.springcaculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @RequestMapping("/")
    public String showForm() {
        return "index";
    }

    @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam("num1") double num1,
                                  @RequestParam("num2") double num2,
                                  @RequestParam("operator") String operator) {
        double result = 0;
        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    return new ModelAndView("index", "message", "Cannot divide by zero");
                }
                break;
            default:
                return new ModelAndView("index", "message", "Invalid operator");
        }
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("result", result);
        return mav;
    }
}
