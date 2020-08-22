package com.gdw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 规约项管理器
 *
 * @author spike
 */
public class ProtocolItemManage {

    private ProtocolItemManage() {

    }

    private static Map<Integer, Map<Integer, ProtocolItem>> items = new HashMap();

    {
        items.put(Afn.YESNO, new HashMap<Integer, ProtocolItem>());
        items.get(Afn.YESNO).put(1, new com.gdw.afn00.F1());
    }

    public static ProtocolItem getItem(int afn, int fn) {
        return items.get(afn).get(fn);
    }
}
