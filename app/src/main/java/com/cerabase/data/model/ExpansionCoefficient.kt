package com.cerabase.data.model

data class ExpansionCoefficient(
    val material: String,
    val coefficient: String,
    val range: String,
    val category: String,
    val notes: String
)

object ExpansionCoefficientData {
    val coefficients = listOf(
        // Oksitler
        ExpansionCoefficient(
            "Silika (SiO₂)",
            "0.5",
            "0.4-0.6",
            "Oksit",
            "En düşük genleşme, sırın çatlamasını önler"
        ),
        ExpansionCoefficient(
            "Alümina (Al₂O₃)",
            "8.8",
            "8.0-9.5",
            "Oksit",
            "Sırı sertleştirir, çatlama riskini azaltır"
        ),
        ExpansionCoefficient(
            "Kalsiyum Oksit (CaO)",
            "15.0",
            "14-16",
            "Oksit",
            "Orta genleşme, sır akışkanlığı artırır"
        ),
        ExpansionCoefficient(
            "Magnezyum Oksit (MgO)",
            "13.5",
            "12-15",
            "Oksit",
            "Mat yüzeyler, orta genleşme"
        ),
        ExpansionCoefficient(
            "Sodyum Oksit (Na₂O)",
            "39.0",
            "35-42",
            "Oksit",
            "Çok yüksek genleşme! Çatlama riski"
        ),
        ExpansionCoefficient(
            "Potasyum Oksit (K₂O)",
            "40.0",
            "38-43",
            "Oksit",
            "Çok yüksek genleşme, parlak yüzey"
        ),
        ExpansionCoefficient(
            "Lityum Oksit (Li₂O)",
            "27.0",
            "25-30",
            "Oksit",
            "Yüksek genleşme, düşük erime noktası"
        ),
        ExpansionCoefficient(
            "Çinko Oksit (ZnO)",
            "6.5",
            "5-8",
            "Oksit",
            "Düşük genleşme, parlak yüzey"
        ),
        ExpansionCoefficient(
            "Baryum Oksit (BaO)",
            "18.0",
            "16-20",
            "Oksit",
            "Yüksek genleşme, mat yüzey"
        ),
        ExpansionCoefficient(
            "Demir Oksit (Fe₂O₃)",
            "14.9",
            "13-16",
            "Oksit",
            "Renklendirici, orta genleşme"
        ),

        // Hammaddeler
        ExpansionCoefficient(
            "Kaolin",
            "6.0",
            "5-7",
            "Kil",
            "Düşük genleşme, plastiklik verir"
        ),
        ExpansionCoefficient(
            "Ball Clay",
            "7.0",
            "6-8",
            "Kil",
            "Düşük genleşme, yüksek plastiklik"
        ),
        ExpansionCoefficient(
            "Feldspat (Potasyum)",
            "8.0",
            "7-9",
            "Eritici",
            "Düşük genleşme, eriyen"
        ),
        ExpansionCoefficient(
            "Nefelin Siyenit",
            "7.5",
            "7-8",
            "Eritici",
            "Düşük genleşme, Na₂O kaynağı"
        ),
        ExpansionCoefficient(
            "Talk",
            "10.0",
            "9-11",
            "Eritici",
            "Orta genleşme, MgO kaynağı"
        ),
        ExpansionCoefficient(
            "Kuvars",
            "1.5",
            "1-2",
            "Dolgu",
            "Çok düşük genleşme"
        ),
        ExpansionCoefficient(
            "Whiting (Kalsit)",
            "25.0",
            "23-27",
            "Eritici",
            "Yüksek genleşme, CaO kaynağı"
        ),
        ExpansionCoefficient(
            "Dolomit",
            "20.0",
            "18-22",
            "Eritici",
            "Yüksek genleşme, Ca+Mg kaynağı"
        ),
        ExpansionCoefficient(
            "Bor Bileşikleri",
            "4.0",
            "3-5",
            "Eritici",
            "Düşük genleşme, düşük erime"
        ),
        ExpansionCoefficient(
            "Çin Taşı (Petuntse)",
            "7.0",
            "6-8",
            "Bünye",
            "Düşük genleşme, porselen için"
        ),

        // Frit ve Camlar
        ExpansionCoefficient(
            "Boraks Friti",
            "5.0",
            "4-6",
            "Frit",
            "Düşük genleşme, parlak yüzey"
        ),
        ExpansionCoefficient(
            "Kurşun Friti",
            "9.0",
            "8-10",
            "Frit",
            "Orta genleşme, parlak yüzey"
        ),
        ExpansionCoefficient(
            "Zirkon (ZrSiO₄)",
            "4.0",
            "3-5",
            "Opaklaştırıcı",
            "Çok düşük genleşme, beyazlatıcı"
        ),
        ExpansionCoefficient(
            "Kalay Oksit (SnO₂)",
            "4.5",
            "4-5",
            "Opaklaştırıcı",
            "Düşük genleşme, opak beyaz"
        )
    )
}
