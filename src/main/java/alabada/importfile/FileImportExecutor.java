package alabada.importfile;

import alabada.importfile.domain.common.Configuration;
import alabada.importfile.domain.common.ImportResult;
import alabada.importfile.exception.FileImportException;
import alabada.importfile.impl.ExcelImportor;

import java.io.File;

public class FileImportExecutor {

    public static ImportResult importFile(Configuration configuration, File file, String fileName) throws FileImportException{
        FileImportor fileImportor = getFileImportor(configuration);
        return fileImportor.getImportResult(file, fileName);
    }

    /**
     * 根据configuration里面 imporFileType返回
     * 默认 返回 ExcelImportor
     * @param configuration
     * @return
     */
    private static FileImportor getFileImportor(Configuration configuration) throws FileImportException {
        if (configuration.getImportFileType() == Configuration.ImportFileType.EXCEL) {
            return new ExcelImportor(configuration);
        }
        throw new FileImportException("Can not find Importor. Please check importFileType in configuration");
    }

}
