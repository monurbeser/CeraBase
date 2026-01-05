package com.cerabase.data.model

data class Oxide(
    val name: String,
    val formula: String,
    val colorEffect: String,
    val percentageRange: String,
    val firingType: String,
    val notes: String
)

object OxideData {
    val oxides = listOf(
        Oxide(
            "Demir Oksit (Kırmızı)",
            "Fe₂O₃",
            "Sarı, kahverengi, kırmızı-kahve",
            "1-8%",
            "Oksidasyon",
            "En yaygın renklendirici. %1-3 sarı-bej, %5-8 koyu kahve"
        ),
        Oxide(
            "Demir Oksit (Siyah)",
            "Fe₃O₄",
            "Yeşil, siyah, koyu kahve",
            "1-10%",
            "Redüksiyon",
            "Redüksiyonda seladon yeşili verir (%1-3 açık yeşil)"
        ),
        Oxide(
            "Kobalt Oksit",
            "CoO",
            "Mavi",
            "0.25-2%",
            "Her ikisi",
            "Çok güçlü! %0.5 orta mavi, %2+ koyu mavi-siyah"
        ),
        Oxide(
            "Kobalt Karbonat",
            "CoCO₃",
            "Mavi",
            "0.5-3%",
            "Her ikisi",
            "Oksitte daha yumuşak, daha kontrollü mavi"
        ),
        Oxide(
            "Bakır Oksit (Siyah)",
            "CuO",
            "Yeşil",
            "1-5%",
            "Oksidasyon",
            "Parlak yeşil tonları. %3-5 koyu yeşil"
        ),
        Oxide(
            "Bakır Karbonat",
            "CuCO₃",
            "Kırmızı, mor",
            "1-8%",
            "Redüksiyon",
            "Redüksiyonda bakır kırmızısı, mor tonları"
        ),
        Oxide(
            "Krom Oksit",
            "Cr₂O₃",
            "Yeşil, pembe, kahverengi",
            "1-5%",
            "Her ikisi",
            "Opak yeşil. Kalay ile pembe, çinko ile kahve"
        ),
        Oxide(
            "Mangan Dioksit",
            "MnO₂",
            "Mor, kahverengi",
            "2-8%",
            "Her ikisi",
            "%2-4 mor-kahve, %6+ koyu kahve-siyah"
        ),
        Oxide(
            "Nikel Oksit",
            "NiO",
            "Gri, kahve, mavi",
            "1-3%",
            "Her ikisi",
            "Tek başına gri-kahve, diğer oksitlerle değişir"
        ),
        Oxide(
            "Vanadyum Pentoksit",
            "V₂O₅",
            "Sarı, yeşil-sarı",
            "3-8%",
            "Her ikisi",
            "Kalay ile sarı, zirkon ile turkuaz"
        ),
        Oxide(
            "Rutile (Titanyum)",
            "TiO₂",
            "Krem, sarımsı, leke",
            "2-10%",
            "Her ikisi",
            "Kristal ve renk lekesi yapar. Mat yüzey"
        ),
        Oxide(
            "İlmenit",
            "FeTiO₃",
            "Kahve, gri lekeler",
            "2-8%",
            "Her ikisi",
            "Granüler leke efekti, demir+titanyum"
        ),
        Oxide(
            "Kadmiyum-Selenyum",
            "CdS-Se",
            "Kırmızı, turuncu, sarı",
            "5-15%",
            "Düşük ateş",
            "Parlak kırmızı-sarı. Düşük sıcaklıkta (1000°C altı)"
        ),
        Oxide(
            "Kalay Oksit",
            "SnO₂",
            "Opak beyaz",
            "3-8%",
            "Her ikisi",
            "Opaklaştırıcı. Krom ile pembe, demir ile kırmızı-kahve"
        ),
        Oxide(
            "Zirkon",
            "ZrSiO₄",
            "Opak beyaz",
            "8-15%",
            "Her ikisi",
            "En iyi opaklaştırıcı. Vanadyum ile turkuaz"
        ),
        Oxide(
            "Praseodimium",
            "Pr₆O₁₁",
            "Sarı",
            "3-8%",
            "Her ikisi",
            "Temiz sarı, zirkon ile daha parlak"
        ),
        Oxide(
            "Altın (Mor)",
            "Au",
            "Mor, pembe, kırmızı",
            "0.01-0.5%",
            "Her ikisi",
            "Çok pahalı! Kolloidal altın, mor-pembe"
        ),
        Oxide(
            "Demir + Krom",
            "Fe₂O₃ + Cr₂O₃",
            "Siyah",
            "3-5% her biri",
            "Her ikisi",
            "İyi siyah için kombinasyon. Kobalt eklenebilir"
        ),
        Oxide(
            "Kobalt + Mangan",
            "CoO + MnO₂",
            "Mor-mavi",
            "1-2% Co, 3-4% Mn",
            "Her ikisi",
            "Mor tonları için klasik kombinasyon"
        ),
        Oxide(
            "Demir + Kobalt",
            "Fe₂O₃ + CoO",
            "Siyah-mavi",
            "3-5% Fe, 0.5-1% Co",
            "Her ikisi",
            "Koyu siyah-mavi, temmoku sırlarında"
        )
    )
}
