package com.example.realboard;

public enum BoardType {
    notice("mainBoard"),
    free("openBoard");

    BoardType(String value){
        this.value = value;
    }

    private String value;




    public String getValue(){
        return value;
    }

}