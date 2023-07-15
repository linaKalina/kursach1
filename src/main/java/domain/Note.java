package domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Getter
public class Note {
    private static final Logger log = Logger.getLogger(Note.class.getName());
    public static List<Note> notes = new ArrayList<>();
    private int id;
    private String text;
    private List<String> label;

    public Note(String text, List<String> label) {
        this.id = ID.generateId();
        this.text = text;
        this.label = label;
    }
    @Override
    public String toString() {
        return "{" + id + "}" + "#" + "{" + text + "}" + "\n" + label;
    }
}
