package alabada.importfile.exception;

public class FileImportException extends Exception {

    public FileImportException(Throwable throwable, String message){
        super(message, throwable);
    }

    public FileImportException(String message) {
        super(message);
    }
}
