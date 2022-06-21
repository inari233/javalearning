package com.exercise;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class exercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new news("asdfasdfasdfasdfasdfasdfsafdasdf"));
        list.add(new news("asdfasdfasdfasdfas"));
        for (int i = list.size(); i > 0; i--) {

            }
        }

    public String processTitle(String s) {
        if(s == null){
            return "";
        }

        if(s.length() > 15){
            return s.substring(0,15);
        }
        return s;


    }
}


class news{
    private String topic;
    private String contains;

    public news(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "news{" +
                "topic='" + topic + '\'' +
                '}';
    }
}
