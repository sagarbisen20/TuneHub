package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Songs;

public interface SongService 
{
public void addSong(Songs song);
public List <Songs> fetchAllSongs();
public boolean songExists(String name);
public void updateSong(Songs song);
}
