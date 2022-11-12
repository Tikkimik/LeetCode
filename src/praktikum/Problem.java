package praktikum;

import java.util.Arrays;
import java.util.List;

/*
 *   «Работяга 2.0»
 */

public class Problem {

    public static final String STOP = "стоп!"; // остановить выполнение
    public static final String LEFT = "левее!"; // перешагнуть команду слева
    public static final String WALK = "шагай!"; // начать выполнение следующей команды
    public static final String RIGHT = "правее!"; // перешагнуть команду справа
    public static final String TURN = "обратно!"; // вернуться к предыдущей команде

    public static final List<String> MASTER_CHIEF_COMMANDS = Arrays.asList(TURN, STOP, WALK, LEFT, WALK, RIGHT, STOP, TURN);

    public static void main(String[] args){
        try {
            doMyCommand(3);
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
            case TURN:
                doMyCommandNow(cmdIdx, prevCmdIdx);
                break;
            default:
                throw new RuntimeException("Нет такой команды!");
        }
    }
}
