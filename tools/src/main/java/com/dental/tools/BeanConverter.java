package com.dental.tools;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26.05.2015.
 */
public class BeanConverter {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("name", "TestName");
    map.put("age", "100500");
    map.put("ignore", "true");

    Bean bean = BeanConverter.convert(map, Bean.class);
    System.out.println(bean.toString());

  }

  public static <T> T convert(Map<String, String> map, Class<T> clazz) {
    try {
      T instance = clazz.newInstance();
      for (Map.Entry<String, String> entry : map.entrySet()) {
        for (PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(clazz).getPropertyDescriptors()) {
          if (propertyDescriptor.getName().equals(entry.getKey())) {
            Method writeMethod = propertyDescriptor.getWriteMethod();
            Class<?>[] parameterTypes = writeMethod.getParameterTypes();
            Class<?> parameterType = parameterTypes[0];
            final String value = entry.getValue();
            if (String.class == parameterType) {
              writeMethod.invoke(instance, value);
            } else if (Integer.class == parameterType || int.class == parameterType) {
              try {
                Integer param = Integer.valueOf(value);
                writeMethod.invoke(instance, param);
              } catch (NumberFormatException nex) {
                continue;
              }
            } else if (Boolean.class == parameterType || boolean.class == parameterType) {
              Boolean param = Boolean.valueOf(value);
              writeMethod.invoke(instance, param);
            } else if (Long.class == parameterType || long.class == parameterType) {
              try {
                Long param = Long.valueOf(value);
                writeMethod.invoke(instance, param);
              } catch (NumberFormatException nex) {
                continue;
              }
            }
          }
        }
      }
      return instance;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
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

    public boolean isIgnore() {
      return ignore;
    }

    public void setIgnore(boolean ignore) {
      this.ignore = ignore;
    }

    @Override
    public String toString() {
      return "Bean{" +
          "name='" + name + '\'' +
          ", age=" + age +
          ", ignore=" + ignore +
          '}';
    }
  }

}
