package com.hspedu.ch10.AnonymousInner;
public class Exercise2 {
    public static void main(String[] args) {
        CallPhone callPhone = new CallPhone();
        callPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床了");
            }
        });
        callPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了");
            }
        });
    }
}
interface Bell {
    void ring();
}
class CallPhone {
    public void alarmclock(Bell bell) {
      bell.ring();
    }
}