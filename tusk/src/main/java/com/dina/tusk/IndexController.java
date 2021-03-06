package com.dina.tusk;

import com.dina.tusk.dao.FeedbackDao;
import com.dina.tusk.entity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    FeedbackDao fdao;

    Feedback feedback;

    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("/feedback.htm")
    public String feedback() {
        return "feedback.jsp";
    }

    @RequestMapping("/addFeedback")
//    public String addFeedback(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("reg") String reg, @RequestParam("code") String code,@RequestParam("rating") int rating)
    public String addFeedback(@ModelAttribute("feedback") Feedback feedback)
    {

        //feedback = new Feedback(name,email, reg,code,rating);
        fdao.addFeedback(feedback);
        return "welcome.jsp";
    }
}
