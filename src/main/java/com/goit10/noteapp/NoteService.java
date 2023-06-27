package com.goit10.noteapp;

import java.util.HashMap;
import java.util.Map;

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

    public Note upgradeById (Note note) {
        long idNote = note.getId();
        notesList.put(idNote, note);
        return note;
    }

    public Note getById (long id) {
        return notesList.get(id);
    }
}
