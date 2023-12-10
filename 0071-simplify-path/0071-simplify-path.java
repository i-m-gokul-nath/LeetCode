import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                stack.push(component);
            }
        }

        StringBuilder result = new StringBuilder("/");
        for (String dir : stack) {
            result.append(dir).append("/");
        }

        // Remove the trailing slash if present
        if (result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
