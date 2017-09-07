package alabada.export.domain.excel;

import alabada.export.domain.common.ExportResult;
import alabada.export.domain.common.ExportType;
import alabada.export.exception.FileExportException;

import java.io.IOException;
import java.io.OutputStream;

public class ExportCSVResult extends ExportResult {
    private String result;

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public Object getResult() {
        return result;
    }

    public void export(OutputStream outputStream) throws FileExportException {
        try {
            outputStream.write(result.getBytes("UTF-8"));
            outputStream.close();
        } catch (IOException e) {
            throw new FileExportException("Error occurred while exportCSV msg is " + e);
        }
    }

    @Override
    public ExportType getExportType() {
        return ExportType.CSV;
    }


}
