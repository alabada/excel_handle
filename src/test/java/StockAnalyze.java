import alabada.importfile.ConfigParser;
import alabada.importfile.ConfigurationParserFactory;
import alabada.importfile.FileImportExecutor;
import alabada.importfile.domain.MapResult;
import alabada.importfile.domain.common.Configuration;
import alabada.importfile.exception.FileImportException;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by zhida.wen on 2017/9/9.
 */
public class StockAnalyze {


    @org.junit.Test
    public void testDemo()  throws FileImportException, FileNotFoundException, URISyntaxException {
        ConfigParser configParser = ConfigurationParserFactory.getConfigParser(Configuration.ParserType.XML);
        URI uri = Test.class.getResource("import/testExcel.xlsx").toURI();
        File importFile = new File(uri);
        Configuration configuration = null;
        try {
            configuration = configParser.getConfig(Test.class.getResourceAsStream("import/config1.xml"));
            MapResult mapResult = (MapResult) FileImportExecutor.importFile(configuration, importFile, importFile.getName());
            List<Map> maps = mapResult.getResult();
            for (Map<String, Object> map : maps) {

//                System.out.println(JSON.toJSONString(map));

                System.out.println(map.get("ERP单号"));

            }
        } catch (FileImportException e) {
            System.out.println(e);
        }
    }

    // /Users/zhida.wen/01-成交明细/601166
    @org.junit.Test
    public void test601166() throws FileImportException, FileNotFoundException, URISyntaxException, Exception {
        ConfigParser configParser = ConfigurationParserFactory.getConfigParser(Configuration.ParserType.XML);
        URI uri = Test.class.getResource("import/601166/060116620170904.xls").toURI();
        File importFile = new File(uri);
        Configuration configuration = null;
        try {
            configuration = configParser.getConfig(Test.class.getResourceAsStream("import/config601166.xml"));
            MapResult mapResult = (MapResult) FileImportExecutor.importFile(configuration, importFile, importFile.getName());
            List<Map> maps = mapResult.getResult();
            for (Map<String, Object> map : maps) {

                System.out.println(map.get("time"));

            }
        } catch (FileImportException e) {
            System.out.println(e);
        }
    }
}
