package com.dina.tusk;

import com.dina.tusk.dao.FeedbackDao;
import com.dina.tusk.dao.QuestionDao;
import com.dina.tusk.entity.Feedback;
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

    @RequestMapping("/getQuestions.htm")
    @ResponseBody
    public String getQuestions()
    {
        List<Question> questions = new ArrayList<>();
        questions = qDao.getQuestions();
        return questions.toString();
    }
}
