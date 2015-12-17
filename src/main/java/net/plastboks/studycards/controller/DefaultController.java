package net.plastboks.studycards.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alex on 12/17/15.
 */
@RestController
public class DefaultController
{
    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String root(@RequestParam(value="name", defaultValue="World")
                             String name)
    {
        return "";
    }
}
