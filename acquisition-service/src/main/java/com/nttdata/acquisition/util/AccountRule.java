package com.nttdata.acquisition.util;

public class AccountRule {
    private String accountType;
    private String customerType;
    private boolean maintenanceCommission;
    private boolean maximumMovementLimit;
    private Integer movementAmount;
    private Integer maximumAccount;
    private Integer minimumHeadlines;
    private Integer maximunHeadlines;
    private Integer minimumAuthorizedSigners;
    private Integer maximunAuthorizedSigners;

    public AccountRule(String accountType, String customerType){
        //accountType: CUENTA_AHORRO, CUENTA_CORRIENTE AND CUENTA_PLAZOFIJO
        //customerType: PERSONAL AND ENTERPRISE
        this.accountType = accountType;
        this.customerType = customerType;
        this.maintenanceCommission = accountType == "CUENTA_AHORRO" ? false : accountType == "CUENTA_CORRIENTE" ? true : false;
        this.maximumMovementLimit = accountType == "CUENTA_AHORRO" ? false : accountType == "CUENTA_CORRIENTE" ? true : false;
        this.movementAmount = accountType == "CUENTA_AHORRO" ? 50 : accountType == "CUENTA_CORRIENTE" ? Integer.MAX_VALUE : 1;
        this.maximumAccount = accountType == "CUENTA_AHORRO"    ? customerType == "PERSONAL" ? 1 : 0 :
                              accountType == "CUENTA_CORRIENTE" ? customerType == "PERSONAL" ? 1 : Integer.MAX_VALUE :
                                                                  customerType == "PERSONAL" ? 1 : 0;
        this.minimumHeadlines = customerType == "PERSONAL" ? 1 : 1;
        this.maximunHeadlines = customerType == "PERSONAL" ? 1 : Integer.MAX_VALUE;
        this.minimumAuthorizedSigners = customerType == "PERSONAL" ? 1 : 0;
        this.maximunAuthorizedSigners = customerType == "PERSONAL" ? 1 : Integer.MAX_VALUE;
    }
}
