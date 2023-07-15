package commands;

import exceptions.NoteException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static commands.Validate.printAllNotes;
import static commands.Validate.printSomeNotes;

public class NoteList implements CommandsHandler {
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

}
