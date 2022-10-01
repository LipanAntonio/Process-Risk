package Utils;
import org.example.Process;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Risk;

import java.util.List;

public class ExcelUtils {
    XSSFWorkbook workBook;
    XSSFSheet sheet;
//liferay; vaadin
    public ExcelUtils(String excelPath) {
        try {
            workBook = new XSSFWorkbook(excelPath);
            sheet = workBook.getSheetAt(0);
        } catch (Exception e) {
            System.out.println("Invalid path");
        }
    }
    public void populateProcessList(List <Process> processList, List <Risk> riskList) {

        int lastProcessId = -1;

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            int currentProcessID = (int) sheet.getRow(i).getCell(0).getNumericCellValue();

            if (currentProcessID != lastProcessId) {
                Process newProcess = createNewProcess(i);
                Risk newRisk = createNewRisk(i, newProcess);

                newProcess.addRisk(newRisk);
                riskList.add(newRisk);

                processList.add(newProcess);
                lastProcessId = currentProcessID;

            } else {
                Process lastProcess = processList.get(processList.size() - 1);

                Risk newRisk = createNewRisk(i, lastProcess);

                lastProcess.addRisk(newRisk);
                riskList.add(newRisk);
            }
        }
    }
    Process createNewProcess(int row){

        int ID = (int) sheet.getRow(row).getCell(0).getNumericCellValue();
        String name = sheet.getRow(row).getCell(1).getStringCellValue().trim();
        String description = sheet.getRow(row).getCell(2).getStringCellValue().trim();

        return new Process(ID, name, description);
    }

    Risk createNewRisk(int row, Process argProcess){
        int ID = (int) sheet.getRow(row).getCell(3).getNumericCellValue();
        String name = sheet.getRow(row).getCell(4).getStringCellValue().trim();
        String description = sheet.getRow(row).getCell(5).getStringCellValue().trim();

        return new Risk(ID, name, description, argProcess);
    }

}