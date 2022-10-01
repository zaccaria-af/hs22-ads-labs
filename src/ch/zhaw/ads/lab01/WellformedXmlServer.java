package ch.zhaw.ads.lab01;

import ch.zhaw.ads.CommandExecutor;

public class WellformedXmlServer implements CommandExecutor {

    public boolean checkWellformed (String command) {
        ListStack bracketStack = new ListStack();
        do {
            String nextToken = getNextToken(command);
            command = command.replace(nextToken, "");
            if (nextToken.contains(" ")) {
                nextToken = nextToken.replace(nextToken.substring(nextToken.indexOf(" "), nextToken.length() - 1), "");
            }
            if (nextToken.charAt(1) != '/' && nextToken.charAt(nextToken.length() - 2) != '/') {
                bracketStack.push(nextToken);
            } else if (nextToken.charAt(1) == '/') {
                String tokenToPop = "";
                if (!bracketStack.isEmpty()) {
                    tokenToPop = (String) bracketStack.peek();
                }
                nextToken = nextToken.replace("/", "");
                if (bracketStack.isEmpty() || !(tokenToPop.equals(nextToken))) {
                    return false;
                }
                bracketStack.pop();
            }
        } while (!getNextToken(command).equals(""));
        return bracketStack.isEmpty();
    }

    private String getNextToken(String command) {
        if (command.contains("<") && command.contains(">")) {
            return command.substring(command.indexOf("<"), command.indexOf(">") + 1);
        }
        return "";
    }

    @Override
    public String execute(String command) throws Exception {
        if (checkWellformed(command)) return "Well-formed. \n";
        return "Not well-formed. \n";
    }
}
