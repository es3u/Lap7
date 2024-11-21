package com.example.lap7.Service;

import com.example.lap7.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public boolean updateUser(String id  , User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
            }else
                return false;
        }
        return true;
    }



    public boolean deleteUser(String id) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)) {
                users.remove(i);
            }else
                return false;
        }
        return true;
    }

    public boolean Register_courses(String id ) {

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)) {
                if (users.get(i).isRegistered()==false) {
                    users.get(i).setRegistered(true);
                }
            }else
                return false;
        }
        return true;

    }
    public ArrayList<String> getNameRegister(){
        ArrayList<String> nameRegister = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).isRegistered()==true) {
                nameRegister.add(users.get(i).getName());
            }
        }
        return nameRegister;
    }

    //  //هذه الميثود تشيك ان الي مسجلين في كورس١ اعمارهم اكبر من ١٨والي اصغر من العمر المطلوب يحذفه من الكورس
    public Boolean checkCourse1(){
        for(User user : users) {
            if(user.isRegistered()==true) {
                if (user.getCourse().equals("course1") && user.getAge()<18 ){
                    users.remove(user);


            }
        }
        }
        return true;
    }







}
