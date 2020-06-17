package org.example.velocity.model.pojo;

/**
 * @author Shui
 * @date 2020/6/17
 */
public class ClassPOJO {
  public ClassPOJO(String field, String type) {
    this.field = field;
    this.type = type;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  private String field;
  private String type;

}
