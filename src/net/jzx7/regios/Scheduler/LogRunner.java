package net.jzx7.regios.Scheduler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

import net.jzx7.regios.Data.ConfigurationData;
import net.jzx7.regios.regions.RegionManager;
import net.jzx7.regiosapi.regions.Region;


public class LogRunner {

	final static RegionManager rm = new RegionManager();
	
	public static HashMap<Region, ArrayList<String>> log = new HashMap<Region, ArrayList<String>>();

	public static int timer = 0;

	public static void pollLogMessages() {
		if (!ConfigurationData.logs) {
			return;
		}
		timer++;
		if (timer >= 600) {// 10 minutes between logs(600s)
			try {
				pushLogMessages();
			} catch (IOException e) {
				e.printStackTrace();
			}
			timer = 0;
		}
	}

	private synchronized static void pushLogMessages() throws IOException {
		if (ConfigurationData.logs) {
			System.out.println("[Regios] Writing region logs to log files...");
			for (Entry<Region, ArrayList<String>> entry : log.entrySet()) {
				File logFile = rm.getLogFile(entry.getKey());
				if (!logFile.exists()) {
					try {
						logFile.createNewFile();
					} catch (Exception ex) {
						System.out.println("Unable to create log file " + logFile.getAbsolutePath());
					}
				}
				fileWipeCheck(logFile);
				FileWriter fstream = new FileWriter(logFile, true);
				BufferedWriter fbw = new BufferedWriter(fstream);
				for (String msg : entry.getValue()) {
					try {
						fbw.write(msg);
						fbw.newLine();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				fbw.close();
			}
			log.clear();
			System.out.println("[Regios] Log files saved & closed.");
		}
	}

	private synchronized static void fileWipeCheck(File f) {
		long filesizeInKB = f.length() / 1024;
		if (filesizeInKB > 5000) { // 5 MB Cap on log files before
											// they are wiped.
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getPrefix(Region genericRegion) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "[" + sdf.format(cal.getTime()) + "]" + "[" + genericRegion.getName() + "]";
	}

	public static void addLogMessage(Region r, String message) {
		if (!ConfigurationData.logs) {
			return;
		}
		if (log.containsKey(r)) {
			ArrayList<String> tempLog = log.get(r);
			tempLog.add(message);
			log.put(r, tempLog);
		} else {
			ArrayList<String> tempLog = new ArrayList<String>();
			tempLog.add(message);
			log.put(r, tempLog);
		}

	}

}
