/**
 * 
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * @creat time 2020�?7�?12�? 上午8:07:57
 * @author hao zhang
 * @version 1.0
 * @comment
 */
public class ExcelWriter {

	private static List<String> CELL_HEADS; // 列头

	static {
		// 类装载时就载入指定好的列头信息，如有�?要，可以考虑做成动�?�生成的列头
		CELL_HEADS = new ArrayList<String>();
		CELL_HEADS.add("姓名");
		CELL_HEADS.add("人员编号");
		CELL_HEADS.add("卡号");
		CELL_HEADS.add("部门");
		CELL_HEADS.add("上午入园时间");
		CELL_HEADS.add("上午离园时间");
		CELL_HEADS.add("下午入园时间");
		CELL_HEADS.add("下午离园时间");
		CELL_HEADS.add("全天在园时间");
	}

	/**
	 * 生成Excel并写入数据信�?
	 * 
	 * @param dataList
	 *            数据列表
	 * @return 写入数据后的工作簿对�?
	 */
	public static Workbook exportData(List<ResultDataVO> dataList) {
		// 生成xlsx的Excel
		Workbook workbook = new SXSSFWorkbook();

		// 如需生成xls的Excel，请使用下面的工作簿对象，注意后续输出时文件后缀名也�?更改为xls
		// Workbook workbook = new HSSFWorkbook();

		// 生成Sheet表，写入第一行的列头
		Sheet sheet = buildDataSheet(workbook);
		// 构建每行的数据内�?
		int rowNum = 1;
		for (Iterator<ResultDataVO> it = dataList.iterator(); it.hasNext();) {
			ResultDataVO data = it.next();
			if (data == null) {
				continue;
			}
			// 输出行数�?
			Row row = sheet.createRow(rowNum++);
			convertDataToRow(data, row);
		}
		return workbook;
	}

	/**
	 * 生成sheet表，并写入第�?行数据（列头�?
	 * 
	 * @param workbook
	 *            工作簿对�?
	 * @return 已经写入列头的Sheet
	 */
	private static Sheet buildDataSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		// 设置列头宽度
		for (int i = 0; i < CELL_HEADS.size(); i++) {
			sheet.setColumnWidth(i, 4000);
		}
		// 设置默认行高
		sheet.setDefaultRowHeight((short) 400);
		// 构建头单元格样式
		CellStyle cellStyle = buildHeadCellStyle(sheet.getWorkbook());
		// 写入第一行各列的数据
		Row head = sheet.createRow(0);
		for (int i = 0; i < CELL_HEADS.size(); i++) {
			Cell cell = head.createCell(i);
			cell.setCellValue(CELL_HEADS.get(i));
			cell.setCellStyle(cellStyle);
		}
		return sheet;
	}

	/**
	 * 设置第一行列头的样式
	 * 
	 * @param workbook
	 *            工作簿对�?
	 * @return 单元格样式对�?
	 */
	private static CellStyle buildHeadCellStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		// 对齐方式设置
		style.setAlignment(HorizontalAlignment.CENTER);
		// 边框颜色和宽度设�?
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex()); // 下边�?
		style.setBorderLeft(BorderStyle.THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex()); // 左边�?
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex()); // 右边�?
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex()); // 上边�?
		// 设置背景颜色
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		// 粗体字设�?
		Font font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		return style;
	}

	/**
	 * 将数据转换成�?
	 * 
	 * @param data
	 *            源数�?
	 * @param row
	 *            行对�?
	 * @return
	 */
	private static void convertDataToRow(ResultDataVO data, Row row) {
		int cellNum = 0;
		Cell cell;
		// 姓名
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getName());

		// 人员编号
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getUserId());

		// 卡号
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getCardId());

		// 部门
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getDepartment());

		// 上午入园时间
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getAmOnTime());

		// 上午离园时间
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getAmOffTime());

		// 下午入园时间
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getPmOnTime());

		// 下午离园时间
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getPmOffTime());

		// 全天在园时间
		cell = row.createCell(cellNum++);
		cell.setCellValue(data.getOnDutyTime());
	}
}
