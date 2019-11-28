//package com.isp;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.web.client.RestTemplate;
//import util.ResourceLoader;
//
//import static org.hamcrest.core.StringContains.containsString;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
//import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
//
//@RunWith(SpringRunner.class)
//public class ChlamydiaControllerTest {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private ResourceLoader resourceLoader;
//
//    //TODO: write mock server to test logic
//    @Test
//    void getQuestions() {
//        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
//        String response = resourceLoader.getResourceAsString("pathToInputJson");
//    }
//}
