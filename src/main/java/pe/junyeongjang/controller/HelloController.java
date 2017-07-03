package pe.junyeongjang.controller;

import pe.junyeongjang.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloController {
    private final HelloWorldService helloWorldService;

//    @Autowired
//    public HelloController(HelloWorldService helloWorldService) {
//        this.helloWorldService = helloWorldService;
//    }

    public HelloController() {
        this.helloWorldService = new HelloWorldService();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());

        return "hello";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");

        model.addObject("name", helloWorldService.getTitle(name));
        model.addObject("msg", helloWorldService.getDesc());

        return model;
    }
}