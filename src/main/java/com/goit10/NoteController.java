package com.goit10;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService ns;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView res = new ModelAndView("mynotes");
        res.addObject("notes", ns.listAll().values());
        res.addObject("note", new Note());
        return res;
    }

    @PostMapping("/delete")
    public RedirectView delete(@RequestParam(name = "id") long id) {
        ns.deleteById(id);
        return new RedirectView("/note/list");
    }

    @GetMapping ("/edit")
    public ModelAndView edit (@RequestParam(name = "id") long id) {
        ModelAndView res = new ModelAndView("edit");
        res.addObject("note", ns.getById(id));
        return res;
    }

    @PostMapping("/edit")
    public RedirectView updateNote (@RequestParam(name = "title") String title,
                                    @RequestParam(name = "content") String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);

        ns.upgradeById(note);

        return new RedirectView("/note/list");
    }

    @GetMapping("/create")
    public ModelAndView create () {
        return new ModelAndView("new");
    }

    @PostMapping("/create")
    public RedirectView newNote (@RequestParam(name = "title") String title,
                                 @RequestParam(name = "content") String content) {

        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);

        ns.add(note);

        return new RedirectView("/note/list");
    }
}
