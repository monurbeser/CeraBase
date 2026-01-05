# CeraBase 🏺

Seramik sanatçıları ve öğrencileri için kapsamlı referans ve yardımcı uygulaması. Pia Ceramic tarafından geliştirilmiştir.

**Sürüm:** 1.2.0
**Build:** 2
**Platform:** Android 7.0+ (API 24+)

## 📱 Özellikler

### 📚 Temel İçerik Kategorileri

#### 🔥 Seger Koni Tabloları
- 32 farklı Seger konisinin sıcaklık referansları
- Celsius ve Fahrenheit değerleri
- Kiln içindeki sıcaklık ölçümü için essential rehber

#### 🎨 Oksitler (Colorants)
- 20+ seramik oksit ve renklendirici
- Çıkış rengine göre filtreleme
- Pişirim tipi bilgisi (Oksidasyon, Redüksiyon, Her ikisi)
- Kullanım yüzdesi ve uygulaması

#### 📊 Genleşme Katsayıları (Expansion Coefficients)
- 24+ malzemenin ısıl genleşme verileri
- Kategori bazında sınıflandırma
- Clay/Glaze uyumluluğu hesaplamalarında kullanılır

#### 🏺 Clay Formülleri
- 13+ profesyonel clay body formülü
- Kategori: Porselen, Taş Bünye, Gres, Toprak, Raku, Heykel, vb.
- Malzeme oranları ve pişirim konileri
- Maddi özellikleri ve kullanım alanları

#### 🔧 Sorun Giderme Rehberi
- 13+ yaygın seramik problemleri
- Nedenleri, çözümleri ve önlemleri
- Kategori bazında organizeisyon
- Kurutma, pişirim, sır, renk sorunları ve daha fazlası

### 🆕 Sürüm 1.2.0 - Pia Ceramic Branding & Yeni Özellikler

#### 1. 🎨 Branding Güncellemesi
- Yeni uygulama ikonu (Seramik pot tasarımı)
- Güncellenmiş Splash Screen
- Pia Ceramic marka entegrasyonu
- Sıcak bej ve turuncu renk şeması

#### 2. ℹ️ Hakkında (About) Ekranı
- Pia Ceramic marka bilgisi
- Sürüm ve Build numarası
- Paket adı ve uygulama detayları
- Copyright ve kullanım koşulları

#### 3. 💾 Kendi Formüllerini Kaydet (Save Custom Formulas)
- Özel clay formülleri oluşturun
- Adı, tipi (Porcelain, Stoneware, vb.), koni
- Malzeme listesi, notlar ve özellikleri kaydedin
- Favori formüllerinizi sakla
- Silme ve düzenleme işlemleri

#### 4. 📊 En Çok Kullanılanlar (Most Used Items)
- En sık aranan ve görüntülenen içerikler
- Görüntülenme sayısına göre sıralama
- Visual progress bar ile popülarite gösterimi
- Kategori bazında filtreleme
- Trending içerik keşfetme

#### 5. ❤️ Favoriler/Bookmarks Sistemi
- Tüm içerikleri favorilere ekleyin
- Kalp ikonu ile hızlı erişim (tüm detail ekranlarında)
- Kategori bazında gruplandırma
- Ayrı Favoriler ekranında görüntüleme
- Silme ve yönetim işlemleri
- Detail ekranlarında inline favorite butonu

#### 6. 📋 Copy-to-Clipboard
- Teknik verileri kolayca kopyalayın
- Tüm detail ekranlarında kullanılabilir
- Snackbar bildirimiyle kopyalama onayı
- Formula, sıcaklık, özellikleri hızlıca kopyala

#### 7. 🌡️ Sıcaklık Dönüştürücü (Temperature Converter)
- Celsius ↔ Fahrenheit gerçek zamanlı dönüşümü
- Seger Cone numarasından sıcaklık araması
- Hızlı referans tablosu
- Ortak konilerin sıcaklık değerleri
- Kiln hesaplamalarında kullanım

#### 8. ⭐ Detail Ekranlarında Favorite Butonları
- Tüm kategori detail ekranlarında kalp ikonu
- Hızlı favorilere ekleme/çıkarma
- Responsive UI (turuncu renkte gösterimi)
- Persistent favorit durumu
- SegerCones, Oxides, Expansion, Clay Formulas, Troubleshooting

#### 9. 🔍 Gelişmiş Arama - Fuzzy Match & Arama Geçmişi
- **Fuzzy Matching Algorithm**: Yazım hataları toleranslı arama
  - Minimum %40 match threshold
  - Relevans puanına göre sırala
  - Partial matches ve character sequences
- **Search History**: Son aramaları kaydet ve hızlıca tekrar kullan
  - Benzersiz sorguları göster
  - Tıkla ve tekrar ara
  - Arama ekranında hızlı erişim

### 📈 İçerik Yönetimi

#### 🔍 Gelişmiş Arama
- Tüm kategorilerde full-text arama
- 🎯 **Fuzzy Matching** - Yazım hataları toleranslı arama
- 📜 **Arama Geçmişi** - Son aramaları kaydedip hızlıca tekrar kullan
- Kategori bazında sonuç filtreleme
- Hızlı ve doğru arama sonuçları
- İçerik kategorilerine direkt yönlendirme
- Sonuçlar relevansa göre sıralanır

#### 📌 Görüntüleme İstatistikleri
- Tüm içeriğin görüntülenme sayısı takibi
- En çok ziyaret edilen içerikler
- Kişiselleştirilmiş öneriler
- Usage analytics

### 🎯 Kullanıcı Arayüzü

#### 🎨 Material Design 3
- Modern Material 3 tasarım sistemi
- Pia Ceramic özel renk şeması
- Dark/Light tema desteği
- Responsive ve hızlı arayüz

#### 🌙 Dark Mode
- Tam dark mode desteği
- Kullanıcı tercihine göre otomatik
- DataStore'da tercih kaydı

#### 🇹🇷 Türkçe Lokalizasyon
- Tamamen Türkçe kullanıcı arayüzü
- Tüm terimleri seramik alanında uyarlanmış
- Detaylı Türkçe açıklamalar

## 🛠️ Teknoloji Stack

### Android
- **Kotlin** - Modern Android dili
- **Jetpack Compose** - Deklaratif UI framework
- **Material 3** - Google'ın latest design system
- **Room Database** - Lokal veri depolama
- **DataStore** - Kullanıcı tercihleri
- **Lifecycle & ViewModel** - State yönetimi
- **Coroutines** - Asynchronous programming

### Mimarileri
- **MVVM-style Composition** - Clean architecture
- **Custom Navigation Router** - Type-safe navigation
- **Repository Pattern** - Data access abstraction

## 📊 Veri Tabanı

### Tables
- `favorites` - Kullanıcı favori öğeleri
- `custom_clay_formulas` - Kullanıcı tarafından oluşturulan formüller
- `usage_tracking` - İçerik görüntülenme istatistikleri
- `search_history` - Kullanıcı arama geçmişi

### Versiyon: 3

## 🚀 Kurulum

### Gereksinimler
- Android Studio Arctic Fox+
- Kotlin 1.9.24+
- Gradle 8.4+
- Android SDK 34 (API Level 34)
- Minimum API Level: 24 (Android 7.0)

### Build Etme
```bash
./gradlew build
./gradlew installDebug
```

## 📝 Release Notes

### v1.2.0 (2025-01-05)

#### ✨ Yeni Özellikler
- 🎨 **Branding Güncellemesi**: Pia Ceramic marka ile yeni icon ve splash screen
- 💾 **Custom Formula Storage**: Kendi clay formüllerinizi oluşturun ve kaydedin
- 📊 **Most Used Items**: En çok kullanılan içerikleri keşfedin
- ❤️ **Favorites System**: Sevdiğiniz içerikleri favorilere ekleyin
- ⭐ **Favorite Buttons**: Tüm detail ekranlarında kalp ikonu ile favorilere hızlıca ekle/çıkar
- 📋 **Copy to Clipboard**: Teknik verileri kolayca kopyalayın
- 🌡️ **Temperature Converter**: Seger cone, Celsius ve Fahrenheit dönüşümü
- 🔍 **Fuzzy Match Search**: Yazım hatalarına toleranslı akıllı arama
- 📜 **Search History**: Son aramaları kaydet ve hızlıca tekrar kullan
- ℹ️ **About Screen**: Pia Ceramic bilgisi ve sürüm detayları

#### 🔧 İyileştirmeler
- View tracking tüm kategori ekranlarında
- Dinamik build numarası About ekranında
- Enhanced UI/UX seramik renk şeması ile
- Database versiyonu 1 → 2 → 3 (custom formulas, usage tracking, search history)
- Fuzzy matching algoritması arama sonuçlarını relevansa göre sırala
- Arama sonuçları yazım hatalarına toleranslı
- Search history persistence ve quick access

#### 🐛 Bug Fixes
- BuildConfig import sorunları çözüldü
- Navigation flow iyileştirildi

### v1.1.0
- Arama işlevselliği
- Room Database temeli
- İlk kategori detay ekranları

### v1.0.0
- İlk sürüm
- 5 ana kategori (Seger Cones, Expansion, Oxides, Clay Formulas, Troubleshooting)
- Temel arama
- Dark mode desteği

## 📱 Ekranlar

```
Home (Ana Sayfa)
├── 🔥 Seger Koni Tabloları
├── 📊 Genleşme Katsayıları
├── 🎨 Oksitler
├── 🏺 Clay Formülleri
├── 🔧 Sorun Giderme
├── 📝 Kendi Formüllerim
├── 📊 En Çok Kullanılanlar
└── 🌡️ Sıcaklık Dönüştürücü

Arama
├── Tüm kategorilerde arama
├── 🔍 Fuzzy match (yazım hataları toleranslı)
├── 📜 Arama geçmişi
└── Kategori filtreleme

Favorilerim
├── Tüm favori öğeler
├── Kategori gösterimi
└── Silme işlemleri

Sıcaklık Dönüştürücü
├── C ↔ F dönüşümü
├── Cone araması
└── Referans tablosu

Kendi Formüllerim
├── Formül listesi
├── Yeni formül oluştur
└── Silme işlemleri

Hakkında
├── Pia Ceramic bilgisi
├── Sürüm numarası
└── Sürüm Notları
```

## 🎯 Hedeflenen Kullanıcılar

- 🎨 Seramik sanatçıları
- 📚 Seramik öğrencileri
- 🏭 Endüstri profesyonelleri
- 🔬 Araştırma ve geliştirme

## 💡 Gelecek Planları

- [ ] Glaze formula database
- [ ] Firing curve rehberi
- [ ] Video tutorial entegrasyonu
- [ ] Community formulas paylaşımı
- [ ] Export PDF rapor
- [ ] Offline mod iyileştirmesi
- [ ] Multi-language desteği (EN, ES, FR)
- [ ] Advanced formula calculator

## 📄 Lisans

Copyright © 2025 Pia Ceramic. Tüm hakları saklıdır.

## 📧 İletişim

Sorularınız ve önerileriniz için GitHub Issues'ı kullanabilirsiniz.

---

**CeraBase** - Seramik Sanatçıları İçin Eksiksiz Referans Platformu 🏺
