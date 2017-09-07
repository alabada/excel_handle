package alabada.export;

import org.apache.poi.ss.usermodel.Workbook;
import alabada.export.domain.common.ExportConfig;
import alabada.export.domain.common.ExportResult;
import alabada.export.domain.common.ExportType;
import alabada.export.domain.excel.ExportCSVResult;
import alabada.export.domain.excel.ExportExcelResult;
import alabada.export.exception.FileExportException;
import alabada.export.impl.CSVExportor;
import alabada.export.impl.ExcelExportor;

import java.util.List;

public class FileExportor {
    public final static String EXPORT_XML_BASE_PATH = "/properties/framework/export/";

    /**
     * 通过list<T> T可为bean或者map<String, Object>  导出文件
     *
     * @param exportConfig
     * @param data
     * @return
     * @throws alabada.export.exception.FileExportException
     */
    public static ExportResult getExportResult(ExportConfig exportConfig, List<?> data) throws FileExportException {
        ExportType exportType = exportConfig.getExportType();
        switch (exportType) {
            case EXCEL2007:
                Workbook workbook = new ExcelExportor().getExportResult(data, exportConfig.getExportCells());
                ExportExcelResult exportExcelResult = new ExportExcelResult();
                exportExcelResult.setWorkbook(workbook);
                exportExcelResult.setFileName(exportConfig.getFileName());
                return exportExcelResult;
            case CSV:
                StringBuilder stringBuilder = new CSVExportor().getExportResult(data, exportConfig.getExportCells());
                ExportCSVResult exportCSVResult = new ExportCSVResult();
                exportCSVResult.setResult(stringBuilder.toString());
                exportCSVResult.setFileName(exportConfig.getFileName());
                return exportCSVResult;
        }
        throw new FileExportException("找不到对应的export type, export type is " + exportType.getNumber());
    }



}
