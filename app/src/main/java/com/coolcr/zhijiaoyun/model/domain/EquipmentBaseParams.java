package com.coolcr.zhijiaoyun.model.domain;

/**
 * Created by CoolCrush
 * On 2021/7/11
 * Email CoolCrush@126.com
 */
public class EquipmentBaseParams {
    String equipmentAppVersion;
    String equipmentModel;
    String equipmentApiVersion;

    public String getEquipmentAppVersion() {
        return equipmentAppVersion;
    }

    public void setEquipmentAppVersion(String equipmentAppVersion) {
        this.equipmentAppVersion = equipmentAppVersion;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentApiVersion() {
        return equipmentApiVersion;
    }

    public void setEquipmentApiVersion(String equipmentApiVersion) {
        this.equipmentApiVersion = equipmentApiVersion;
    }
}
