package com.chinesefirst.chinese;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {



    private static List<Word> words = new ArrayList<Word>();

    static {
        words.add(new Word("天", "sky"));
        words.add(new Word("火", "fire"));
    }

    // Вводится (inject) из application.properties.
    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/wordList"}, method = RequestMethod.GET)
    public String wordsList(Model model) {

        model.addAttribute("words", words);
        return "wordList";
    }

    @RequestMapping(value = {"/addWord"}, method = RequestMethod.GET)
    public String showaddWordPage(Model model) {

        WordForm wordForm = new WordForm();
        model.addAttribute("wordForm", wordForm);
        return "addWord";
    }

    @RequestMapping(value = {"/addWord"}, method = RequestMethod.POST)
    public String saveWord(Model model, //
                           @ModelAttribute("wordForm") WordForm wordForm) {

        String word = wordForm.getWord();
        String translation = wordForm.getTranslation();

        if (word != null && word.length() > 0 //
                && translation != null && translation.length() > 0) {
            Word newWord = new Word(word, translation);
            words.add(newWord);

            return "redirect:/wordList";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addWord";
    }

}