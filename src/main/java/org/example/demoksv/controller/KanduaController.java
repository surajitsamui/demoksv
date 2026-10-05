package org.example.demoksv.controller;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SecurityRequirement(name = "bearerAuth")
public class KanduaController {

    @GetMapping("/hlloksv")
    public String getKanduatemple(){
        return "Hello wold";
    }
}
