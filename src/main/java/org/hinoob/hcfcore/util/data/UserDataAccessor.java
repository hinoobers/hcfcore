package org.hinoob.hcfcore.util;

import com.google.gson.JsonObject;
import org.hinoob.hcfcore.user.HUser;

public class DataAccessor {

    private HUser user;

    private JsonObject data;

    public DataAccessor(HUser user, JsonObject data) {
        this.user = user;
        this.data = data;
    }

    public boolean has(String key) {
        return data.has(key);
    }

    public void set(String key, Object value) {
        data.addProperty(key, value.toString());
    }

    public int getInt(String key) {
        return data.get(key).getAsInt();
    }

    public int getPower() {
        if(has("power")) {
            return getInt("power");
        }

        set("power", StaticFields.DEFAULT_POWER);
        return StaticFields.DEFAULT_POWER;
    }

    public String build() {
        return data.toString();
    }
}
