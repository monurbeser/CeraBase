package com.cerabase.data.model

data class ClayFormula(
    val name: String,
    val type: String,
    val cone: String,
    val ingredients: Map<String, Float>,
    val properties: String,
    val usage: String
)

object ClayFormulaData {
    val formulas = listOf(
        ClayFormula(
            name = "Beyaz Taş Bünye (Orta Ateş)",
            type = "Taş Bünye",
            cone = "Koni 4-6",
            ingredients = mapOf(
                "Ball Clay" to 25f,
                "Kaolin (EPK)" to 25f,
                "Feldspat (Potasyum)" to 25f,
                "Silika (200 mesh)" to 25f
            ),
            properties = "Düşük porozite, beyaz renk, iyi mukavemet. Pürüzsüz yüzey.",
            usage = "Fonksiyonel çanak, çömlek, sırlı işler"
        ),
        ClayFormula(
            name = "Porselen Bünye (Yüksek Ateş)",
            type = "Porselen",
            cone = "Koni 9-10",
            ingredients = mapOf(
                "Kaolin (Grolleg)" to 30f,
                "Ball Clay" to 10f,
                "Feldspat (Potasyum)" to 25f,
                "Silika (200 mesh)" to 25f,
                "Bentonit" to 2f
            ),
            properties = "Translüsent, beyaz, yüksek mukavemet. Zor işlenir.",
            usage = "İnce porselen, translüsent işler"
        ),
        ClayFormula(
            name = "Kırmızı Toprak (Terracotta)",
            type = "Toprak Bünye",
            cone = "Koni 06-04",
            ingredients = mapOf(
                "Kırmızı Kil" to 60f,
                "Ball Clay" to 20f,
                "Talk" to 10f,
                "Kuvars" to 10f
            ),
            properties = "Kırmızı-kahverengi, gözenekli, kolay işlenir.",
            usage = "Saksı, heykel, düşük sıcaklık işler"
        ),
        ClayFormula(
            name = "Gres Bünye (Taş)",
            type = "Gres",
            cone = "Koni 8-10",
            ingredients = mapOf(
                "Gres Kil" to 40f,
                "Ball Clay" to 20f,
                "Kaolin" to 10f,
                "Feldspat" to 20f,
                "Silika" to 10f
            ),
            properties = "Koyu gri-kahve, su geçirmez, sert. Redüksiyon için ideal.",
            usage = "Yüksek ateş çanak, redüksiyon sırları"
        ),
        ClayFormula(
            name = "Raku Bünye",
            type = "Raku",
            cone = "Koni 06-04",
            ingredients = mapOf(
                "Gres Kil" to 40f,
                "Ball Clay" to 20f,
                "Kuvars (30 mesh)" to 20f,
                "Kyanite veya Molochite" to 20f
            ),
            properties = "Termal şok direnci yüksek, büyük taneli. Hızlı ısı değişimine dayanır.",
            usage = "Raku pişirimi, açık hava pişirimleri"
        ),
        ClayFormula(
            name = "Heykeltıraş Kili (Şamotlu)",
            type = "Heykel",
            cone = "Koni 4-8",
            ingredients = mapOf(
                "Ball Clay" to 30f,
                "Kaolin" to 15f,
                "Gres Kil" to 25f,
                "Şamot (30-80 mesh)" to 30f
            ),
            properties = "Çok dayanıklı, büyük işler için. Az kuruma çatlağı.",
            usage = "Büyük heykeller, duvar panelleri"
        ),
        ClayFormula(
            name = "Porselen (Kolay İşlenir)",
            type = "Porselen",
            cone = "Koni 6",
            ingredients = mapOf(
                "Kaolin" to 25f,
                "Ball Clay" to 25f,
                "Nefelin Siyenit" to 25f,
                "Silika" to 20f,
                "Bentonit" to 3f,
                "V-Gum" to 2f
            ),
            properties = "Orta ateş porselen, iyi plastiklik, beyaz.",
            usage = "El tornası işleri, porselen görünüm"
        ),
        ClayFormula(
            name = "Çömlek Bünye (Oksidasyonlu)",
            type = "Taş Bünye",
            cone = "Koni 5-6",
            ingredients = mapOf(
                "Ball Clay" to 30f,
                "Kaolin" to 20f,
                "Feldspat" to 20f,
                "Silika" to 15f,
                "Talk" to 10f,
                "Bentonit" to 3f
            ),
            properties = "Orta kahverengi-bej, iyi fırınlama, dayanıklı.",
            usage = "Fonksiyonel çanak, tabak, kase"
        ),
        ClayFormula(
            name = "Çini Bünye (Beyaz)",
            type = "Fayans",
            cone = "Koni 02-04",
            ingredients = mapOf(
                "Ball Clay" to 35f,
                "Kaolin" to 25f,
                "Feldspat" to 15f,
                "Talk" to 15f,
                "Silika" to 10f
            ),
            properties = "Beyazımsı, gözenekli, düşük sıcaklık. Majolik için.",
            usage = "Çini, majolik, düşük ateş sırlama"
        ),
        ClayFormula(
            name = "Kırmızı Taş Bünye",
            type = "Taş Bünye",
            cone = "Koni 6",
            ingredients = mapOf(
                "Kırmızı Kil" to 35f,
                "Ball Clay" to 25f,
                "Feldspat" to 20f,
                "Silika" to 15f,
                "Demir Oksit" to 3f,
                "Bentonit" to 2f
            ),
            properties = "Koyu kırmızı-kahve, su geçirmez, dekoratif.",
            usage = "Dekoratif çanak, kırmızı taş görünüm"
        ),
        ClayFormula(
            name = "Papertclay (Kağıt Kil)",
            type = "Özel",
            cone = "Koni 4-10",
            ingredients = mapOf(
                "Ana Bünye" to 70f,
                "Sellüloz Fiber (kağıt hamuru)" to 20f,
                "Bentonit" to 5f,
                "CMC Gum" to 5f
            ),
            properties = "Çok hafif, yüksek onarım kabiliyeti, çatlama direnci.",
            usage = "İnce duvarlar, onarım, deneysel işler"
        ),
        ClayFormula(
            name = "Siyah Bünye",
            type = "Renkli",
            cone = "Koni 5-6",
            ingredients = mapOf(
                "Ball Clay" to 30f,
                "Gres Kil" to 30f,
                "Feldspat" to 20f,
                "Silika" to 10f,
                "Mangan Dioksit" to 5f,
                "Kobalt Karbonat" to 2f,
                "Demir Oksit" to 3f
            ),
            properties = "Siyah renk, su geçirmez, modern görünüm.",
            usage = "Modern tasarım, siyah işler, dekoratif"
        )
    )
}
