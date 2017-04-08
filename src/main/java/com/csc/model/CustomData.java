package com.csc.model;

import java.util.Map;
import java.util.Set;

public class CustomData {
  private Map<String, String> map;

  public CustomData(Map<String, String> map) {
    this.map = map;
  }

  public Map<String, String> getMap() {
    return map;
  }

  public Set<String> getKeys() {
    return map.keySet();
  }

  public String getValueByKey(String key) {
    return map.get(key);
  }
}
