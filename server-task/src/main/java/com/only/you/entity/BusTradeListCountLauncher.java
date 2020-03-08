package com.only.you.entity;

/**
 * @author lc
 * @Title: CountLauncher
 * @ProjectName shengyapp
 * @Description: TODO
 * @date 2018/9/1819:51
 */
public class BusTradeListCountLauncher {
    private int count;

    public BusTradeListCountLauncher(int count){
        this.count = count;
    }

    public synchronized void countDown(){
        count --;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
