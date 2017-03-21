package com.cerradoSic.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListComparator {
  public static <T> boolean equalsIgnoreOrder(List<T> l, List<T> l2){
    final Set<T> s1 = new HashSet<>(l);
    final Set<T> s2 = new HashSet<>(l2);

    return s1.equals(s2);
  }
}
