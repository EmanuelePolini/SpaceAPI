package utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TimeUtils {
	
	//calcolo degli anni trascorsi da una determinata data 
	public static long calculateYearsSinceLaunch(LocalDate startDate) {
		return ChronoUnit.YEARS.between(startDate, LocalDate.now());
	}
	
	//calcolo dei secondi trascorsi da una determinata data (per applicarlo alla formula della distanza in km)
	public static long calculateDaysSinceLaunch(LocalDate startDate) {
		return ChronoUnit.DAYS.between(startDate, LocalDate.now());
	}
}
