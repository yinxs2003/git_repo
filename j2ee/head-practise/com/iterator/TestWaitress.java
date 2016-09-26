package com.iterator;

import java.util.ArrayList;
import java.util.List;

public class TestWaitress {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        pancakeHouseMenu.addItem("hdlsa", "dsads", false, 2222);
        DinerMenu dinerMenu = new DinerMenu();
        dinerMenu.addItem("hdl222sa", "dsad2222s", true, 21222);

        CafeMenu cafeMenu = new CafeMenu();
        cafeMenu.addItem("hlfeljfei", "djsalkdlsajd", true, 123);

        List<Menu> menuList = new ArrayList<Menu>();
        menuList.add(0, pancakeHouseMenu);
        menuList.add(1, dinerMenu);
        menuList.add(2, cafeMenu);

        Waitress w = new Waitress(menuList);
        w.printMenu();
    }
}
