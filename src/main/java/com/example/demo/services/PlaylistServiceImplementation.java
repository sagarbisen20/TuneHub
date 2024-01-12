package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlists;
import com.example.demo.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService
{
	@Autowired
	PlaylistRepository repo;
	@Override
	public void addPlaylist(Playlists playlist) 
	{
		repo.save(playlist);
	}
	@Override
	public List<Playlists> fetchAllPlaylists() 
	{

		return repo.findAll();
	}

}
