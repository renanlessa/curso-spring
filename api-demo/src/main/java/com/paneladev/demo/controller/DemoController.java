package com.paneladev.demo.controller;

import com.paneladev.demo.controller.request.DemoRequest;
import com.paneladev.demo.controller.response.DemoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/get")
    public ResponseEntity<DemoResponse> get() {
        return ResponseEntity.ok(new DemoResponse("Hello Spring Boot!"));
    }

    @GetMapping("/get2")
    @ResponseStatus(HttpStatus.OK)
    public DemoResponse get2() {
        return new DemoResponse("Hello Spring Boot!");
    }

    @GetMapping("/get/{id}/info/{info}")
    public ResponseEntity<DemoResponse> get3(@PathVariable Long id,
                                             @PathVariable String info) {
        System.out.println("ID: " + id);
        System.out.println("Info: " + info);
        return ResponseEntity.ok(new DemoResponse("Message: " + id + " - " + info));
    }

    @GetMapping("/get4")
    public ResponseEntity<DemoResponse> get4(String param1, String param2) {
        System.out.println("Param1: " + param1);
        System.out.println("Param2: " + param2);
        return ResponseEntity.ok(new DemoResponse("Message"));
    }

    @GetMapping("/get5")
    public ResponseEntity<DemoResponse> get5(DemoRequest request) {
        System.out.println(request);
        return ResponseEntity.ok(new DemoResponse("Message"));
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody DemoRequest request) {
        System.out.println(request);
    }

    @PostMapping("/post2")
    public ResponseEntity<Void> post2(@RequestBody DemoRequest request) {
        System.out.println(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/put/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable Long id, @RequestBody DemoRequest request) {
        System.out.println(id);
        System.out.println(request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        System.out.println(id);
    }

}
