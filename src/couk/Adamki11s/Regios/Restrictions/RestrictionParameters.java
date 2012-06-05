package couk.Adamki11s.Regios.Restrictions;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import couk.Adamki11s.Regios.Permissions.PermissionsCore;

public class RestrictionParameters {

	public static ArrayList<String> size, count;
	private int regionLimit, regionWidthLimit, regionHeightLimit, regionLengthLimit;


	public RestrictionParameters(int regionLimit, int regionWidthLimit, int regionHeightLimit, int regionLengthLimit) {
		this.regionLimit = regionLimit;
		this.regionWidthLimit = regionWidthLimit;
		this.regionHeightLimit = regionHeightLimit;
		this.regionLengthLimit = regionLengthLimit;
	}
	
	public int getRegionLimit() {
		return regionLimit;
	}

	public int getRegionWidthLimit() {
		return regionWidthLimit;
	}

	public int getRegionHeightLimit() {
		return regionHeightLimit;
	}

	public int getRegionLengthLimit() {
		return regionLengthLimit;
	}
	
	public static RestrictionParameters getRestrictions(Player p)
	{
		int c = 0, w = 0, h = 0, l = 0;
		
		for (String node : size)
		{
			if(PermissionsCore.doesHaveNode(p, node))
			{
				w = h = l = Integer.parseInt(node.substring(24));
			}
		}
		
		for (String node : count)
		{
			if(PermissionsCore.doesHaveNode(p, node))
			{
				c = Integer.parseInt(node.substring(20));
			}
		}
		
		
		if (PermissionsCore.doesHaveNode(p, "regios.restrictions.none")) {
			c = w = h = l = 999999999;
		}
		
		if (p.isOp()) {
			c = w = h = l = 999999999;
		}

		return new RestrictionParameters(c, w, h, l);
	}
}
