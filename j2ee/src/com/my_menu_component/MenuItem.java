package com.my_menu_component;

/**
 * 叶子节点
 */
public class MenuItem extends MenuComponent {
    private String name;
    private String description;

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName(MenuComponent menuComponent) {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("|-" + description);
    }
}
