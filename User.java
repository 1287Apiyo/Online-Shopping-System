class User {
    String name;
    String contactInfo;
    String username;
    String password;

    public User(String name, String contactInfo, String username, String password) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public boolean authenticateUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
    }
}