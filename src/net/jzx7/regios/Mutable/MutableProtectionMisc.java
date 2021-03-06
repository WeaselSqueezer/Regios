package net.jzx7.regios.Mutable;

import java.io.IOException;

import net.jzx7.regios.regions.RegionManager;
import net.jzx7.regios.util.EncryptUtil;
import net.jzx7.regiosapi.regions.Region;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MutableProtectionMisc {
	
	private final static EncryptUtil encUtil = new EncryptUtil();
	private final static RegionManager rm = new RegionManager();
	
	public void editInteraction(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.PreventInteraction", val);
		r.setPreventInteraction(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editChestsLocked(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.ChestsLocked", val);
		r.setChestsLocked(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editDispensersLocked(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.DispensersLocked", val);
		r.setDispensersLocked(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editBlockForm(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.Block.BlockForm.Enabled", val);
		r.setBlockForm(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editEndermanBlock(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.EndermanBlock", val);
		r.setBlockEndermanMod(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editPlayerCap(Region r, int val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.PlayerCap.Cap", val);
		r.setPlayerCap(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void editDoorsLocked(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.DoorsLocked", val);
		r.setDoorsLocked(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editSetPassword(Region r, String val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		val = encUtil.computeSHA2_384BitHash(val);
		c.set("Region.General.Password.Password", val);
		r.setPassword(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editPasswordEnabled(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.Password.Enabled", val);
		r.setPasswordEnabled(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editFireProtection(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.FireProtection", val);
		r.setFireProtection(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editFireSpread(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.FireSpread", val);
		r.setFireSpread(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editTNTEnabled(Region r, boolean val){
		FileConfiguration c = YamlConfiguration.loadConfiguration(rm.getConfigFile(r));
		c.set("Region.General.TNT", val);
		r.setExplosionsEnabled(val);
		try {
			c.save(rm.getConfigFile(r));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
