package net.jzx7.regios.bukkit.SpoutPlugin.Commands;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.jzx7.regios.Mutable.MutableSpout;
import net.jzx7.regios.Permissions.PermissionsCore;
import net.jzx7.regios.util.RegiosConversions;
import net.jzx7.regiosapi.entity.RegiosPlayer;
import net.jzx7.regiosapi.regions.Region;

import org.bukkit.ChatColor;

public class SpoutCommands extends PermissionsCore {
	
	private final MutableSpout mutable = new MutableSpout();
	
	public void setWelcome(Region r, String region, String[] message, RegiosPlayer p){
		String builder = "";
		for(int index = 2; index < message.length; index++){
			builder += message[index] + " ";
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Spout Welcome message updated for region " + ChatColor.BLUE + region);
		}
		mutable.editWelcomeMessage(r, builder);
	}
	
	public void setLeave(Region r, String region, String[] message, RegiosPlayer p){
		String builder = "";
		for(int index = 2; index < message.length; index++){
			builder += message[index] + " ";
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Spout Leave message updated for region " + ChatColor.BLUE + region);
		}
		mutable.editLeaveMessage(r, builder);
	}
	
	public void setWelcomeMaterial(Region r, String region, String input, RegiosPlayer p){
		int val;
		try{
			val = Integer.parseInt(input);
		} catch (Exception bfe){
			p.sendMessage(ChatColor.RED + "[Regios] The value for the 2nd paramteter must be an integer!");
			return;
		}
		if( !(val >= 0 && val <= 96) && !(val >= 256 && val <= 359) && val != 2256 && val != 2257){
			p.sendMessage(ChatColor.RED + "[Regios] Invalid Item ID of " + ChatColor.RED + val + ChatColor.RED +"!");
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Welcome Material for region " + ChatColor.BLUE + region + ChatColor.GREEN + " set to " + ChatColor.BLUE + RegiosConversions.getMaterialName(val));
			mutable.editWelcomeMaterial(r, val);
		}
	}
	
	public void setLeaveMaterial(Region r, String region, String input, RegiosPlayer p){
		int val;
		try{
			val = Integer.parseInt(input);
		} catch (Exception bfe){
			p.sendMessage(ChatColor.RED + "[Regios] The value for the 2nd paramteter must be an integer!");
			return;
		}
		if( !(val >= 0 && val <= 96) && !(val >= 256 && val <= 359) && val != 2256 && val != 2257){
			p.sendMessage(ChatColor.RED + "[Regios] Invalid Item ID of " + ChatColor.RED + val + ChatColor.RED +"!");
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Leave Material for region " + ChatColor.BLUE + region + ChatColor.GREEN + " set to " + ChatColor.BLUE + RegiosConversions.getMaterialName(val));
			mutable.editLeaveMaterial(r, val);
		}
	}
	
	public void setTexturePackURL(Region r, String region, String message, RegiosPlayer p){
		try {
			URL u = new URL(message);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			huc.setRequestMethod("HEAD");
			huc.connect();
			if (huc.getResponseCode() != HttpURLConnection.HTTP_OK) {
				p.sendMessage(ChatColor.RED + "[Regios] URL does not exist!");
				return;
			}
		} catch(MalformedURLException murlex){
			p.sendMessage(ChatColor.RED + "[Regios] Invalid URL Format!");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Spout Texture Pack updated for region " + ChatColor.BLUE + region);
		}
		mutable.editTexturePackURL(r, message);
	}
	
	public void setUseTextures(Region r, String region, String input, RegiosPlayer p){
		boolean val;
		try{
			val = Boolean.parseBoolean(input);
		} catch (Exception bfe){
			p.sendMessage(ChatColor.RED + "[Regios] The value for the 2nd paramteter must be boolean!");
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			if(val){
				p.sendMessage(ChatColor.GREEN + "[Regios] Texture Packs enabled for region " + ChatColor.BLUE + region);
			} else {
				p.sendMessage(ChatColor.GREEN + "[Regios] Texture Packs disabled for region " + ChatColor.BLUE + region);
			}
		}
		mutable.editUseTexturePack(r, val);
	}
	
	public void setUseMusic(Region r, String region, String input, RegiosPlayer p){
		boolean val;
		try{
			val = Boolean.parseBoolean(input);
		} catch (Exception bfe){
			p.sendMessage(ChatColor.RED + "[Regios] The value for the 2nd paramteter must be boolean!");
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			if(val){
				p.sendMessage(ChatColor.GREEN + "[Regios] Music enabled for region " + ChatColor.BLUE + region);
			} else {
				p.sendMessage(ChatColor.GREEN + "[Regios] Music disabled for region " + ChatColor.BLUE + region);
			}
		}
		mutable.editUseMusic(r, val);
	}
	
	public void setAddMusic(Region r, String region, String message, RegiosPlayer p){
		try {
			URL u = new URL(message);
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			HttpURLConnection.setFollowRedirects(false);
			huc.setRequestMethod("HEAD");
			huc.connect();
			if (huc.getResponseCode() != HttpURLConnection.HTTP_OK) {
				p.sendMessage(ChatColor.RED + "[Regios] URL does not exist!");
				return;
			}
		} catch(MalformedURLException murlex){
			p.sendMessage(ChatColor.RED + "[Regios] Invalid URL Format!");
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			boolean match = false;
			for (String s : r.getCustomSoundUrl()) {
				if (s.trim().equalsIgnoreCase(message.trim())) {
					match = true;
				}
			}
			if(match){
				p.sendMessage(ChatColor.RED + "[Regios] The URL " + ChatColor.BLUE + message + ChatColor.RED + " already exists!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Spout Music URL added to region " + ChatColor.BLUE + region);
		}
		mutable.editAddToMusicList(r, message);
	}
	
	public void setRemoveMusic(Region r, String region, String message, RegiosPlayer p){
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			boolean match = false;
			for (String s : r.getCustomSoundUrl()) {
				if (s.trim().equalsIgnoreCase(message.trim())) {
					match = true;
				}
			}
			if(!match){
				p.sendMessage(ChatColor.RED + "[Regios] The URL " + ChatColor.BLUE + message + ChatColor.RED + " does not exist!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Spout Music URL removed from region " + ChatColor.BLUE + region);
		}
		mutable.editRemoveFromMusicList(r, message);
	}
	
	public void setResetMusic(Region r, String region, String message, RegiosPlayer p){
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			p.sendMessage(ChatColor.GREEN + "[Regios] Spout Music URL'S reset for region " + ChatColor.BLUE + region);
		}
		mutable.editResetMusicList(r);
	}
	
	public void setUseWelcome(Region r, String region, String input, RegiosPlayer p){
		boolean val;
		try{
			val = Boolean.parseBoolean(input);
		} catch (Exception bfe){
			p.sendMessage(ChatColor.RED + "[Regios] The value for the 2nd paramteter must be boolean!");
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			if(val){
				p.sendMessage(ChatColor.GREEN + "[Regios] Welcome Popup enabled for region " + ChatColor.BLUE + region);
			} else {
				p.sendMessage(ChatColor.GREEN + "[Regios] Welcome Popup disabled for region " + ChatColor.BLUE + region);
			}
		}
		mutable.editWelcomeEnabled(r, val);
	}
	
	public void setUseLeave(Region r, String region, String input, RegiosPlayer p){
		boolean val;
		try{
			val = Boolean.parseBoolean(input);
		} catch (Exception bfe){
			p.sendMessage(ChatColor.RED + "[Regios] The value for the 2nd paramteter must be boolean!");
			return;
		}
		if(r == null){ p.sendMessage(ChatColor.RED + "[Regios] The region " + ChatColor.BLUE + region + ChatColor.RED + " doesn't exist!"); return; } else {
			if(!r.canModify(p)){
				p.sendMessage(ChatColor.RED + "[Regios] You are not permitted to modify this region!");
				return;
			}
			if(val){
				p.sendMessage(ChatColor.GREEN + "[Regios] Leave Popup enabled for region " + ChatColor.BLUE + region);
			} else {
				p.sendMessage(ChatColor.GREEN + "[Regios] Leave Popup disabled for region " + ChatColor.BLUE + region);
			}
		}
		mutable.editLeaveEnabled(r, val);
	}

}
