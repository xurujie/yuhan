package com.yuhan.service;

import java.util.List;

import com.yuhan.entities.Banner;

public interface BannerService {
    public List<Banner> list();
    public Banner findById(int id);
}
