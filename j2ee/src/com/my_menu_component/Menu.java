package com.my_menu_component;

import java.util.ArrayList;
import java.util.List;

/**
 * 子节点
 */
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void del(MenuComponent menuComponent) {
        menuComponents.remove(menuComponents.indexOf(menuComponent));
    }

    @Override
    public void print() {
        System.out.println(getDescription());

//        System.out.println("--------------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
}
