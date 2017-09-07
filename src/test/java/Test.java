import alabada.export.ExportConfigFactory;
import alabada.export.FileExportor;
import alabada.export.domain.common.ExportConfig;
import alabada.export.domain.common.ExportResult;
import alabada.export.exception.FileExportException;
import alabada.importfile.ConfigParser;
import alabada.importfile.ConfigurationParserFactory;
import alabada.importfile.FileImportExecutor;
import alabada.importfile.domain.MapResult;
import alabada.importfile.domain.common.Configuration;
import alabada.importfile.exception.FileImportException;

import java.io.*;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws FileImportException, FileNotFoundException, FileExportException, URISyntaxException {

        testImport();
//        URL u = Test.class.getResource("import/config.xml");
//        System.out.println(u.toString());
//        testExport();
    }


    public static void testImport() throws FileImportException, FileNotFoundException, URISyntaxException {

        ConfigParser configParser = ConfigurationParserFactory.getConfigParser(Configuration.ParserType.XML);
        URI uri = Test.class.getResource("import/testImport.xlsx").toURI();
        File importFile = new File(uri);
        Configuration configuration = null;
        try {
            configuration = configParser.getConfig(Test.class.getResourceAsStream("import/config.xml"));
            MapResult mapResult = (MapResult) FileImportExecutor.importFile(configuration, importFile, importFile.getName());
            List<Map> maps = mapResult.getResult();
            for (Map<String, Object> map : maps) {
                int index = (int) map.get("index");
                float f1 = (float) map.get("float");
                String string = (String) map.get("string");
                Date date = (Date) map.get("date");
                BigDecimal bigDecimal = (BigDecimal) map.get("bigdecimal");

                System.out.println("index :" + index + " f1 : " + f1 + " string : " + string
                        + " date : " + date.toString() + " bigdecimal " + bigDecimal);
            }
        } catch (FileImportException e) {
            System.out.println(e);
        }
    }




    public static void testExport() throws FileNotFoundException, FileExportException {
        ExportConfig exportConfig = ExportConfigFactory.getExportConfig(Test.class.getResourceAsStream("export/exportconfig.xml"));
        //map也可以换成一个实体类
        List<Map> lists = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("index", i);
            maps.put("date", new Date());
            maps.put("greet", "hi" + i);
            maps.put("float", Float.valueOf(i));
            maps.put("bigdecimal", BigDecimal.valueOf(i));
            lists.add(maps);
        }
        ExportResult exportResult = FileExportor.getExportResult(exportConfig, lists);
        OutputStream outputStream = new FileOutputStream("d://output.xlsx");
        exportResult.export(outputStream);

    }

    /**
     * 我用于web下载时的代码
     */
    private void testExportInDownload() {
//        HttpServletResponse httpResponse = response();
//        ExportType exportType = exportResult.getExportType();
//        httpResponse.setContentType(exportType.getContentType());
//        httpResponse.setHeader("Content-disposition", "attachment;filename=" + reEncodeExportName(exportResult.getFileName()) + "." + exportType.getFileType());
//        try {
//            exportResult.export(httpResponse.getOutputStream());
//        } catch (IOException e) {
//            throw new FileExportException(" exportFile " + e.getMessage());
//        }
    }
}
