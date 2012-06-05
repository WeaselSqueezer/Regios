package couk.Adamki11s.Regios.Mutable;

import java.io.File;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import couk.Adamki11s.Regios.Regions.Region;

public class MutableExceptions {

	/*
	 * Players
	 */

	public void addPlayerException(Region r, String ex) {
		File playerDir = new File(r.getExceptionDirectory() + File.separator + "Players" + File.separator + ex + ".excep");
		try {
			playerDir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		r.addException(ex);
	}

	public void removePlayerException(Region r, String ex) {
		File playerDir = new File(r.getExceptionDirectory() + File.separator + "Players" + File.separator + ex + ".excep");
		playerDir.delete();
		r.removeException(ex);
	}

	public boolean checkPlayerException(Region r, String ex) {
		for (File f : new File(r.getExceptionDirectory() + File.separator + "Players").listFiles()) {
			if (f.getName().substring(0, f.getName().lastIndexOf(".")).equals(ex)) {
				return true;
			}
		}
		return false;
	}

	public String listPlayerExceptions(Region r) {
		StringBuilder sb = new StringBuilder();
		for (File f : new File(r.getExceptionDirectory() + File.separator + "Players").listFiles()) {
			sb.append(ChatColor.WHITE + f.getName().substring(0, f.getName().lastIndexOf("."))).append(ChatColor.BLUE + ", ");
		}
		return sb.toString();
	}

	public void eraseAllPlayerExceptions(Region r) {
		if (new File(r.getExceptionDirectory() + File.separator + "Players").listFiles().length > 0) {
			for (File f : new File(r.getExceptionDirectory() + File.separator + "Players").listFiles()) {
				f.delete();
			}
		}
		r.getExceptions().clear();
	}

	/*
	 * Nodes
	 */

	public void addNodeException(Region r, String ex) {
		File playerDir = new File(r.getExceptionDirectory() + File.separator + "Nodes" + File.separator + ex + ".excep");
		try {
			playerDir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		r.addExceptionNode(ex);
	}

	public void removeNodeException(Region r, String ex) {
		File playerDir = new File(r.getExceptionDirectory() + File.separator + "Nodes" + File.separator + ex + ".excep");
		playerDir.delete();
		r.removeExceptionNode(ex);
	}

	public boolean checkNodeException(Region r, String ex) {
		for (File f : new File(r.getExceptionDirectory() + File.separator + "Nodes").listFiles()) {
			if (f.getName().substring(0, f.getName().lastIndexOf(".")).equals(ex)) {
				return true;
			}
		}
		return false;
	}

	public String listNodeExceptions(Region r) {
		StringBuilder sb = new StringBuilder();
		for (File f : new File(r.getExceptionDirectory() + File.separator + "Nodes").listFiles()) {
			sb.append(ChatColor.WHITE + f.getName().substring(0, f.getName().lastIndexOf("."))).append(ChatColor.BLUE + ", ");
		}
		return sb.toString();
	}

	public void eraseAllNodeExceptions(Region r) {
		if (new File(r.getExceptionDirectory() + File.separator + "Nodes").listFiles().length > 0) {
			for (File f : new File(r.getExceptionDirectory() + File.separator + "Nodes").listFiles()) {
				f.delete();
			}
		}
		r.getNodes().clear();
	}

	/*
	 * Items
	 */

	public void addItemException(Region r, int ex) {
		File playerDir = new File(r.getExceptionDirectory().getParent() + File.separator + "Items" + File.separator + ex + ".excep");
		try {
			playerDir.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		r.addItemException(ex);
	}

	public void removeItemException(Region r, int ex) {
		File playerDir = new File(r.getExceptionDirectory().getParent() + File.separator + "Items" + File.separator + ex + ".excep");
		playerDir.delete();
		r.removeItemException(ex);
	}

	public boolean checkItemException(Region r, int ex) {
		for (File f : new File(r.getExceptionDirectory().getParent() + File.separator + "Items").listFiles()) {
			if (Integer.parseInt(f.getName().substring(0, f.getName().lastIndexOf("."))) == ex) {
				return true;
			}
		}
		return false;
	}

	public String listItemExceptions(Region r) {
		StringBuilder sb = new StringBuilder();
		for (File f : new File(r.getExceptionDirectory().getParent() + File.separator + "Items").listFiles()) {
			sb.append(ChatColor.WHITE + f.getName().substring(0, f.getName().lastIndexOf("."))).append(ChatColor.BLUE + ", ");
		}
		return sb.toString();
	}

	public void eraseAllItemExceptions(Region r) {
		if (new File(r.getExceptionDirectory().getParent() + File.separator + "Items").listFiles().length > 0) {
			for (File f : new File(r.getExceptionDirectory().getParent() + File.separator + "Items").listFiles()) {
				f.delete();
			}
		}
		r.getItems().clear();
	}

	/*
	 * Sub Owners
	 */

	public void addSubOwner(Region r, String message){
		FileConfiguration c = YamlConfiguration.loadConfiguration(r.getConfigFile());
		String current = (String)c.get("Region.Essentials.SubOwners");
		c.set("Region.Essentials.SubOwners", current.trim() + message.trim() + ",");
		r.setSubOwners((current.trim() + "," + message.trim()).split(","));
		try {
			c.save(r.getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeSubOwner(Region r, String message){
		FileConfiguration c = YamlConfiguration.loadConfiguration(r.getConfigFile());
		String current = (String)c.get("Region.Essentials.SubOwners");
		current = current.replaceAll(" ", "");
		current = current.replaceAll(message + ",", "");
		current = current.replaceAll(",,", ",");
		c.set("Region.Essentials.SubOwners", current.trim());
		r.setSubOwners((current.trim()).split(","));
		try {
			c.save(r.getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String listSubOwnersExceptions(Region r) {
		StringBuilder sb = new StringBuilder();
		for (String s : r.getSubOwners()) {
			sb.append(ChatColor.WHITE + s).append(ChatColor.BLUE + ", ");
		}
		return sb.toString();
	}

	public void eraseAllSubOwners(Region r){
		FileConfiguration c = YamlConfiguration.loadConfiguration(r.getConfigFile());
		c.set("Region.Essentials.SubOwners", "");
		r.setSubOwners(("").split(","));
		try {
			c.save(r.getConfigFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkSubOwnerException(Region r, String ex) {
		if (r.getSubOwners() != null) {
			for (String owner : r.getSubOwners()) {
				if(ex.trim().equals(owner.trim())){
					return true;
				}
			} 
		}
		return false;
	}

}
