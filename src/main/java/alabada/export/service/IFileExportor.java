package alabada.export.service;

import alabada.export.domain.common.ExportCell;
import alabada.export.exception.FileExportException;

import java.util.List;

public interface IFileExportor {
    /**
     * 数据导出
     * @param data
     * @param exportCells
     * @return
     * @throws alabada.export.exception.FileExportException
     */
    public Object getExportResult(List<?> data, List<ExportCell> exportCells) throws FileExportException;


}
