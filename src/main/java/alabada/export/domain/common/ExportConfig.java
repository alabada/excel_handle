package alabada.export.domain.common;

import alabada.domain.BaseModel;

import java.util.List;

public class ExportConfig extends BaseModel {
    private String fileName;//输出的文件名
    private ExportType exportType;//0 表示 excel, 1 表示txt
    private List<ExportCell> exportCells;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<ExportCell> getExportCells() {
        return exportCells;
    }

    public void setExportCells(List<ExportCell> exportCells) {
        this.exportCells = exportCells;
    }

    public ExportType getExportType() {
        return exportType;
    }

    public void setExportType(ExportType exportType) {
        this.exportType = exportType;
    }
}
