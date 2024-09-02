public class UserModel {
    
    private String email;
    private String password;
    private UserModel currentUser;
   

    public UserModel() {
       
    }
    
    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
        
    }
    
    public UserModel(String email, String password, double balance) {
        this.email = email;
        this.password = password;
        
    }

    public UserModel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserModel currentUser) {
        this.currentUser = currentUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    
}
