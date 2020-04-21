package dao;

import pojo.Batch;

import java.util.List;

public interface BatchDao {
    void batchInsert(Batch batch);
    int batchForEach(List<Batch> list);
}
