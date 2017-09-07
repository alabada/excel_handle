package alabada.importfile;

import alabada.importfile.domain.common.Configuration;
import alabada.importfile.exception.FileImportException;
import alabada.importfile.impl.XmlConfigParser;

public class ConfigurationParserFactory {
    public static ConfigParser getConfigParser(Configuration.ParserType parserType) throws FileImportException {
        if (parserType == null) {
            throw new FileImportException("parserType is null");
        }
        if (parserType == Configuration.ParserType.XML) {
            return new XmlConfigParser();
        }
        return new XmlConfigParser();
    }


}
