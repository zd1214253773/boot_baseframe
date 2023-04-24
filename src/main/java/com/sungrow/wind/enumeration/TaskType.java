package com.sungrow.wind.enumeration;

public enum TaskType {

    TASK_COMPLETE("已完成任务","TASK_COMPLETE"),

    TASK_UNCOMPLETE("未完成任务","TASK_UNCOMPLETE"),

    TASK_ALL("全部任务","TASK_ALL");

    TaskType(String name, String value){

        this.name = name;
        this.value = value;
    }
    public static TaskType getStatusType(String value){
        for (TaskType c : TaskType.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new RuntimeException("不存在该状态");
    }
    private String name;

    private String value;


}
