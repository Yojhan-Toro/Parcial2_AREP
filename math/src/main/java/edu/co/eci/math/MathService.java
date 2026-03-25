package edu.co.eci.math;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class MathService {


    @GetMapping("/linearsearch")

    public String linearSearch(@RequestParam String list, @RequestParam String value){

        List<String> valores = Arrays.stream(list.split(",")).toList();

        for(int i = 0; valores.size() > i ; i++){
            if(Objects.equals(valores.get(i), value)){

                return "{\n" +
                        " \"operation\": \"linearSearch\",\n" +
                        " \"inputlist\": \""+list+"\",\n" +
                        " \"value\": \""+ value +"\", \n" +
                        " \"output\":  \""+i+"\"\n" +
                        "}";
            }
        }
        return "{\n" +
                " \"operation\": \"linearSearch\",\n" +
                " \"inputlist\": \""+list+"\",\n" +
                " \"value\": \""+ value +"\", \n" +
                " \"output\":  \""+ -1 +"\"\n" +
                "}";
    }


    @GetMapping("/binarySearch")
    public String binarySearch(String list, String value) {

        int numero = Integer.parseInt(value);
        List<String> valores = Arrays.stream(list.split(",")).toList();

        for(int i = 0; valores.size() > i ; i++) {


            if (Objects.equals(valores.get(i), numero)) {


            }
        }
    }



    public int[] transformar(List<String> ingresa){


        for(int i = 0; ingresa.size()>i; i++){

        }

        return null;

    }





}
