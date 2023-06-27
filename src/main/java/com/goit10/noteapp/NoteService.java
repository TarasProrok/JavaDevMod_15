package com.goit10.noteapp;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NoteService {
    Map<Long, Note> notesList = new HashMap<>();

    public Map<Long, Note> listAll() {
        return notesList;
    }

    public Note add(Note note) {
        note.setId((note.getContent()).hashCode());
        notesList.put(note.getId(), note);
        return note;
    }

    public void deleteById (long id) {
        notesList.remove(id);
    }

    public void upgradeById (Note note) {
        long idNote = note.getId();
        if (notesList.containsKey(idNote)) {
            notesList.put(idNote, note);
        } else {
            throw new IllegalArgumentException("There is no note with such id!");
        }
    }

    public Note getById (long id) {
        return notesList.get(id);
    }
}
