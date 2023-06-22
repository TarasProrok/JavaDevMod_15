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


}
