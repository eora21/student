package com.nhnacademy.student.init;

import com.nhnacademy.student.controller.Command;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class ControllerFactory {
    private final Map<String, Command> beanMap = new HashMap<>();

    public void init(Set<Class<?>> classes) {
        for (Class<?> clazz : classes) {
            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation annotation : annotations) {

                if (!isController(annotation)) {
                    continue;
                }

                RequestMapping controller = (RequestMapping) annotation;
                String method = controller.method().toString();
                String url = controller.url();
                String key = method + url;
                try {
                    beanMap.put(key, (Command) clazz.getDeclaredConstructor().newInstance());
                    log.info("{}: {}", key, clazz);
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    private boolean isController(Annotation annotation) {
        return annotation.annotationType().equals(RequestMapping.class);
    }

    public Command getBean(String method, String path) {
        Command command = beanMap.get(method + path);
        log.info(method + path);
        log.info("command: {}", command);
        return command;
    }
}
