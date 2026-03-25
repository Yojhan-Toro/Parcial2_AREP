package edu.co.eci.proxy;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    private final Enlace enlace;

    public ProxyController(Enlace enlace) {
        this.enlace = enlace;
    }

    @GetMapping("/linearsearch")
    public String linearSearch(HttpServletRequest request) {
        return enlace.delegate("/linearsearch", request.getQueryString());
    }

    @GetMapping("/binarysearch")
    public String binarysearch(HttpServletRequest request) {
        return enlace.delegate("/binarysearch", request.getQueryString());
    }

}