package com.goit10;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public List<NoteDTO> list() {
        return noteService.findAll().stream().map(NoteDTO::fromNote).collect(Collectors.toList());
    }

    @PostMapping("/delete")
    public RedirectView delete(@RequestParam(name = "id") long id) {
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }

    @GetMapping ("/edit")
    public ModelAndView edit (@RequestParam(name = "id") long id) {
        ModelAndView res = new ModelAndView("edit");
        res.addObject("note", noteService.getById(id));
        return res;
    }

    @PostMapping("/edit")
    public RedirectView updateNote (@RequestParam(name = "title") String title,
                                    @RequestParam(name = "content") String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);

        noteService.upgradeById(note);

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

        noteService.add(note);

        return new RedirectView("/note/list");
    }
//    @GetMapping("/list")
//    public ModelAndView list() {
//        ModelAndView res = new ModelAndView("mynotes");
//        res.addObject("notes", noteService.listAll().values());
//        res.addObject("note", new Note());
//        return res;
//    }
//
//    @PostMapping("/delete")
//    public RedirectView delete(@RequestParam(name = "id") long id) {
//        noteService.deleteById(id);
//        return new RedirectView("/note/list");
//    }
//
//    @GetMapping ("/edit")
//    public ModelAndView edit (@RequestParam(name = "id") long id) {
//        ModelAndView res = new ModelAndView("edit");
//        res.addObject("note", noteService.getById(id));
//        return res;
//    }
//
//    @PostMapping("/edit")
//    public RedirectView updateNote (@RequestParam(name = "title") String title,
//                                    @RequestParam(name = "content") String content) {
//        Note note = new Note();
//        note.setTitle(title);
//        note.setContent(content);
//
//        noteService.upgradeById(note);
//
//        return new RedirectView("/note/list");
//    }
//
//    @GetMapping("/create")
//    public ModelAndView create () {
//        return new ModelAndView("new");
//    }
//
//    @PostMapping("/create")
//    public RedirectView newNote (@RequestParam(name = "title") String title,
//                                 @RequestParam(name = "content") String content) {
//
//        Note note = new Note();
//        note.setTitle(title);
//        note.setContent(content);
//
//        noteService.add(note);
//
//        return new RedirectView("/note/list");
//    }
}
