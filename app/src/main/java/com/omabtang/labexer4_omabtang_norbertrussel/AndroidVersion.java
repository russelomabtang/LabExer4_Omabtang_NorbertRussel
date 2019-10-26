package com.omabtang.labexer4_omabtang_norbertrussel;

public class AndroidVersion {
    private int logo;
    private String name, rInfo, rCountry, rCEO, rIndustry;

    public AndroidVersion(int logo, String rCountry, String rIndustry, String name, String rCEO) {
        this.logo = logo;
        this.name = name;
        this.rCEO = rCEO;
        this.rCountry = rCountry;
        this.rIndustry = rIndustry;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getrInfo() {
        return rInfo;
    }

    public String getrCountry() {
        return rCountry;
    }

    public String getrCEO() {
        return rCEO;
    }

    public String getrIndustry() {
        return rIndustry;
    }
}
