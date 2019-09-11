package com.yuhan.service;

import java.util.List;

import com.yuhan.entities.Belongs;

public interface BelongsService {

    public List<Belongs> list();
    public Belongs findById(int id);
}
