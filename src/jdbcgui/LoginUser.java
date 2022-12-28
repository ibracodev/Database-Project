/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

/**
 *
 * @author usama
 */
public class LoginUser {
    String username;
    String Name;
    int type;
    
    LoginUser(String  user,String uname, int utype){
        username = user;
        Name = uname;
        type = utype;
        
    }
    
}
