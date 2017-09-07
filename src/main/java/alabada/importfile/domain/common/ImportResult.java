package alabada.importfile.domain.common;


import alabada.domain.BaseModel;

import java.util.List;

public abstract class ImportResult<E> extends BaseModel {
    public abstract List<E> getResult();
    private String resMsg;//返回的信息
    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

}
