class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            int atIndex = email.indexOf('@');
            String localName = email.substring(0, atIndex);
            String domainName = email.substring(atIndex);

            // Remove '+' and '.' from local name
            localName = localName.replace(".", "");
            int plusIndex = localName.indexOf('+');
            if (plusIndex != -1) {
                localName = localName.substring(0, plusIndex);
            }

            uniqueEmails.add(localName + domainName);
        }

        return uniqueEmails.size();
    }
}
