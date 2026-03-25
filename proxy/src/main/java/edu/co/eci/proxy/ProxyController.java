package edu.co.eci.proxy;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    Enlace a = new Enlace();

    public ProxyController(Enlace a) {
        this.a = a;
    }

    @GetMapping("/linearSearch")
    public String factorial(HttpServletRequest request) {
        return a.delegate("/linearSearch", request.getQueryString());
    }


}
