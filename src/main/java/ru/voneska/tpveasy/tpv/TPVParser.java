package ru.voneska.tpveasy.tpv;

import com.ibm.websphere.pmi.stat.WSStats;
import com.ibm.ws.tpv.engine.parser.ParsingController;
import com.ibm.ws.tpv.engine.parser.StatsLogParser;

import java.io.File;

/**
 * @author <a href="mailto:belkevglaz@gmail.com">Aksenov Ivan</a>
 */
public class TPVParser {

	private StatsLogParser statsLogParser;

	public TPVParser(File file) {
		try {
			statsLogParser = ParsingController.parse(file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void parse() throws Exception {
		WSStats stats;
		int statsCounter = 1;


		while (!statsLogParser.isEOF()) {
			stats = statsLogParser.next();
			if (stats == null) break;

			System.out.println("o.statsType = " + stats.getStatsType() + " o.name = " + stats.getName() + " counter = " + statsCounter);
//			System.out.println("o.statsType = " + stats.getStatsType() + " o.name = " + stats.getName() + " counter = " + statsCounter);
//			System.out.println("o.time = " + new Date(stats.getTime()));
//			if (stats.getSubStats().length > 0) {
//				WSStats[] subStats = stats.getSubStats();
//				for (WSStats sub : subStats) {
//					System.out.println("\tsub.statsType = " + sub.getStatsType() + " sub.name = " + sub.getName());
//				}
//			}
			statsCounter++;

		}

		System.out.println("statsCounter = " + statsCounter);
		String nodeName = statsLogParser.getNodeName();
		System.out.println("nodeName = " + nodeName);

	}
}
