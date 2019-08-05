package com.god.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试java OOM 异常场景
 */
public class HeapOOM {
    int i;
    static class OOMObejct {

    }

    public static void main(String[] args) {
        List<OOMObejct> list = new ArrayList<OOMObejct>();
        while (true) {
            list.add(new OOMObejct());
        }
    }
}
