package com.practise2.weather;

import com.practise2.myInterface.DisplayElement;
import com.practise2.myInterface.Observer;
import com.practise2.myInterface.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("Current condition:" + temperature + "F degrees and " + humidity + " % humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
