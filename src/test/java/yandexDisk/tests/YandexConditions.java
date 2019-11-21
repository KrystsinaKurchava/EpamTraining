package yandexDisk.tests;

import org.testng.annotations.Listeners;
import yandexDisk.service.TestListener;

@Listeners({TestListener.class})
public class YandexConditions {
    protected final String LINK_FOR_YANDEX_DISK = "https://disk.yandex.by/";
}