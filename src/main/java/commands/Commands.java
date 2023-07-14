package commands;

import lombok.AllArgsConstructor;


@AllArgsConstructor


public enum Commands {
    HELP ("Вывести на экран список доступных команд с их описанием"),
    NOTE_NEW ("Создать новую заметку"),
    NOTE_LIST ("Вывести все заметки на экран"),
    NOTE_REMOVE ("Удалить заметку"),
    NOTE_EXPORT ("Сохранить все заметки в текстовый файл и вывести имя сохраненного файла"),
    EXIT ("Выход из приложения");

    private final String commandName;

    public String getCommandName() {
        return commandName;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static void printAllCommands() {
        for (Commands c : Commands.values()) {
            System.out.println(c.toString() + " " + c.getCommandName());
        }
    }
}
