/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.validation.constraints.Size;

/**
 *
 * @author user129
 */

public class Message {
    
    int id;
    String date;    
    
    @Size(max=250, message="Сообщение превышает 250 символов!")
    String text;
    
    String username;
    boolean isretweet;
    String nickname;
    int replyid;
    
    int level; //для NestedTree
    int rightkey; //для NestedTree
    int leftkey; //для NestedTree

    public int getRightkey() {
        return rightkey;
    }

    public void setRightkey(int rightkey) {
        this.rightkey = rightkey;
    }

    public int getLeftkey() {
        return leftkey;
    }

    public void setLeftkey(int leftkey) {
        this.leftkey = leftkey;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }    

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }    

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;    
    }
    

    public boolean isIsretweet() {
        return isretweet;
    }

    public void setIsretweet(boolean isretweet) {
        this.isretweet = isretweet;
    }    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }      

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }   
    
}
