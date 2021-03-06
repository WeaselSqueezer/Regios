package net.jzx7.regios.bukkit.SpoutPlugin.GUI;

import net.jzx7.regios.RegiosPlugin;
import net.jzx7.regios.bukkit.SpoutPlugin.GUI.RegionScreenManager.RGB;
import net.jzx7.regiosapi.data.MODE;
import net.jzx7.regiosapi.regions.Region;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.InGameHUD;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.player.SpoutPlayer;


public class RegionScreen1 {

	public static void loadScreen(SpoutPlayer sp, Region r, Object[] oldWidgets, ScreenHolder sh) {
		InGameHUD hud = sp.getMainScreen();

		if (oldWidgets != null) {
			for (Object w : oldWidgets) {
				// if (w instanceof Widget) {
				((Widget) w).setVisible(false);
				((Widget) w).setDirty(true);
				// }
			}
		}

		for (Widget w : sh.page1Widgets) {
			w.setPriority(RenderPriority.Lowest);
		}

		int pinX = 18, pinY = 10;

		for (int index = 0; index < sh.page1Widgets.length; index++) {
			Widget b = sh.page1Widgets[index];
			pinY += 23;
			if (pinY > (hud.getHeight() - 35)) {
				pinY = 33;
				pinX += 130;
			}
			b.setX(pinX);
			b.setY(pinY);
			b.setWidth(125);
			b.setHeight(20);

			switch (index) {
			case 0:
				((GenericButton) b).setTextColor(getColourToken(r.is_protectionBreak()));
				((GenericButton) b).setTooltip(getStatus(r.is_protectionBreak()));
				((GenericButton) b).setDirty(true);
				break;
			case 1:
				((GenericButton) b).setTextColor(getColourToken(r.is_protectionPlace()));
				((GenericButton) b).setTooltip(getStatus(r.is_protectionPlace()));
				((GenericButton) b).setDirty(true);
				break;
			case 2:
				((GenericButton) b).setTextColor(getColourToken(r.isPreventEntry()));
				((GenericButton) b).setTooltip(getStatus(r.isPreventEntry()));
				((GenericButton) b).setDirty(true);
				break;
			case 3:
				((GenericButton) b).setTextColor(getColourToken(r.isPreventExit()));
				((GenericButton) b).setTooltip(getStatus(r.isPreventExit()));
				((GenericButton) b).setDirty(true);
				break;
			case 4:
				((GenericButton) b).setTextColor(getColourToken(r.isPreventInteraction()));
				((GenericButton) b).setTooltip(getStatus(r.isPreventInteraction()));
				((GenericButton) b).setDirty(true);
				break;
			case 5:
				((GenericButton) b).setTextColor(getColourToken(r.areDoorsLocked()));
				((GenericButton) b).setTooltip(getStatus(r.areDoorsLocked()));
				((GenericButton) b).setDirty(true);
				break;
			case 6:
				((GenericButton) b).setTextColor(getColourToken(r.areChestsLocked()));
				((GenericButton) b).setTooltip(getStatus(r.areChestsLocked()));
				((GenericButton) b).setDirty(true);
				break;
			case 7:
				((GenericButton) b).setTextColor(getColourToken(r.isFireProtection()));
				((GenericButton) b).setTooltip(getStatus(r.isFireProtection()));
				((GenericButton) b).setDirty(true);
				break;
			case 8:
				((GenericButton) b).setTextColor(getColourToken(r.isBlockForm()));
				((GenericButton) b).setTooltip(getStatus(r.isBlockForm()));
				((GenericButton) b).setDirty(true);
				break;
			case 9:
				((GenericButton) b).setTextColor(getColourToken(r.canMobsSpawn()));
				((GenericButton) b).setTooltip(getStatus(r.canMobsSpawn()));
				((GenericButton) b).setDirty(true);
				break;
			case 10:
				((GenericButton) b).setTextColor(getColourToken(r.canMonstersSpawn()));
				((GenericButton) b).setTooltip(getStatus(r.canMonstersSpawn()));
				((GenericButton) b).setDirty(true);
				break;
			case 11:
				((GenericButton) b).setTextColor(getColourToken(r.isShowWelcomeMessage()));
				((GenericButton) b).setTooltip(getStatus(r.isShowWelcomeMessage()));
				((GenericButton) b).setDirty(true);
				break;
			case 12:
				((GenericButton) b).setTextColor(getColourToken(r.isShowLeaveMessage()));
				((GenericButton) b).setTooltip(getStatus(r.isShowLeaveMessage()));
				((GenericButton) b).setDirty(true);
				break;
			case 13:
				((GenericButton) b).setTextColor(getColourToken(r.isShowPreventEntryMessage()));
				((GenericButton) b).setTooltip(getStatus(r.isShowPreventEntryMessage()));
				((GenericButton) b).setDirty(true);
				break;
			case 14:
				((GenericButton) b).setTextColor(getColourToken(r.isShowPreventExitMessage()));
				((GenericButton) b).setTooltip(getStatus(r.isShowPreventExitMessage()));
				((GenericButton) b).setDirty(true);
				break;
			case 15:
				((GenericButton) b).setTextColor(getColourToken(r.isShowProtectionMessage()));
				((GenericButton) b).setTooltip(getStatus(r.isShowProtectionMessage()));
				((GenericButton) b).setDirty(true);
				break;
			case 16:
				((GenericButton) b).setTextColor(getColourToken(r.isShowPvpWarning()));
				((GenericButton) b).setTooltip(getStatus(r.isShowPvpWarning()));
				((GenericButton) b).setDirty(true);
				break;
			case 17:
				((GenericButton) b).setTextColor(getColourToken(r.isPvp()));
				((GenericButton) b).setTooltip(getStatus(r.isPvp()));
				((GenericButton) b).setDirty(true);
				break;
			case 18:
				((GenericButton) b).setTextColor(getColourToken(r.isHealthEnabled()));
				((GenericButton) b).setTooltip(getStatus(r.isHealthEnabled()));
				((GenericButton) b).setDirty(true);
				break;
			case 19:
				((GenericButton) b).setTextColor(getColourToken(r.getProtectionMode()));
				((GenericButton) b).setTooltip(getStatus(r.getProtectionMode()));
				((GenericButton) b).setDirty(true);
				break;
			case 20:
				((GenericButton) b).setTextColor(getColourToken(r.getPreventEntryMode()));
				((GenericButton) b).setTooltip(getStatus(r.getPreventEntryMode()));
				((GenericButton) b).setDirty(true);
				break;
			case 21:
				((GenericButton) b).setTextColor(getColourToken(r.getPreventExitMode()));
				((GenericButton) b).setTooltip(getStatus(r.getPreventExitMode()));
				((GenericButton) b).setDirty(true);
				break;
			case 22:
				((GenericButton) b).setTextColor(getColourToken(r.getItemMode()));
				((GenericButton) b).setTooltip(getStatus(r.getItemMode()));
				((GenericButton) b).setDirty(true);
				break;
			case 23:
				((GenericButton) b).setTextColor(getColourToken(r.isForceCommand()));
				((GenericButton) b).setTooltip(getStatus(r.isForceCommand()));
				((GenericButton) b).setDirty(true);
				break;
			case 24:
				((GenericButton) b).setTextColor(getColourToken(r.isProtected()));
				((GenericButton) b).setTooltip(getStatus(r.isProtected()));
				((GenericButton) b).setDirty(true);
				break;
			}

			if (RegionScreenManager.popup.get(sp).containsWidget(b)) {
				RegionScreenManager.popup.get(sp).getWidget(b.getId()).setVisible(true);
				RegionScreenManager.popup.get(sp).getWidget(b.getId()).setDirty(true);
			} else {
				RegionScreenManager.popup.get(sp).attachWidget(RegiosPlugin.regios, b);
			}
		}
		
		((GenericButton) (sh.page1Widgets[24])).setX(43);
		((GenericButton) (sh.page1Widgets[24])).setY(218);
		((GenericButton) (sh.page1Widgets[24])).setHeight(20);
		((GenericButton) (sh.page1Widgets[24])).setWidth(100);
		((GenericButton) (sh.page1Widgets[24])).setTooltip(RegionScreenManager.getStatus(r.is_protectionPlace() || r.isProtected()));
		((GenericButton) (sh.page1Widgets[24])).setTextColor(RegionScreenManager.getColourToken(r.is_protectionPlace() || r.isProtected()));
		((GenericButton) (sh.page1Widgets[24])).setDirty(true);
		
		if (RegionScreenManager.popup.get(sp).containsWidget(sh.page1Widgets[24])) {
			RegionScreenManager.popup.get(sp).getWidget((sh.page1Widgets[24]).getId()).setVisible(true);
			RegionScreenManager.popup.get(sp).getWidget((sh.page1Widgets[24]).getId()).setDirty(true);
		} else {
			RegionScreenManager.popup.get(sp).attachWidget(RegiosPlugin.regios, sh.page1Widgets[24]);
		}
	}

	public static String getStatus(boolean b) {
		if (b) {
			return "  True";
		} else {
			return "  False";
		}
	}

	public static String getStatus(MODE m) {
		if (m == MODE.Whitelist) {
			return "  Whitelist";
		} else {
			return "  Blacklist";
		}
	}

	public static Color getColourToken(boolean b) {
		if (b) {
			return RGB.GREEN.getColour();
		} else {
			return RGB.FIREBRICK.getColour();
		}
	}

	public static Color getColourToken(MODE m) {
		if (m == MODE.Whitelist) {
			return RGB.WHITE.getColour();
		} else {
			return RGB.DARK_GREY.getColour();
		}
	}

}
