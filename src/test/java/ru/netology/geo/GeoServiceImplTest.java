package ru.netology.geo;

import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    final String ipRussian = "172.123.12.19";
    final String ipUsa = "96.14.52.19";

    @BeforeAll
    static void messageBeforeAll() {
        System.out.println("Тесты запущены");
    }

    @AfterAll
    static void messageAfterAll() {
        System.out.println("Тесты завершены");
    }


    @Test
    void byIpRussianTest() {
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp(ipRussian);
        assertEquals(expected.getCountry(), actual.getCountry());
    }

    @Test
    void byIpEnglishTest() {
        Location expected = new Location("New Your", Country.USA, null, 0);
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp(ipUsa);
        assertEquals(expected.getCountry(), actual.getCountry());
    }
}