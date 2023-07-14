package commands;

import domain.Note;
import exceptions.NoteException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class NewNote implements CommandsHandler{
    private static final Logger log = Logger.getLogger(NewNote.class.getName());

    @Override
    public void handler() throws NoteException {
        log.fine("вызов команды добавления новой заметки");
        System.out.println("Введите заметку");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        textValidation(text);
        System.out.println("Добавить метки? Метки состоят из одного слова и могу содержать только буквы." +
                " Для добавления нескольких меток разделяйте слова пробелом.");
        List<String> labels = Arrays.stream(scanner.nextLine().split(" ")).map(String::toUpperCase).toList();
        labelValidation(labels);
        Note.notes.add(new Note(text,labels));
        System.out.println("Заметка добавлена");
    }

    public void textValidation(String text) throws NoteException {
        log.fine("проверка введенного текста");
        if (text.length() <= 3) {
            log.info("текст заметки должен быть длиннее 3 символов, введено - " + text);
            throw new NoteException("Введен текст до 3 символов");
        }
    }
    public void labelValidation(List<String> labels) throws NoteException {
        log.fine("проверка меток");
        for (String l : labels) {
            if (!l.matches("[a-zA-Zа-яА-Я]*")) {
                log.info("Метки должны состоять только из букв, введено - " + l);
                throw new NoteException ("Введены некорректные метки");
            }
        }
    }
}
