package com.my_menu_component;

public class MenuTest {
    public static void main(String[] args) {
        MenuComponent allMenu = new Menu("Menu", "主菜单");

        MenuComponent file = new Menu("File", "文件");
        MenuComponent edit = new Menu("Item", "编辑");

        MenuComponent newFile = new MenuItem("newFile", "新建...");
        MenuComponent open = new MenuItem("打开", "打开...");

        allMenu.add(file);
        allMenu.add(newFile);
        allMenu.add(open);

        allMenu.add(edit);
        allMenu.print();

    }
}
