import alabada.importfile.ConfigParser;
import alabada.importfile.ConfigurationParserFactory;
import alabada.importfile.FileImportExecutor;
import alabada.importfile.domain.MapResult;
import alabada.importfile.domain.common.Configuration;
import alabada.importfile.exception.FileImportException;
import com.google.common.collect.Lists;
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

    private static final double STANDARD = 500000.0;

    // /Users/zhida.wen/01-成交明细/601166
    @org.junit.Test
    public void test601166() throws FileImportException, FileNotFoundException, URISyntaxException, Exception {
        ConfigParser configParser = ConfigurationParserFactory.getConfigParser(Configuration.ParserType.XML);

        Configuration configuration = null;
        try {
            configuration = configParser.getConfig(Test.class.getResourceAsStream("import/config601166.xml"));

            List<String> fileNames = Lists.newArrayList();
            fileNames.add("import/601166/060116620170904.xls");
            fileNames.add("import/601166/060116620170905.xls");
            fileNames.add("import/601166/060116620170906.xls");
            fileNames.add("import/601166/060116620170907.xls");
            fileNames.add("import/601166/060116620170908.xls");

            for (String fileName: fileNames) {

                URI uri = Test.class.getResource(fileName).toURI();
                File importFile = new File(uri);
                MapResult mapResult = (MapResult) FileImportExecutor.importFile(configuration, importFile, importFile.getName());
                List<Map> maps = mapResult.getResult();

                // 统计数据
                int bigBuyNum = 0;
                int bigSellNum = 0;
                for (Map<String, Object> map : maps) {

                    Double amount = Double.parseDouble((String)map.get("money"));
                    if (amount > STANDARD) {
                        if ("买盘".equals((String)map.get("buyOrSell"))){
                            bigBuyNum ++;
                        } else if ("卖盘".equals((String)map.get("buyOrSell"))){
                            bigSellNum ++;
                        }
                    }
                }
                System.out.println(fileName + "统计数据如下:");
                System.out.println("大单买入数量：" + bigBuyNum);
                System.out.println("大单卖出数量：" + bigSellNum);
                System.out.println("---------------------------");

            }
        } catch (FileImportException e) {
            System.out.println(e);
        }
    }
}
