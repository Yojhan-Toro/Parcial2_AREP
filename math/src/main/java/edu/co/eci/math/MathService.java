package edu.co.eci.math;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
public class MathService {


    @RequestMapping("/linearSearch")
    public String linearSearch(ArrayList<Integer> lista, int value){

        for(int i = 0; lista.size() > i ; i++){
            if(lista.get(i) == value){
                return "{\n" +
                        " \"operation\": \"linearSearch\",\n" +
                        " \"inputlist\": \""+lista.toString()+"\",\n" +
                        " \"value\": \""+ value +"\", \n" +
                        " \"output\":  \""+i+"\"\n" +
                        "}";
            }
        }
        return "{\n" +
                " \"operation\": \"linearSearch\",\n" +
                " \"inputlist\": \""+lista+"\",\n" +
                " \"value\": \""+ value +"\", \n" +
                " \"output\":  \""+ -1 +"\"\n" +
                "}";
    }


    @RequestMapping("/binarySearch")
    public String binarySearch(ArrayList<Integer> lista, int value) {

        lista.stream().sorted();




        return "-1";
    }

}
