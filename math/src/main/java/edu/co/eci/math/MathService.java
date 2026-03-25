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


    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam String list, @RequestParam String value) {

        int target = Integer.parseInt(value);

        List<Integer> original = Arrays.stream(list.split(","))
                .map(Integer::parseInt)
                .toList();

        List<Integer> valores = original.stream()
                .sorted()
                .toList();

        int low = 0;
        int high = valores.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (valores.get(mid) == target) {
                int indexOriginal = original.indexOf(target);

                return "{\n" +
                        " \"operation\": \"binarySearch\",\n" +
                        " \"inputlist\": \"" + list + "\",\n" +
                        " \"value\": \"" + value + "\",\n" +
                        " \"output\": \"" + indexOriginal + "\"\n" +
                        "}";
            }

            if (valores.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "{\n" +
                " \"operation\": \"binarySearch\",\n" +
                " \"inputlist\": \"" + list + "\",\n" +
                " \"value\": \"" + value + "\",\n" +
                " \"output\": \"-1\"\n" +
                "}";
    }
}
