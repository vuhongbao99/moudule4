package com.example.bai_tap_song.service;

import com.example.bai_tap_song.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    boolean update(Song song);

    Song findById(Integer id);

    void save(Song song);
}
