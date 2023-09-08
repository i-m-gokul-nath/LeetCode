class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String localName = parts[0];
            String domain = parts[1];

            // Remove '.' from the local name and ignore characters after '+'
            localName = localName.replaceAll("\\.", "");
            localName = localName.split("\\+")[0];

            String sanitizedEmail = localName + "@" + domain;
            uniqueEmails.add(sanitizedEmail);
        }

        return uniqueEmails.size();
    }
}
