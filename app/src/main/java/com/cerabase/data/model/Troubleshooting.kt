package com.cerabase.data.model

data class TroubleshootingItem(
    val problem: String,
    val category: String,
    val causes: List<String>,
    val solutions: List<String>,
    val prevention: String
)

object TroubleshootingData {
    val items = listOf(
        TroubleshootingItem(
            problem = "Çatlaklar (Bisküvi)",
            category = "Kurutma/Pişirme",
            causes = listOf(
                "Çok hızlı kurutma",
                "Kalın ve ince duvar farklılıkları",
                "Yetersiz kuruma",
                "Çok hızlı ısıtma (özellikle 200-600°C)"
            ),
            solutions = listOf(
                "Parçayı yavaş ve eşit kurut",
                "Duvar kalınlıklarını eşitle",
                "Tam kuru olduğundan emin ol (24-48 saat)",
                "200-600°C arası çok yavaş ısıt (50-100°C/saat)"
            ),
            prevention = "Yavaş ve kontrollü kurutma, eşit kalınlık, kademeli ısıtma"
        ),
        TroubleshootingItem(
            problem = "S-Çatlağı (S-Crack)",
            category = "Tornalama",
            causes = listOf(
                "Kili çok sıkı merkezleme",
                "Tabanı çok hızlı açma",
                "Kuru hava kabarcıkları",
                "Nemli kil içinde sert noktalar"
            ),
            solutions = listOf(
                "Kili daha nazik merkezle",
                "Tabandan başlayarak yavaş çek",
                "Kili iyice yoğur, hava boşluklarını çıkar",
                "Kili vakum makinesinden geçir"
            ),
            prevention = "İyi yoğrulmuş kil, nazik tornalama, vakumlama"
        ),
        TroubleshootingItem(
            problem = "Patlama (Bisküvi)",
            category = "Pişirme",
            causes = listOf(
                "Kalın duvarlar",
                "Kil içinde hava kabarcıkları",
                "Yetersiz kuruma (su kalıntısı)",
                "Çok hızlı ısıtma (200°C öncesi)"
            ),
            solutions = listOf(
                "Kalın parçaları koyla (delikle)",
                "Kili vakumla veya çok iyi yoğur",
                "En az 1-2 hafta kurut",
                "İlk 200°C'ye kadar çok yavaş ısıt"
            ),
            prevention = "İnce duvarlar, vakumlu kil, tam kurutma, yavaş program"
        ),
        TroubleshootingItem(
            problem = "Sır Çatlağı (Crazing)",
            category = "Sır",
            causes = listOf(
                "Sırın genleşme katsayısı çok yüksek",
                "Bünye ve sır uyumsuzluğu",
                "Çok kalın sır tabakası",
                "Soğuma çok hızlı"
            ),
            solutions = listOf(
                "Sıra silika ekle (%5-10)",
                "Sırdan sodyum/potasyum azalt",
                "Sır tabakasını incelt",
                "Soğuma hızını azalt",
                "Sıra alümina ekle (%2-5)"
            ),
            prevention = "Genleşme testi yap, uyumlu sır-bünye, ince tabaka"
        ),
        TroubleshootingItem(
            problem = "Sır Soyulması (Shivering)",
            category = "Sır",
            causes = listOf(
                "Sırın genleşme katsayısı çok düşük",
                "Sır bünyeden daha az büzülür",
                "Sır çok sert/gergin"
            ),
            solutions = listOf(
                "Sıra feldspat/Na₂O ekle (%5)",
                "Sırdan silika azalt (%5)",
                "Bisküvi sıcaklığını artır",
                "Sır sıcaklığını azalt"
            ),
            prevention = "Genleşme testi, uyumlu formülasyon"
        ),
        TroubleshootingItem(
            problem = "Pinhole (İğne Delikleri)",
            category = "Sır Yüzeyi",
            causes = listOf(
                "Bisküvi çok gözenekli",
                "Sır çok kalın",
                "Sır çok hızlı kurur",
                "Gazlar sır içinde hapsolur",
                "Yetersiz olgunlaşma"
            ),
            solutions = listOf(
                "Bisküviyi daha yüksek sıcaklıkta pişir",
                "Sırı incelt",
                "Sıcaklıkta daha uzun bekle (soaking)",
                "Tepe sıcaklığını 20-30°C artır"
            ),
            prevention = "Yüksek bisküvi, ince sır, soaking süresi ekle"
        ),
        TroubleshootingItem(
            problem = "Sır Akması",
            category = "Sır",
            causes = listOf(
                "Sır çok kalın uygulanmış",
                "Sır çok akışkan (eritici fazla)",
                "Sıcaklık çok yüksek",
                "Sır formülü yanlış"
            ),
            solutions = listOf(
                "Sır tabakasını incelt",
                "Sıra silika/alümina ekle (%5-10)",
                "Pişirme sıcaklığını azalt",
                "Eritici miktarını azalt"
            ),
            prevention = "Deneme parçası yap, doğru kalınlık, test pişirimi"
        ),
        TroubleshootingItem(
            problem = "Mat Yüzey (İstenmeyen)",
            category = "Sır Yüzeyi",
            causes = listOf(
                "Yetersiz olgunlaşma",
                "Sır formülünde alümina fazla",
                "Sıcaklık çok düşük",
                "Çok hızlı soğuma"
            ),
            solutions = listOf(
                "Sıcaklığı 10-20°C artır",
                "Sırdan alümina azalt (%2-5)",
                "Soaking süresi ekle (15-30 dk)",
                "Daha yavaş soğut"
            ),
            prevention = "Doğru sıcaklık, formül testi, soaking"
        ),
        TroubleshootingItem(
            problem = "Renk Değişikliği",
            category = "Renk",
            causes = listOf(
                "Yanlış atmosfer (oksidasyon/redüksiyon)",
                "Sıcaklık yanlış",
                "Oksit yüzdesi yanlış",
                "Kirlenmeler"
            ),
            solutions = listOf(
                "Atmosferi kontrol et",
                "Sıcaklığı ayarla",
                "Oksit miktarını revize et",
                "Temiz çalış, kontaminasyonu önle"
            ),
            prevention = "Atmosfer kontrolü, test pişirim, temizlik"
        ),
        TroubleshootingItem(
            problem = "Sır Kristalleşmesi (İstenmeyen)",
            category = "Sır Yüzeyi",
            causes = listOf(
                "Çinko oksit fazla",
                "Titanyum fazla",
                "Çok yavaş soğuma",
                "Rutile fazla"
            ),
            solutions = listOf(
                "Çinko/titanyum azalt",
                "Daha hızlı soğut",
                "Kristalleşme bölgesinde (900-1100°C) hızlı geç"
            ),
            prevention = "Formül dengele, soğuma hızı kontrol et"
        ),
        TroubleshootingItem(
            problem = "Blistering (Kabarma)",
            category = "Sır Yüzeyi",
            causes = listOf(
                "Bisküvi çok düşük sıcaklıkta",
                "Organik maddeler yanmamış",
                "Karbonatlı maddeler çok fazla",
                "Sır altında gazlar hapsolmuş"
            ),
            solutions = listOf(
                "Bisküvi sıcaklığını artır",
                "Bisküvide daha uzun süre tut (500-900°C)",
                "Karbonatları azalt, fritlenmiş malzeme kullan",
                "Soaking süresi ekle"
            ),
            prevention = "Yüksek bisküvi, yavaş ısıtma, frit kullan"
        ),
        TroubleshootingItem(
            problem = "Dunting (Soğuma Çatlağı)",
            category = "Soğuma",
            causes = listOf(
                "Çok hızlı soğuma (özellikle 573°C)",
                "Kuvartzın inversiyon noktası",
                "Eşit olmayan soğuma",
                "Kalın parçalar"
            ),
            solutions = listOf(
                "573°C (kuvartz inversiyonu) civarında çok yavaş soğut",
                "Genel soğuma hızını azalt",
                "Fırını açma, soğumaya bırak",
                "Bünye formülünü revize et (daha az kuvartz)"
            ),
            prevention = "Kontrollü soğuma, 573°C'de ekstra yavaş"
        )
    )
}
