# Hayang Jajan - Android Food Delivery App

## Made by : Ananda Novianshaf - 1237050054

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

## Screenshots Android Developer Course
**Bukti Sampai Unit 3**
![WhatsApp Image 2025-10-31 at 17 36 26_4142be0b](https://github.com/user-attachments/assets/2d6f758b-8db1-4719-b1d0-61608bbdb4d2)
![WhatsApp Image 2025-10-31 at 17 37 01_91e15a09](https://github.com/user-attachments/assets/d13e67dc-03ea-4b23-b96c-10628d6f8ef2)

## Screenshots Aplikasi Android - Hayang Jajan
<h3 align="center">Screenshot Landing/Splash Screen</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/c93485a3-7783-4da1-94d0-10c364b948ea" alt="Screenshot Cart Header" width="400">
</p>

<h3 align="center">Screenshot Login Screen</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/fc8731db-287d-428f-aae2-34345a8eaf1e" alt="Screenshot Cart Item 1" width="400">
</p>

<h3 align="center">Screenshot Sign Up Screen</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/c047d7ef-d7cd-40f8-ba98-419e36464914" alt="Screenshot Cart Item 2" width="400">
</p>

<h3 align="center">Screenshot Home Screen</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/fbe483ac-d121-4522-8dd3-3739cd568e67" alt="Screenshot Address Page" width="400">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/2adcb322-20af-43c0-97a7-115eb4151b08" alt="Screenshot Address Form" width="400">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/3949fb80-69ec-4d64-b008-c62e1b42319e" alt="Screenshot Payment Page" width="400">
</p>

<h3 align="center">Screenshot Product Detail Screen</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/b1397706-6b2b-42bb-adb5-46f8757d75df" alt="WhatsApp Image 2025-11-04 at 00 31 54_9a6af032" width="400">
</p>

<h3 align="center">Screenshot Cart Screen (Checkout Step 1)</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/96386ed2-9c38-47c3-8932-01865a4213c0" alt="WhatsApp Image 2025-11-04 at 00 31 54_c362a788" width="400">
</p>

<h3 align="center">Screenshot Address Screen (Checkout Step 2)</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/f22d4360-b49d-43be-b75c-710990e17457" alt="WhatsApp Image 2025-11-04 at 00 31 54_2b2fc076" width="400">
</p>


<h3 align="center">Screenshot Payment Screen (Checkout Step 3)</h3>

<p align="center">
  <img src="https://github.com/user-attachments/assets/07de901d-404d-4971-a47c-966ffbe807c6" alt="WhatsApp Image 2025-11-04 at 00 31 55_98c11498" width="400">
</p>

<h3 align="center">Screenshot Profile Screen</h3>


<p align="center">
  <img src="https://github.com/user-attachments/assets/9b645f77-4bac-4b36-8cfa-f1a52b9242c6" alt="WhatsApp Image 2025-11-04 at 00 31 55_3b2ec75d" width="400">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/f004b84b-3fae-4f2d-bf3e-a9f8bfdd7bda" alt="WhatsApp Image 2025-11-04 at 00 31 55_c4cc0d31" width="400">
</p>

