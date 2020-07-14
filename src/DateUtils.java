/**
 * 
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

/**
 * @creat time 2020�?7�?12�? 上午10:09:21
 * @author hao zhang
 * @version 1.0
 * @comment
 */
public class DateUtils {

	private static Logger logger = Logger.getLogger(DateUtils.class.getName()); // 日志打印�?

	/**
	 * 获取时间是几�?
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getDay(Date date) {
		if (date == null) {
			return null;
		}

		DateFormat df = DateFormat.getDateInstance();
		df.format(date);
		Calendar calendar = df.getCalendar();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 *
	 * @param strDate
	 * @return
	 */
	public static Date parseDate(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			logger.warning("invalid date.");
		}

		return date;
	}

	public static boolean isAfternoon(Date date) {
		GregorianCalendar ca = new GregorianCalendar();

		if (ca.get(GregorianCalendar.AM_PM) == 0) {
			return true;
		}

		return false;
	}
}
