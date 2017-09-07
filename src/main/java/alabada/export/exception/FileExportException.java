package alabada.export.exception;

public class FileExportException extends Exception {

    public FileExportException(String message){
        super(message);
    }

    public FileExportException(Throwable throwable, String message){
        super(message, throwable);
    }

    public FileExportException(Throwable throwable){
        super(throwable);
    }
}
