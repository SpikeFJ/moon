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
    public boolean execute() {
        if (operaction == Operaction.And) {
            for (Condition condition : conditionList) {
                if (condition.execute() == false) {
                    return false;
                }
            }

        } else if (operaction == Operaction.Or) {
            for (Condition condition : conditionList) {
                if (condition.execute() == true) {
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public void setMessage(Message message) {

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
