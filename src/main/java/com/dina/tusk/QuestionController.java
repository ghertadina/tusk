package com.dina.tusk;

import com.dina.tusk.dao.FeedbackDao;
import com.dina.tusk.dao.QuestionDao;
import com.dina.tusk.entity.Feedback;
import com.dina.tusk.entity.Quest;
import com.dina.tusk.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionDao qDao;

    @RequestMapping("/saveQuestion.htm")
    public ModelAndView saveQuestion(@ModelAttribute Question q) {
        ModelAndView mv = new ModelAndView("printQuestions.jsp");

        qDao.saveQuestion(q);
        return mv;
    }

    @RequestMapping("/getQuestions")
    @ResponseBody
    public List<Question> getQuestions()
    {
        List<Question> questions = qDao.getTestQuestions();
        System.out.println(questions);
        return questions;
    }

    @RequestMapping("/test.htm")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("test.jsp");
        return mv;
    }

    @RequestMapping("/verify.htm")
    public ModelAndView verify(@ModelAttribute Quest quest) {

        int result = qDao.verify(quest);

        ModelAndView mv = new ModelAndView("result.jsp");

        mv.addObject("result", result);
        return mv;
    }
}
