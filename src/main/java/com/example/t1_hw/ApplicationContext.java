package com.example.t1_hw;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ApplicationContext {
    private Map<Class<?>, Object> instances = new HashMap<>();
    public ApplicationContext(){
        initializeContext();
    }
    public void initializeContext(){
        Reflections reflections = new Reflections("com.example.t1_hw.configs");
        reflections.getTypesAnnotatedWith(Configuration.class)
                .forEach(config -> Arrays.stream(config.getMethods())
                        .filter(method -> method.isAnnotationPresent(Instance.class))
                        .forEach(method -> {
                            try {
                                instances.put(method.getReturnType(),method.invoke(config.newInstance()));
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(e);
                            } catch (InstantiationException e) {
                                throw new RuntimeException(e);
                            }
                        }));
    }
    public <T> T getInstance(Class<T> type){
        return (T) instances.get(type);
    }
}
