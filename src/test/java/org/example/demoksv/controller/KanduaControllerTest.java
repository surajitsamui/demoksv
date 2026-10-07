//package org.example.demoksv.controller;
//import org.example.demoksv.beanclasses.TestBean;
//import org.example.demoksv.service.EmployeeService;
//import org.example.demoksv.service.JwtService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//@WebMvcTest(KanduaController.class)
//class KanduaControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private JwtService jwtService;
//
//    @MockitoBean
//    private UserDetailsService userDetailsService;
//
//    @MockitoBean
//    public TestBean testBeannew;
//
//    @MockitoBean
//    EmployeeService employeeService;
//
//    @Test
//    void getKanduatemple_shouldReturnHelloWorld() throws Exception {
//        when(testBeannew.method())
//                .thenReturn("TestBean mean method logic");
//
//        mockMvc.perform(get("/hlloksv"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("TestBean mean method logic"));
//    }
//}