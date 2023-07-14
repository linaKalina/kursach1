package commands;

import domain.Note;
import exceptions.NoteException;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

import static domain.Note.notes;

public class NoteList implements CommandsHandler{
    private static final Logger log = Logger.getLogger(NoteList.class.getName());
    @Override
    public void handler() throws NoteException {
        log.fine("вызов команды поиска по меткам");
        System.out.println("Введите метки, чтобы отобразить определенные заметки " +
                "или оставьте пустым для отображения всех заметок");
        List<String> labels = Arrays.asList(new Scanner(System.in).nextLine().split(" "));
        new NewNote().labelValidation(labels);
        if (labels.get(0).equals("") && labels.size() == 1) {
            printAllNotes();
        } else {
            printSomeNotes(labels);
        }
    }
    private void printAllNotes() {
        log.fine("вызов команды печать всех заметок");
        for (Note n : notes) {
            System.out.println(n.toString());
        }
    }

    private void printSomeNotes(List<String> labels) throws NoteException {
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
