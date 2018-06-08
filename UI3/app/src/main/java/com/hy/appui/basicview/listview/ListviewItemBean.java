package com.hy.appui.basicview.listview;

/**
 Listview对应数据类，根据item_list.xml定义
 */
public class ListviewItemBean {
    private String name;
    private int imgId;
    private int btId;

    public ListviewItemBean() {
    }

    public ListviewItemBean(String name, int id) {
        this.name = name;
        this.imgId = id;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setName(String mname) {
        name = mname;
    }

    public void setImgId(int mimgId) {
        imgId = mimgId;
    }

    public int getBtId() {
        return btId;
    }

    public void setBtId(int mbtId) {
        btId = mbtId;
    }


}
