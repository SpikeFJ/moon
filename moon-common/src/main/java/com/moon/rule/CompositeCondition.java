package com.moon.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合条件
 *
 * @author spike
 */
public class CompositeCondition implements Condition {

    private List<Condition> conditionList = new ArrayList<>();
    public Operaction operaction = Operaction.And;

    @Override
    public boolean evaluate(Message message) {
        if (operaction == Operaction.And) {
            for (Condition condition : conditionList) {
                if (condition.evaluate(message) == false) {
                    return false;
                }
            }

        } else if (operaction == Operaction.Or) {
            for (Condition condition : conditionList) {
                if (condition.evaluate(message) == true) {
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public String getTopic() {
        return null;
    }

    public void addCondition(Condition condition) {
        conditionList.add(condition);
    }

    public void removeCondition(Condition condition) {
        conditionList.remove(condition);
    }

    public void clear() {
        conditionList.clear();
    }
}
