package com.sungrow.wind.global;

import lombok.Data;

/**
 * @author ZHENGDONG
 * @date 2020/11/13 15:37
 */
@Data
public class RequestHeader {

    private String token;

    private String userId;

    private String userName;

    private String hospitalId;

    private String departmentId;

    private String departName;

    private String role;

    private String xLanguageId;

    //TODO
    public static RequestHeader getDefault() {
        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setToken("");
//        requestHeader.setUserId("a37f0aa9-8abc-11eb-a440-06eafa0d7bfd");
//        requestHeader.setUserName("测1");
//        requestHeader.setHospitalId("1111");
//        requestHeader.setDepartmentId("12007");
//        requestHeader.setDepartName("设备科");

//        requestHeader.setUserId("9840c5e9-9040-11eb-a440-06eafa0d7bfd");
//        requestHeader.setUserName("绩效1.2用户");
//        requestHeader.setHospitalId("1111");
//        requestHeader.setDepartmentId("70006");
//        requestHeader.setDepartName("医务科");


//        requestHeader.setUserId("24115846-906a-11eb-a440-06eafa0d7bfd");
//        requestHeader.setUserName("信息科填报人");
//        requestHeader.setHospitalId("1111");
//        requestHeader.setDepartmentId("12003");
//        requestHeader.setDepartName("信息科");

//        requestHeader.setUserId("40021");
//        requestHeader.setUserName("伍美兰");
//        requestHeader.setHospitalId("1111");
//        requestHeader.setDepartmentId("10001");
//        requestHeader.setDepartName("财务科");

//        requestHeader.setUserId("444bff20-8add-11eb-a440-06eafa0d7bfd");
//        requestHeader.setUserName("门1");
//        requestHeader.setHospitalId("1111");
//        requestHeader.setDepartmentId("Z4001");
//        requestHeader.setDepartName("门诊科");

//        requestHeader.setUserId("40023");
//        requestHeader.setUserName("冯俊朝");
//        requestHeader.setHospitalId("1111");
//        requestHeader.setDepartmentId("20006");
//        requestHeader.setDepartName("YJK-药剂科");

        requestHeader.setUserId("25bc43143fed43608febf89b5b5c088f");
        requestHeader.setUserName("dzc");
        requestHeader.setHospitalId("1111");
        requestHeader.setDepartmentId("12003");
        requestHeader.setDepartName("信息科");

        requestHeader.setRole("admin");
        requestHeader.setXLanguageId("zh_CN");
        return requestHeader;
    }

    private static final ThreadLocal<RequestHeader> headLocal = new ThreadLocal<>();

    //删除当前线程，防止内存泄露
    public static void removeCurrentLocal() {
        headLocal.remove();
    }

    //进
    public static void addHeader(RequestHeader requestHeader){
        headLocal.set(requestHeader);
    }

    //获取
    public static RequestHeader getHeader(){
        return headLocal.get()== null ? getDefault() : headLocal.get();
    }

}
