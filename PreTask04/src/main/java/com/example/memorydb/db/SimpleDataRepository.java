package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<T>();
    private static long index = 0;
    public Comparator<T> sort = new Comparator<>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    // create, update
    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("data is null");
        }

        // whether data is in db
        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if (prevData.isPresent()) {
            // update
            dataList.remove(prevData.get());
            dataList.add(data);
        } else {
            // create
            data.setId(++index);
            dataList.add(data);
        }

        return null;
    }


    // read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it ->
                {return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .toList();
    }

    // delete
    @Override
    public void delete(ID id){
        var deleteEntity = findById(id);
        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }


}
