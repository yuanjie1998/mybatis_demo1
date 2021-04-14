package com.mybatis.demo1.Enum;

/**
 * @Author yuan jie
 * @Date 2021/4/2 13:50
 */
public enum RetEntityEnum {
    SUCCESSFUL(1,"成功！"),
    UNSUCCESSFUL(0,"失败！");


    private Integer code;
    private String codeDesc;

    RetEntityEnum(Integer code, String codeDesc) {
        this.code = code;
        this.codeDesc = codeDesc;
    }

    public Integer getCode() {
        return code;
    }

    public String getCodeDesc() {
        return codeDesc;
    }
}
