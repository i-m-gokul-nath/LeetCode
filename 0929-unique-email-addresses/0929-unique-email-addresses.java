class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean ignore = false;
            boolean domainPart = false;

            for (char c : email.toCharArray()) {
                if (c == '@') {
                    ignore = false;
                    domainPart = true;
                }

                if (!domainPart) {
                    if (c == '+') {
                        ignore = true;
                    } else if (c != '.' && !ignore) {
                        sb.append(c);
                    }
                } else {
                    sb.append(c);
                }
            }

            uniqueEmails.add(sb.toString());
        }

        return uniqueEmails.size();
    }
}
