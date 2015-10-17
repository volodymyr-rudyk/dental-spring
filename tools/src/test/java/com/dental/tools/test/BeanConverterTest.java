package com.dental.tools.test;

import com.dental.tools.BeanConverter;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26.05.2015.
 */
//@RunWith(JUnit4.class)
public class BeanConverterTest {

  @Test
  public void testConvert1() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "TestName");
    map.put("age", "100500");
    map.put("ignore", "true");

    Bean convertedBean = BeanConverter.convert(map, Bean.class);
    Bean bean = new Bean();
    bean.setName("TestName");
    bean.setAge(100500);
    bean.setIgnore(true);
    Assert.assertEquals("Bean equals false", convertedBean, bean);
  }

  @Test
  public void testConvert2() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", null);
    map.put("age", "100500");

    Bean convertedBean = BeanConverter.convert(map, Bean.class);
    Bean bean = new Bean();
    bean.setAge(100500);
    Assert.assertEquals("Bean equals false", convertedBean, bean);
  }

  @Test
  public void testConvert3() {
    Map<String, String> map = new HashMap<String, String>();

    Bean convertedBean = BeanConverter.convert(map, Bean.class);
    Bean bean = new Bean();
    Assert.assertEquals("Bean equals false", convertedBean, bean);
  }

  @Test
  public void testConvertNull4() {
    Bean convertedBean = BeanConverter.convert(null, Bean.class);
    Assert.assertEquals("Bean equals false", convertedBean, null);
  }

  @Test
  public void testConvertParsing6() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("name", "4r43334tt");
    map.put("age", "qqqqq");

    Bean convertedBean = BeanConverter.convert(map, Bean.class);
    Bean bean = new Bean();
    bean.setName("4r43334tt");
    Assert.assertEquals("Bean parsing  equals false", convertedBean, bean);
  }

  @Test
  public void testName() throws Exception {
    Assert.assertTrue(true);
  }

  @Test
  public void testName1() throws Exception {
    String s = null;
    Assume.assumeTrue(s == null);
    Assert.assertNotNull("s = null", s);
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
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;

      Bean bean = (Bean) o;

      if (age != bean.age)
        return false;
      if (ignore != bean.ignore)
        return false;
      return !(name != null ? !name.equals(bean.name) : bean.name != null);

    }

    @Override
    public int hashCode() {
      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + age;
      result = 31 * result + (ignore ? 1 : 0);
      return result;
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
