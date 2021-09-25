package com.quranSchool.backcend.conroller;

import com.quranSchool.backcend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;


//    private  Rrepository

    public TestController() {
    }

    @RequestMapping("request")
    private String getController(){

        return "good morning jou how are you public static void main good morning bassel " +
                "good jop pro for good writib=ng posting posit goosd fot tuo awt wa;;a good jop " +
                "ya3ny how to create toaster in angular sopring boot good day in engllish invistigation investigation advertesment advertisement good jop cdreatrre angular project using sprung boot 4";

    }

    private void getTotal(){
        int main;
//        User user =
    }
}
