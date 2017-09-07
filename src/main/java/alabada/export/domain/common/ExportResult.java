package alabada.export.domain.common;

import alabada.export.exception.FileExportException;

import java.io.OutputStream;

public abstract class ExportResult {
    private String fileName;

    public abstract Object getResult();

    public abstract void export(OutputStream outputStream) throws FileExportException;

    public abstract ExportType getExportType();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
