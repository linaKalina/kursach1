package commands;

import exceptions.NoteException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Controller {
    private static final Logger log = Logger.getLogger(Controller.class.getName());
    private CommandsHandler comHelp = new CommandHelp();
    public void control() {
        log.fine("вызов метода контроллера");
        while (true) {
            System.out.println("Это Ваша записная книжка. Вот список доступных команд:");
            Arrays.stream(Commands.values()).forEach(System.out :: println);
            System.out.println("Введите команду:(через дефис, где необходимо)");
            String inputCommand = new Scanner(System.in).nextLine();
            try {
                checkInputCommand(inputCommand);
            } catch (NoteException e) {
                e.getMessage();
            }
        }
    }
    private void checkInputCommand(String input) throws NoteException {
        log.fine("вызов метода проверки введенной команды");
        if ("help".equals(input.toLowerCase())) {
            new CommandHelp().handler();
        } else if ("note-new".equals(input.toLowerCase())) {
            new NewNote().handler();
        } else if ("note-list".equals(input.toLowerCase())) {
            new NoteList().handler();
        } else if ("note-remove".equals(input.toLowerCase())) {
            new RemoveNote().handler();
        } else if ("note-export".equals(input.toLowerCase())) {
            new NoteExport().handler();
        } else if ("exit".equals(input.toLowerCase())) {
            new CommandExit().handler();
        } else {
            log.warning("введена неверная команда");
            throw new NoteException("Введена неверная команда");
        }
    }



}
