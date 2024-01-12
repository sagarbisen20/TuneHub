package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Playlists;


public interface PlaylistRepository extends JpaRepository<Playlists, Integer>
{
	
}
