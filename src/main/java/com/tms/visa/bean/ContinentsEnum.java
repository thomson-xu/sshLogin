package com.tms.visa.bean;

/**
 * Created by Administrator on 2016/7/3.
 */
public enum ContinentsEnum {
    ASIA("亚洲", 1), EUROPE("欧洲", 2), NORTHAMERICA("北美洲", 3), SOUTHAMERICA("南美洲", 4), AFRICA("非洲", 5), OCEANIA("大洋洲", 6), ANTARCTICA("南极洲", 7);


    private String name;
    private int index;


    private ContinentsEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }


    public static String getName(int index) {
        for (ContinentsEnum c : ContinentsEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public static int getValue(String name) {
        for (ContinentsEnum c : ContinentsEnum.values()) {
            if (c.getName().equals(name)) {
                return c.index;
            }
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
