package alabada.importfile;

import alabada.importfile.domain.common.ImportResult;
import alabada.importfile.exception.FileImportException;

import java.io.File;

public abstract class FileImportor {

    public abstract ImportResult getImportResult(File file, String fileName) throws FileImportException;

}
