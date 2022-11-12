package praktikum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemRecursia2 {

    public static final String STOP = "стоп!"; // остановить выполнение
    public static final String LEFT = "левее!"; // перешагнуть команду слева
    public static final String WALK = "шагай!"; // начать выполнение следующей команды
    public static final String RIGHT = "правее!"; // перешагнуть команду справа
    public static final String TURN = "обратно!"; // вернуться к предыдущей команде
    public static final String DIGG = "копай!"; // копать и перейти на следующую команду

    public static int digCount = 0;

    public static final List<String> MASTER_CHIEF_COMMANDS = Arrays.asList(
            WALK, WALK, WALK,
            DIGG, // новый тип команды для рекурсивного робота "Работяга 2.1"
            DIGG, WALK, DIGG, WALK, DIGG, WALK, DIGG, STOP);

    // проинициализируйте "список списков" символов
    public static final List<List<Character>> LETTER_LIST_LIST = List.of(
            Arrays.asList('ы', 'т', 'о', 'б', 'а', 'Р'),
            Arrays.asList('й', 'ы', 'т', 'а', 'ч', 'о', 'п', 'е', 'н'),
            Arrays.asList('.', 'й', 'а', 'р', 'к'),
            Arrays.asList('а', 'д', 'е', 'б', 'о', ' ', 'о', 'Д'),
            Arrays.asList('.', 'о', 'к', 'е', 'л', 'а', 'д')
    );

    public static void main(String[] args){
        try {
            doMyCommand(0);
            System.out.println("Всё исполнено в лучшем виде!");
        } catch (StackOverflowError err){
            System.out.println("Робот зациклился, задание провалено!");
        }
    }

    private static void doMyCommand(int cmdIdx) {
        doMyCommandNow(-1, cmdIdx);
    }

    private static void doMyCommandNow(int prevCmdIdx, int cmdIdx) {
        String nextCommand = MASTER_CHIEF_COMMANDS.get(cmdIdx);
        System.out.println("Выполняю команду: " + nextCommand);
        switch (nextCommand) {
            case STOP:
                return;
            case WALK:
                doMyCommandNow(cmdIdx, cmdIdx + 1); // здесь сдвиг на один шаг
                break;
            case LEFT:
                doMyCommandNow(cmdIdx, cmdIdx - 2);
                break;
            case RIGHT:
                doMyCommandNow(cmdIdx, cmdIdx + 1 - 1);
                break;
            case DIGG:
                doDiggLetter(new StringBuilder(), LETTER_LIST_LIST.get(digCount), digCount);
                digCount++;
                doMyCommandNow(cmdIdx, cmdIdx + 1);
                break;
            case TURN:
                doMyCommandNow(cmdIdx, prevCmdIdx);
                break;
            default:
                throw new RuntimeException("Нет такой команды!");
        }
    }

    private static void doDiggLetter(StringBuilder word, List<Character> characters, int index) {
        // раскопайте слово в буфер
        for (int i = characters.size()-1; i>0; i--) word.append(characters.get(i));
        System.out.println(word);
    }
}
