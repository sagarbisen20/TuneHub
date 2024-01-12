package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlists;
import com.example.demo.entity.Songs;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

@Controller
public class PlaylistController 
{
	@Autowired
	SongService songservice;

	@Autowired
	PlaylistService playlistservice;

	@GetMapping("createPlaylist")
	public String createPlaylist(Model model)
	{
		List<Songs>	songList= songservice.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createPlaylist";
	}
	@PostMapping("addPlaylist")
	public String addPlaylist(@ModelAttribute Playlists playlist)
	{
		playlistservice.addPlaylist(playlist);
		System.out.println(playlist);
		List<Songs> songList = playlist.getSongs();
		for(Songs s: songList)
		{
			s.getPlaylists().add(playlist);
			songservice.updateSong(s);
		}
		return "adminHome";
	}
	@GetMapping("viewPlaylist")
	public String viewPlaylist(Model model)
	{
		List<Playlists>	allPlayLists= playlistservice.fetchAllPlaylists();
		model.addAttribute("allPlayList",allPlayLists);
		return "displayPlaylist";
	}
	

}
