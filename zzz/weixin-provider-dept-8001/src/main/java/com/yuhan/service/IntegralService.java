package com.yuhan.service;

import com.yuhan.entities.Integral;

import java.util.List;

public interface IntegralService {

    public Integral findByMerchandiseId(int id);
    public List<Integral> findBy(int first, int end);
}
