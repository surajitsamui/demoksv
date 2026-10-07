package org.example.demoksv.controller;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.demoksv.beanclasses.TestBean;
import org.example.demoksv.entity.LazyLoadingBean;
import org.example.demoksv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SecurityRequirement(name = "keycloak")
public class KanduaController {

    @Autowired
    public TestBean testBeannew;

    @Autowired
//    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;
//    @Autowired
//    LazyLoadingBean lazyBean;

    @GetMapping("/hlloksv")
    public String getKanduah() {
        return testBeannew.method();
    }
}
