package commands;

import domain.Note;
import exceptions.NoteException;

import java.util.List;
import java.util.logging.Logger;

import static domain.Note.notes;

public class Validate {
    private static final Logger log = Logger.getLogger(Validate.class.getName());

    public static Note validationId(int id) {
        log.fine("вызов метода validationId");
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
    public static  void printAllNotes() {
        log.fine("вызов команды печать всех заметок");
        for (Note n : notes) {
            System.out.println(n.toString());
        }
    }
    public static void printSomeNotes(List<String> labels) throws NoteException {
        log.fine("вызов команды печать заметок по меткам");
        int i = 0;
        for (String lab : labels) {
            for (Note note : notes) {
                if (note.getLabel().contains(lab)) {
                    System.out.println(note);
                    i++;
                }
            }
        }
        if (i == 0) {
            log.info("введена некорректная метка");
            throw new NoteException("Такой метки нет");
        }
    }

}
