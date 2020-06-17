package org.example.velocity;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.google.common.collect.ImmutableList;
import org.example.velocity.model.pojo.ClassPOJO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shui
 * @date 2020/6/17
 */
public class Main {

  public static void main(String[] args) {
    ImmutableList<ClassPOJO> list = ImmutableList.of(
        new ClassPOJO("userId", "String"),
        new ClassPOJO("username", "String")
    );

    TemplateConfig config = new TemplateConfig();
    config.setResourceMode(TemplateConfig.ResourceMode.CLASSPATH);
    TemplateEngine engine = TemplateUtil.createEngine(config);

    Template template = engine.getTemplate("template/UserEntity.java.vm");
    Map<String, Object> map = new HashMap<>();
    map.put("list", list);
    OutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream("Test.java");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    template.render(map, outputStream);
  }

}
