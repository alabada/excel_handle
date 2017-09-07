package alabada.importfile.domain;

import alabada.importfile.domain.common.ImportResult;

import java.util.List;

public class MapResult<Map> extends ImportResult {
    public final static String LINE_NUM_KEY = "lineNum";
    public final static String IS_LINE_LEGAL_KEY = "isLineLegal";
    List<Map> result;

    @Override
    public List<Map> getResult() {
        return result;
    }

    public void setResult(List<Map> result) {
        this.result = result;
    }
}
