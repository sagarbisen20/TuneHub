package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Playlists;

public interface PlaylistService 
{
	public void addPlaylist(Playlists playlist);
	public List<Playlists> fetchAllPlaylists();
}
