package api.nbrb.product.service;

import api.utils.ApiUtils;
import api.utils.DateUtils;
import api.nbrb.product.models.NRBCurrency;
import framework.logger.Log;

import java.util.Date;

public class OfficialRateService {
    private static final String LINK_FOR_NRB_API = "http://www.nbrb.by/api";
    private static final String LINK_FOR_CURRENCY_INFORMATION_API = LINK_FOR_NRB_API + "/exrates/rates/%s?parammode=1&ondate=%s";
    private static final int USD_CURRENCY_NUMBER = 840;

    public Double getUsdOfficialRate(Date date) {
        Log.info("Get usd official rate for date %s", DateUtils.getStringFromDate(date));
        String uri = String.format(LINK_FOR_CURRENCY_INFORMATION_API, USD_CURRENCY_NUMBER, DateUtils.getStringFromDate(date));
        return ApiUtils
                .doGetResponseFromApi(uri)
                .getBody()
                .as(NRBCurrency.class)
                .officialRate;
    }
}