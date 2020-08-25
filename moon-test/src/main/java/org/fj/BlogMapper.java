package org.fj;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {

    @Select("Select * from t1 where id=#{id}")
    Blog selectBolg(int id);
}
