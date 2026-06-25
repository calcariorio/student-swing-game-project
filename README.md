# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
- **Name:** Calcario Yusuf Endrokusumo
- **Student ID (NRP):** 5026251185
- **Class:** Programming Fundamental

## Project Description
[cite_start]Aplikasi ini adalah game Tic-Tac-Toe sederhana yang dibangun menggunakan Java Swing GUI, konsep pemrograman berorientasi objek (OOP) dasar, dan penyimpanan database relasional satu tabel[cite: 25]. [cite_start]Proyek ini memenuhi tugas akhir praktikum Programming Fundamental[cite: 4, 5].

## Features
1. [cite_start]**Database-Backed Login:** Autentikasi pengguna secara real-time dari tabel database[cite: 98].
2. [cite_start]**Interactive Tic-Tac-Toe Game:** Arena tanding pemain (X) melawan komputer (O) dengan validasi langkah[cite: 109, 142].
3. [cite_start]**Real-time Statistics:** Mencatat jumlah Wins, Losses, Draws, dan akumulasi total skor langsung setelah game selesai[cite: 115].
4. [cite_start]**Top 5 Leaderboard:** Menampilkan peringkat 5 besar skor tertinggi menggunakan komponen `JTable`[cite: 117, 120].

## Class Architecture & Responsibility
- [cite_start]`Main`: Titik masuk awal program untuk meluncurkan jendela login[cite: 244].
- [cite_start]`DatabaseManager`: Mengatur konfigurasi driver JDBC dan koneksi ke MySQL[cite: 244].
- [cite_start]`Player`: Kelas model data untuk menyimpan informasi profil dan skor pemain[cite: 244].
- [cite_start]`playerService`: Menangani operasi query database (login, update statistik, dan leaderboard)[cite: 244].
- [cite_start]`GameLogic`: Mengatur aturan main game, validasi slot kosong, cek kondisi menang/seri, dan pergerakan bot[cite: 244].
- [cite_start]`Frames (GUI)`: `LoginFrame`, `MainMenuFrame`, `GameFrame`, `StatisticsFrame`, dan `TopScorersFrame` untuk interaksi user[cite: 244].

## Database Setup
1. Pastikan server MySQL (XAMPP/Bitnami) lu sudah berjalan pada port `3307`.
2. Buat database baru bernama `game_project`.
3. Impor berkas struktur tabel yang berada di folder `database/schema.sql`.

## How to Run
1. Buka proyek ini menggunakan IntelliJ IDEA.
2. [cite_start]Pastikan MySQL JDBC Driver sudah ditambahkan ke dalam dependencies modul proyek[cite: 685].
3. Sesuaikan konfigurasi `USER` dan `PASSWORD` database lu pada file `DatabaseManager.java`.
4. [cite_start]Jalankan berkas `Main.java`[cite: 259].
