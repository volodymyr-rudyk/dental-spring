package com.dental.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26.05.2015.
 */
public class BeanConverter {

  public static void main(String[] args)
          throws InstantiationException, IllegalAccessException, InvocationTargetException {
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "TestName");
    map.put("age", "100500");
    map.put("ignore", "true");

    Bean bean = BeanConverter.convert(map, Bean.class);
    System.out.println(bean.toString());

  }

  public static <T> T convert(Map<String, String> map, Class<T> clazz)
          throws IllegalAccessException, InstantiationException, InvocationTargetException {
    T instance = clazz.newInstance();
    Method[] declaredMethods = clazz.getDeclaredMethods();
    for (Method method : declaredMethods) {
      for (Map.Entry<String, String> entry : map.entrySet()) {
        String setMethodName = "set" + entry.getKey();
        if (setMethodName.equalsIgnoreCase(method.getName())) {
          Class<?>[] parameterTypes = method.getParameterTypes();
          Class<?> parameterType = parameterTypes[0];

          if (String.class == parameterType) {
            String value = String.valueOf(entry.getValue());
            method.invoke(instance, value);
          } else if (Integer.class == parameterType || int.class == parameterType) {
            Integer value = Integer.valueOf(entry.getValue());
            method.invoke(instance, value);
          } else if (Boolean.class == parameterType || boolean.class == parameterType) {
            Boolean value = Boolean.valueOf(entry.getValue());
            method.invoke(instance, value);
          } else if (Long.class == parameterType || long.class == parameterType) {
            Long value = Long.valueOf(entry.getValue());
            method.invoke(instance, value);
          }
        }
      }
    }
    return instance;
  }

  public static class Bean {
    private String name;
    private int age;
    private boolean ignore;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override public String toString() {
      return "Bean{" +
              "name='" + name + '\'' +
              ", age=" + age +
              '}';
    }

    public boolean isIgnore() {
      return ignore;
    }

    public void setIgnore(boolean ignore) {
      this.ignore = ignore;
    }
  }

}
