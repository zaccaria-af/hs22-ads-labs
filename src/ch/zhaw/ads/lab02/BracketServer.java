package ch.zhaw.ads.lab02;

import ch.zhaw.ads.CommandExecutor;
import ch.zhaw.ads.lab01.ListStack;

public class BracketServer implements CommandExecutor {

    public boolean checkBrackets(String command) {
        ListStack bracketStack = new ListStack();
        for (int i = 0; i < command.length(); i++) {
            char x = command.charAt(i);

            if (x == '(' || x == '[' || x == '{' || x == '<') {
                bracketStack.push(x);
            } else if (x == '/' && command.length() > i + 1 && command.charAt(i+1) == '*') {
                bracketStack.push(x);
                i++;
            }
            try {
                char poppedChar;
                switch (x) {
                    case ')':
                        poppedChar = (char) bracketStack.pop();
                        if (poppedChar != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        poppedChar = (char) bracketStack.pop();
                        if (poppedChar != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        poppedChar = (char) bracketStack.pop();
                        if (poppedChar != '{') {
                            return false;
                        }
                        break;
                    case '>':
                        poppedChar = (char) bracketStack.pop();
                        if (poppedChar != '<') {
                            return false;
                        }
                    case '*':
                        if (command.length() > i+1 && command.charAt(i+1) == '/') {
                            poppedChar = (char) bracketStack.pop();
                            if (poppedChar != '/') {
                                return false;
                            }
                        }
                    default:
                        break;
                }
            } catch (NullPointerException nullPointerException) {
                return false;
            }

        }

        return bracketStack.isEmpty();
    }

    @Override
    public String execute(String command) throws Exception {
        if (checkBrackets(command)) return "True";
        return "False";
    }
}
