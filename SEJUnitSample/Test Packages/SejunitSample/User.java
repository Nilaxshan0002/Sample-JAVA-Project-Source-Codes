/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sejunitsample;

/**
 *
 * @author Snila
 */
public class User {
    
    private int id;
    private String username;
    private String role;
    
    public User(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
    
    // Getters and setters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    
    public static void main(String[] args) {
    String[] users = {
        "admin:admin123:admin",
        "cashier:password123:cashier",
        "manager:secure456:manager"
    };
    
    for (String user : users) {
        String[] parts = user.split(":");
        String hashed = SecurityUtil.hashPassword(parts[1]);
        System.out.printf("INSERT INTO users (username, password, role) VALUES ('%s', '%s', '%s');%n",
            parts[0], hashed, parts[2]);
    }
}
    
}
