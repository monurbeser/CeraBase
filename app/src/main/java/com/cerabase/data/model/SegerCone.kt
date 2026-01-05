package com.cerabase.data.model

data class SegerCone(
    val number: String,
    val temperatureCelsius: Int,
    val temperatureFahrenheit: Int,
    val description: String,
    val usage: String
)

object SegerConeData {
    val cones = listOf(
        SegerCone("022", 600, 1112, "Çok Düşük", "Dekor, lüster"),
        SegerCone("021", 615, 1139, "Çok Düşük", "Overglaze dekorları"),
        SegerCone("020", 635, 1175, "Çok Düşük", "Düşük sıcaklık sırları"),
        SegerCone("019", 690, 1274, "Düşük", "Düşük sıcaklık sırları"),
        SegerCone("018", 720, 1328, "Düşük", "Düşük sıcaklık sırları"),
        SegerCone("017", 750, 1382, "Düşük", "Kırmızı toprak sırları"),
        SegerCone("016", 795, 1463, "Düşük", "Kırmızı toprak sırları"),
        SegerCone("015", 815, 1499, "Düşük", "Düşük sıcaklık bisküvi"),
        SegerCone("014", 840, 1544, "Düşük", "Düşük sıcaklık bisküvi"),
        SegerCone("013", 865, 1589, "Düşük-Orta", "Düşük sıcaklık sırları"),
        SegerCone("012", 900, 1652, "Düşük-Orta", "Majolik, fayans"),
        SegerCone("011", 920, 1688, "Düşük-Orta", "Majolik, fayans"),
        SegerCone("010", 940, 1724, "Düşük-Orta", "Terracotta bisküvi"),
        SegerCone("09", 960, 1760, "Düşük-Orta", "Terracotta sırlama"),
        SegerCone("08", 990, 1814, "Orta", "Fayans, soft paste"),
        SegerCone("07", 1010, 1850, "Orta", "Fayans bisküvi"),
        SegerCone("06", 1030, 1886, "Orta", "Fayans sırlama"),
        SegerCone("05", 1060, 1940, "Orta", "Düşük ateş taş"),
        SegerCone("04", 1080, 1976, "Orta", "Orta sıcaklık sırları"),
        SegerCone("03", 1100, 2012, "Orta", "Orta sıcaklık bünyeler"),
        SegerCone("02", 1120, 2048, "Orta", "Orta sıcaklık sırları"),
        SegerCone("01", 1140, 2084, "Orta-Yüksek", "Taş bünyeler bisküvi"),
        SegerCone("1", 1160, 2120, "Orta-Yüksek", "Taş bünyeler sırlama"),
        SegerCone("2", 1170, 2138, "Orta-Yüksek", "Taş bünyeler"),
        SegerCone("3", 1180, 2156, "Yüksek", "Yüksek ateş sırları"),
        SegerCone("4", 1190, 2174, "Yüksek", "Porselen bisküvi"),
        SegerCone("5", 1205, 2201, "Yüksek", "Porselen bisküvi"),
        SegerCone("6", 1230, 2246, "Yüksek", "Porselen sırlama"),
        SegerCone("7", 1250, 2282, "Yüksek", "Yüksek ateş sırları"),
        SegerCone("8", 1260, 2300, "Yüksek", "Redüksiyon sırları"),
        SegerCone("9", 1280, 2336, "Çok Yüksek", "Porselen, yüksek ateş"),
        SegerCone("10", 1305, 2381, "Çok Yüksek", "Yüksek ateş porselen"),
        SegerCone("11", 1320, 2408, "Çok Yüksek", "İleri porselen"),
        SegerCone("12", 1350, 2462, "Çok Yüksek", "Endüstriyel seramik")
    )
}
