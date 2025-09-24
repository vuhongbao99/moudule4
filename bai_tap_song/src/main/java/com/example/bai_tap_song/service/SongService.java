package com.example.bai_tap_song.service;

import com.example.bai_tap_song.entity.Song;
import com.example.bai_tap_song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public boolean update(Song song) {
        if (findById(song.getId()) != null) {
            song.setId(song.getId());
            songRepository.save(song);
            return true;
        }
         return false;

    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        if (song.getId() == null || findById(song.getId()) == null) {
            songRepository.save(song);
        }
    }
}
