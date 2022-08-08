package generic;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//*******************************************GetConfigData********************************************************/
public class Utility {
	public static String getProperty(String path, String key) {
		String v = "";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(key);
		} catch (Exception e) {

		}
		return v;
	}

//*******************************************GetXLData********************************************************/
	public static String getXLData(String path, String sheetName, int row, int col) {
		String v = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		} catch (Exception e) {

		}
		return v;
	}

//*******************************************getLAstrowcoutn********************************************************/
	public static int getXlRowCoutn(String path, String sheetName) {
		int row = 0;
		try {
			Workbook wb = WorkbookFactory.create(new File(path));
			row = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {

		}
		return row;
	}

//*******************************************GetXLcolumncount********************************************************/
	public static int getXLColCount(String path, String sheetName, int row) {
		int col = 0;
		try {
			Workbook wb = WorkbookFactory.create(new File(path));
			col = wb.getSheet(sheetName).getRow(row).getLastCellNum();
		} catch (Exception e) {

		}
		return col;
	}

//*******************************************GetXLData********************************************************/
	public static Iterator<String[]> getDataFromExcel(String path, String sheetName) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		try {
			Workbook wb = WorkbookFactory.create(new File(path));
			Sheet sheet = wb.getSheet(sheetName);
			int rc = sheet.getLastRowNum();
			for (int i = 1; i <= rc; i++) {
				try {
					int cc = sheet.getRow(i).getLastCellNum();
					String[] cell = new String[cc];
					for (int j = 0; j < cc; j++) {
						try {
							String v = sheet.getRow(i).getCell(j).toString();
							cell[j] = v;
						}

						catch (Exception e) {
							cell[j] = " ";
						}

					}
					data.add(cell);
				} catch (Exception e) {

				}
				wb.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data.iterator();
	}
}
