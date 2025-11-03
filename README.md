# Hayang Jajan - Android Food Delivery App

## Made by : Ananda Novianshaf

### This project was created by me in order to learn about android development using Kotlin in Android Studio

## Tentang Proyek Ini

Aplikasi ini adalah prototipe (purwarupa) UI/UX fungsional untuk layanan pesan-antar makanan bernama "Hayang Jajan". Fokus utama dari proyek ini adalah untuk membangun frontend yang lengkap dan menarik secara visual, murni menggunakan pengembangan Android native (Kotlin, XML Layouts, dan Android Studio).

Perlu dicatat bahwa aplikasi ini **belum terhubung ke *backend* atau *database* sungguhan**. Semua data yang ditampilkan (seperti daftar menu, harga, item di keranjang, dan profil pengguna) adalah **data dummy** (data palsu) yang di-*hardcode* di dalam file Kotlin (`Adapter` dan `Fragment`) hanya untuk mengisi tampilan dan menguji alur navigasi.

## Fitur Inti UI/UX yang Sudah Diimplementasikan

Aplikasi ini dibangun sebagai **Single-Activity** menggunakan **Android Navigation Component** untuk mengelola semua perpindahan layar.

Fitur-fitur UI yang sudah selesai meliputi:

* **Alur Autentikasi (Auth Flow):**
    * `Splash Screen` (Halaman Pembuka) dengan gambar latar dan tombol.
    * `Login Screen` (Halaman Login) dengan *form* dan opsi "Login via" Google/Facebook.
    * `Sign Up Screen` (Halaman Daftar) dengan *form* lengkap dan tautan kembali ke Login.

* **Alur Utama Aplikasi (Main App Flow):**
    * `BottomNavigationView` (Menu Navigasi Bawah) yang persisten untuk 3 *tab* utama: Home, Cart, dan Me (Profile).
    * `Home Screen` ("Menu Alus" & "Menu Paling Rame") menggunakan dua `RecyclerView` (satu horizontal, satu vertikal) dengan *Adapter* kustom untuk menampilkan data *dummy*.
    * `Profile Screen` ("Informasi Abdi") yang menampilkan informasi statis pengguna dan tombol **Log Out** fungsional yang membersihkan *back stack* dan kembali ke halaman Login.

* **Alur Checkout Lengkap (Multi-Step):**
    1.  `Product Detail Screen` ("Martabak"): Halaman detail yang menampilkan info produk, `RecyclerView` horizontal untuk *add-on*, dan penghitung kuantitas (+/-).
    2.  `Cart Screen` ("Cart Urang"): Menampilkan *stepper* (langkah 1-2-3), `RecyclerView` untuk item di keranjang, dan kontrol kuantitas (+/-) yang berfungsi (untuk data *dummy*).
    3.  `Address Screen` ("Alamat Maneh"): Halaman *form* yang menggunakan `TextInputLayout` untuk mengisi alamat, lengkap dengan *stepper* yang sudah di-update.
    4.  `Payment Screen` ("Gass Checkout"): Halaman terakhir dengan *stepper* yang sudah selesai dan *grid layout* untuk memilih metode pembayaran.

* **Styling & Fitur Lainnya:**
    * Penggunaan *font* kustom di seluruh aplikasi menggunakan *Font Family* XML.
    * Penggunaan *Custom Drawable* (XML) untuk ikon, tombol, dan *background*.
    * Penggunaan `MaterialCardView` dan `ConstraintLayout` untuk membangun desain yang responsif dan sesuai dengan Figma.

## Screenshots

*(Ganda ganti "..." dengan path ke gambar Anda, misal: ./screenshots/home.png)*

**Screenshot Landing/Splash Screen**
...

**Screenshot Login Screen**
...

**Screenshot Sign Up Screen**
...

**Screenshot Home Screen**
...

**Screenshot Product Detail Screen**
...

**Screenshot Cart Screen (Checkout Step 1)**
...

**Screenshot Address Screen (Checkout Step 2)**
...

**Screenshot Payment Screen (Checkout Step 3)**
...

**Screenshot Profile Screen**
...
