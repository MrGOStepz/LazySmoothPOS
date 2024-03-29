package com.lazysmooth.pos.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/images")
public class ResourceController extends AbstractController {
    @GetMapping(value = "/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String name) throws IOException {
        return Files.readAllBytes(Paths.get("./images/" + name));
    }
}