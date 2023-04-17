package server;

import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class Status {

    private String locate;
    private String value;
    private LinkedList<Status> statusList = new LinkedList<>();

    public Status() {

    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public JSONObject statusAtt(JSONObject jObj) throws JSONException { // atualiza o status de cada equipamento
        if (jObj.get("command").equals("set")) {
            for (Status item : statusList) {
                if (jObj.get("locate").equals(item.getLocate())) {
                    item.setValue(jObj.get("value").toString());
                }
            }
        } else if (jObj.get("command").equals("get")) {
            for (Status item : statusList) {
                if (jObj.get("locate").equals(item.getLocate())) {
                    jObj.put("value", item.getValue());
                }
            }
        } else if (jObj.get("command").equals("status")) {
            jObj.put("status", statusList);
        }
        return jObj; // retorna a lista de status de todos os equipamentos
    }

    public void list() {
        Status status = new Status();
        status.setValue("Off");
        status.setLocate("luz_guarita");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("ar_guarita");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("luz_estacionamento");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("luz_galpao_externo");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("luz_galpao_interno");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("luz_escritorios");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("ar_escritorios");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("luz_sala_reunioes");
        statusList.add(status);
        status = new Status();
        status.setValue("Off");
        status.setLocate("ar_sala_reunioes");
        statusList.add(status);
    }
}
