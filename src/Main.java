

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Main {
	private static final long ND = 1000 * 24 * 60 * 60;
	private static final long NH = 1000 * 60 * 60;
	private static final long NM = 1000 * 60;

	public static void main(String[] args) {
		System.out.println("开始处理表单，请稍等。。。");

		// 0.设定Excel文件�?在路�?
//		String excelFileName = args[0];
		String excelFileName = "刘国跃.xls";

		// 1.读取Excel文件内容
		List<ExcelDataVO> readResult = ExcelReader.readExcel(excelFileName);

		// 2.获取在园数据
		List<ResultDataVO> resultDataVOs = getRusultData(readResult);

		// 3.写入Excel文件内容
		ExcelWriter.exportData(resultDataVOs);

		System.out.println("表单文件处理完成!");
	}

	/**
	 * 获取在园时间Bean
	 * 
	 * @param readResult
	 *            excel解析列表
	 * @return
	 */
	private static List<ResultDataVO> getRusultData(List<ExcelDataVO> readResult) {
		List<ResultDataVO> resultDataVOs = new ArrayList<ResultDataVO>();
		Map<Integer, ResultDataVO> day2Results = new LinkedHashMap<Integer, ResultDataVO>();

		for (ExcelDataVO excelDataVO : readResult) {
			ResultDataVO temp = new ResultDataVO();
			Date time = excelDataVO.getTime();
			int day = DateUtils.getDay(time);
			if (!day2Results.containsKey(day)) {
				temp = new ResultDataVO();
				temp.setUserId(excelDataVO.getUserId());
				temp.setCardId(excelDataVO.getCardId());
				temp.setName(excelDataVO.getName());
				temp.setDepartment(excelDataVO.getDepartment());
				temp.setComment("");
				// 设置初始化时�?
				if (DateUtils.isAfternoon(time)) {
					temp.setAmOnTime(time);
				} else {
					temp.setPmOnTime(time);
				}
				day2Results.put(day, temp);
			} else {
				// 更新出入园时�?
				ResultDataVO resultDataVO = day2Results.get(day);
				if (DateUtils.isAfternoon(time)) {
					if (resultDataVO.getAmOnTime() == null) {
						resultDataVO.setAmOnTime(time);
					} else if(!resultDataVO.getAmOnTime().before(time)) {
						covertTime(true, resultDataVO, time);
					}
				} else {
					if (resultDataVO.getPmOnTime() == null) {
						resultDataVO.setPmOnTime(time);
					} else if (!resultDataVO.getPmOnTime().before(time)){
						covertTime(false, resultDataVO, time);
					}
				}
				day2Results.put(day, resultDataVO);
			}
		}

		for (Map.Entry<Integer, ResultDataVO> entry : day2Results.entrySet()) {
			resultDataVOs.add(entry.getValue());
		}

		// 计算在园时间
		for (ResultDataVO resultDataVO : resultDataVOs) {
			Date amOnTime = resultDataVO.getAmOnTime();
			Date amOffTime = resultDataVO.getAmOffTime();

			Date pmOnTime = resultDataVO.getPmOnTime();
			Date pmOffTime = resultDataVO.getPmOffTime();

			if (amOffTime == null) {
				resultDataVO.setComment("上午缺少出园时间，本次打卡不计入在园时间.");
			}

			if (pmOffTime == null) {
				resultDataVO.setComment(resultDataVO.getComment() + "下午缺少出园时间，本次打卡不计入在园时间.");
			}

			long dutyTime = 0L;
			if (amOnTime != null && amOffTime != null) {
				dutyTime += ((amOffTime.getTime() - amOnTime.getTime()) % ND % NH / NM);
			}
			
			if (pmOnTime != null && pmOffTime != null) {
				dutyTime += ((pmOffTime.getTime() - pmOnTime.getTime()) % ND % NH / NM);
			}
			resultDataVO.setOnDutyTime(Long.toString(dutyTime));
		}

		return resultDataVOs;
	}

	/**
	 * 转换出入园时�?
	 * 
	 * @param afternoon
	 *            是否为上午时�?
	 * @param resultDataVO
	 *            ResultBean
	 * @param time2Convert
	 *            �?要置换的出入园时�?
	 */
	private static void covertTime(boolean afternoon, ResultDataVO resultDataVO, Date time2Convert) {
		Date amOnTime = resultDataVO.getAmOnTime();
		Date pmOnTime = resultDataVO.getPmOffTime();

		if (afternoon) {
			resultDataVO.setAmOffTime(amOnTime);
			resultDataVO.setAmOnTime(time2Convert);
		} else {
			resultDataVO.setPmOffTime(pmOnTime);
			resultDataVO.setPmOnTime(time2Convert);
		}

	}

}
