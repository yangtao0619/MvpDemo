package com.iflytek.auto.testeventbus;

/**
 * Created by yangtao on 2017/9/20.
 */

/**
 * 事件消息类
 */
public class EventMessage {
    private String msg;

    public EventMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
