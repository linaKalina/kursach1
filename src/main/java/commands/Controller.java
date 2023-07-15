package commands;

import exceptions.NoteException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Controller {
    private static final Logger log = Logger.getLogger(Controller.class.getName());
    private static final Map<String, CommandsHandler> commandsMap = new HashMap<>();

    {
        commandsMap.put("help", new CommandHelp());
        commandsMap.put("note-new", new NewNote());
        commandsMap.put("note-list", new NoteList());
        commandsMap.put("note-remove", new RemoveNote());
        commandsMap.put("note-export", new NoteExport());
        commandsMap.put("exit", new CommandExit());
    }

    public void control() {
        log.fine("вызов метода контроллера");
        while (true) {
            System.out.println("Это Ваша записная книжка. Вот список доступных команд:");
            Arrays.stream(Commands.values()).forEach(System.out::println);
            System.out.println("Введите команду:(через дефис, где необходимо)");
            String inputCommand = new Scanner(System.in).nextLine();
            try {
                CommandsHandler command = commandsMap.get(inputCommand);
                if (command == null) {
                    log.warning("введена неверная команда");
                    throw new NoteException("Введена неверная команда");
                }
                command.handler();
            } catch (NoteException e) {
                e.getMessage();
            }
        }
    }
}
