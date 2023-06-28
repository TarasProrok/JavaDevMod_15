package com.goit10;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService {
    Map<Long, Note> notesList = new HashMap<>();

    public Map<Long, Note> listAll() {
        return notesList;
    }

    public Note add(Note note) {
        Random random = new Random();
        note.setId(random.nextLong());
        notesList.put(note.getId(), note);
        return note;
    }

    public void deleteById (long id) {
        notesList.remove(id);
    }

    public void upgradeById (Note note) {
        notesList.put(note.getId(), note);
    }

    public Note getById (long id) {
        return notesList.get(id);
    }
}
