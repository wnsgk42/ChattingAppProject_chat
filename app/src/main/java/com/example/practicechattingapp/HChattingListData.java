package com.example.practicechattingapp;

public class HChattingListData {
    private String hRoomName; //채팅방 이름 받는 변수
    private String hLastChat; //마지막 채팅 내용 받는 변수
    private String hRoomProfileImageBitmap;//채팅방 프로필 이미지의 비트맵을 받는 변수

    public String gethRoomName() {
        return hRoomName;
    }

    public void sethRoomName(String hRoomName) {
        this.hRoomName = hRoomName;
    }

    public String gethLastChat() {
        return hLastChat;
    }

    public void sethLastChat(String hLastChat) {
        this.hLastChat = hLastChat;
    }

    public String gethRoomProfileImageBitmap() {
        return hRoomProfileImageBitmap;
    }

    public void sethRoomProfileImageBitmap(String hRoomProfileImageBitmap) {
        this.hRoomProfileImageBitmap = hRoomProfileImageBitmap;
    }


}
